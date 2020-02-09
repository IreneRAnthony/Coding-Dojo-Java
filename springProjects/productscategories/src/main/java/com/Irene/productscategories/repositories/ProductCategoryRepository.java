package com.Irene.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Irene.productscategories.models.CategoryProduct;

@Repository
public interface ProductCategoryRepository extends CrudRepository <CategoryProduct, Long> {

}
