package com.Irene.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Irene.productscategories.models.Category;
import com.Irene.productscategories.models.CategoryProduct;
import com.Irene.productscategories.repositories.CategoryRepository;
import com.Irene.productscategories.repositories.ProductCategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final ProductCategoryRepository productCategoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository, ProductCategoryRepository productCategoryRepository) {
		this.categoryRepository = categoryRepository;
		this.productCategoryRepository = productCategoryRepository;
	}
	
	public List<Category> allCategory(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category b) {
		return categoryRepository.save(b);
	}
	
	public Category findCategory(Long id) {
		Optional <Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
	
	public CategoryProduct updateCategory(CategoryProduct category) {
		return productCategoryRepository.save(category);
	 	}
	
}
