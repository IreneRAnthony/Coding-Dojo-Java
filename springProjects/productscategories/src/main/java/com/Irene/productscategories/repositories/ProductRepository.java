package com.Irene.productscategories.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.Irene.productscategories.models.Product;

public interface ProductRepository extends CrudRepository <Product, Long> {
	List<Product> findAll();
	List<Product> findByName(String name);
}
