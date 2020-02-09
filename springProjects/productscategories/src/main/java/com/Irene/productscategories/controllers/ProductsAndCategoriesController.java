package com.Irene.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Irene.productscategories.models.Category;
import com.Irene.productscategories.models.CategoryProduct;
import com.Irene.productscategories.models.Product;
import com.Irene.productscategories.services.CategoryService;
import com.Irene.productscategories.services.ProductService;

@Controller
public class ProductsAndCategoriesController {

	private final ProductService productService;
	private final CategoryService categoryService;

	public ProductsAndCategoriesController(ProductService productService, CategoryService categoryService){
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = "/categories/new", method = RequestMethod.GET)
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@RequestMapping(value = "/categories/new", method = RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/"+category.getId();
		}
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public String showCategory(@PathVariable(value = "id")Long id, @ModelAttribute("categoryProduct") CategoryProduct catProduct, Model model) {
		Category allCategory = categoryService.findCategory(id);
		model.addAttribute("cat", allCategory);
		List<Product> currentProduct = allCategory.getProducts();
		model.addAttribute("currentProduct", currentProduct);
		List <Product> product = productService.allProduct();
		model.addAttribute("product", product);
		return "showCategory.jsp";
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
	public String updateCategory(@PathVariable(value="id") Long id, @ModelAttribute("categoryProduct") CategoryProduct catProduct) {
		Category currentCategory = categoryService.findCategory(id);
		catProduct.setCategory(currentCategory);
		categoryService.updateCategory(catProduct);
		return "redirect:/categories/{id}";
	}
	
	@RequestMapping(value = "/products/new", method = RequestMethod.GET)
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/"+product.getId();
		}
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public String showProducts(@PathVariable(value = "id") Long id, @ModelAttribute("categoryProduct") CategoryProduct catProd, Model model) {
		Product currentProduct = productService.findProduct(id);
		model.addAttribute("product", currentProduct);
		List <Category> categoryList = currentProduct.getCategories();
		model.addAttribute("currentCat", categoryList);
		List<Category> category = categoryService.allCategory();
		model.addAttribute("category", category);
		return "showProduct.jsp";
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
	public String updateProduct(@PathVariable(value="id") Long id, @ModelAttribute("categoryProduct") CategoryProduct catProd) {
		Product currentProduct = productService.findProduct(id);
		
		catProd.setProduct(currentProduct);
		productService.updateProduct(catProd);
		return "redirect:/products/{id}";
	}
	
	
}
