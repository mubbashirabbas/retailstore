package com.cc.retailstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cc.retailstore.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Long>{

}
