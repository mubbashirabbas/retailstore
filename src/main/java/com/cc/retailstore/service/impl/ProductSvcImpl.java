package com.cc.retailstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.retailstore.dao.ProductDao;
import com.cc.retailstore.model.Product;
import com.cc.retailstore.service.ProductSvc;

@Service
public class ProductSvcImpl implements ProductSvc {
	
	@Autowired
	private ProductDao prodDao;
	
	@Override
	public Product findProduct(Long prodId) {
		return prodDao.findOne(prodId);
	}

	@Override
	public Iterable<Product> findProducts(List<Long> prodIds) {
		return prodDao.findAll(prodIds);
	}

}
