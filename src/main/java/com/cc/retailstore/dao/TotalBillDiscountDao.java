package com.cc.retailstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cc.retailstore.model.AdditionalBillDiscount;

@Repository
public interface TotalBillDiscountDao extends CrudRepository<AdditionalBillDiscount, Long>{

}
