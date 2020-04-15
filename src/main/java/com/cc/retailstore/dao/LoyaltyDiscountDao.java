package com.cc.retailstore.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cc.retailstore.model.LoyaltyDiscount;

@Repository
public interface LoyaltyDiscountDao extends CrudRepository<LoyaltyDiscount, Long>{
	@Query(value="from LoyaltyDiscount where tenure < :days")
	public LoyaltyDiscount getDiscountsIfCreatedBefore(@Param("days") long days);
}
