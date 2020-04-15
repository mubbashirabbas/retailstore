package com.cc.retailstore.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.retailstore.dao.LoyaltyDiscountDao;
import com.cc.retailstore.model.LoyaltyDiscount;
import com.cc.retailstore.service.LoyaltyDiscountSvc;

@Service
public class LoyaltyDiscountSvcImpl implements LoyaltyDiscountSvc{

	@Autowired
	private LoyaltyDiscountDao loyaltyDiscountDao;
	
	@Override
	public LoyaltyDiscount getDiscountForUser(Date date) {
		long days = ChronoUnit.DAYS.between(date.toInstant(),new Date().toInstant());
		return loyaltyDiscountDao.getDiscountsIfCreatedBefore(days);
	}

}
