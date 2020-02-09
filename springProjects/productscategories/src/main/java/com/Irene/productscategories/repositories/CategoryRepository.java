package com.Irene.productscategories.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.Irene.productscategories.models.Category;

public interface CategoryRepository extends CrudRepository <Category, Long>{
	List<Category> findAll();
	List<Category> findByName(String name);
}
