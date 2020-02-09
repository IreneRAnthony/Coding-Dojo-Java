package com.Irene.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.productscategories.models.CategoryProduct;
import com.Irene.productscategories.models.Product;
import com.Irene.productscategories.repositories.ProductCategoryRepository;
import com.Irene.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	private final ProductCategoryRepository productCategoryRepository;
	
	public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
		this.productRepository = productRepository;
		this.productCategoryRepository = productCategoryRepository;
	}
	
	public List<Product> allProduct(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product b) {
		return productRepository.save(b);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public Product findProduct(Long id) {
		Optional <Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public CategoryProduct updateProduct(CategoryProduct product) {
		 return productCategoryRepository.save(product);
	 	}
	
}
