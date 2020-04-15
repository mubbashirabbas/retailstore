package com.cc.retailstore.service;

import java.util.List;

import com.cc.retailstore.model.Product;

public interface ProductSvc {
	public Product findProduct(Long prodId);
	
	public Iterable<Product> findProducts(List<Long> prodIds);
}
