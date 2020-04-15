package com.cc.retailstore.service;

import java.util.Date;

import com.cc.retailstore.model.LoyaltyDiscount;

public interface LoyaltyDiscountSvc {
	public LoyaltyDiscount getDiscountForUser(Date date);
}
