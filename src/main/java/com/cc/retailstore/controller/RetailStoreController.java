package com.cc.retailstore.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cc.retailstore.model.AdditionalBillDiscount;
import com.cc.retailstore.model.BillDetails;
import com.cc.retailstore.model.LoyaltyDiscount;
import com.cc.retailstore.model.PercentageDiscount;
import com.cc.retailstore.model.Product;
import com.cc.retailstore.model.User;
import com.cc.retailstore.service.BillDiscountSvc;
import com.cc.retailstore.service.LoyaltyDiscountSvc;
import com.cc.retailstore.service.ProductSvc;
import com.cc.retailstore.service.UserSvc;

@RestController
public class RetailStoreController {
	
	@Autowired
	private LoyaltyDiscountSvc loyaltyDiscountSvc;
	
	@Autowired
	private ProductSvc productSvc;
	
	@Autowired 
	private BillDiscountSvc billDiscountSvc;
	
	@Autowired
	private UserSvc userSvc;
	
	@RequestMapping("/dummy")
	public String dummyController() {
		return "Mubbashir";
	}
	
	@RequestMapping(value="/placeOrder/{productIds}/{userId}", method=RequestMethod.GET)
	public BillDetails placeOrder(@PathVariable List<Long> productIds,@PathVariable Long userId) {
		User user = userSvc.loadUser(userId);
		Iterable<Product> selectedProducts = productSvc.findProducts(productIds);
		
		// discount applicable on the entire build post application of percentage discount
		AdditionalBillDiscount additionalBillDiscount = billDiscountSvc.findAdditionalDiscountDetail(); 
		// loyalty - customer has been with us for more than two years
		LoyaltyDiscount loyaltyDiscount = loyaltyDiscountSvc.getDiscountForUser(user.getCreatedDate()); 	
		
		float totalAmountBeforeDiscount = getTotalAmountBeforeDiscount(selectedProducts);
		float highestDiscountAvailable = getHighestDiscountAvailable(user, loyaltyDiscount.getTenureDiscount());
		
		float totalPercentageDiscount = getInitialDiscount(selectedProducts, highestDiscountAvailable); // based on max percentage applicable
		float additionalDiscountAvailable = getAdditionalDiscountOverBillingAmount(additionalBillDiscount, totalAmountBeforeDiscount);
		
		return new BillDetails(user.getId(), user.getLastName(), totalAmountBeforeDiscount, totalPercentageDiscount, additionalDiscountAvailable);
	}
	
	private float getAdditionalDiscountOverBillingAmount(AdditionalBillDiscount additionalBillDiscount, float totalAmount) {
		float additionalDiscount = 0;
		float amountDiscountApplicableOn = 0;
		float discountAvailableOnAmount = 0;
		
		if (additionalBillDiscount != null) {
			amountDiscountApplicableOn = additionalBillDiscount.getAmount();
			discountAvailableOnAmount = additionalBillDiscount.getApplicableDiscount();
			additionalDiscount = (float) (Math.floor(totalAmount/amountDiscountApplicableOn) * discountAvailableOnAmount);
		}
		return additionalDiscount;
	}
	
	private float getTotalAmountBeforeDiscount(Iterable<Product> products) {
		float totalBill = 0;
		Iterator<Product> prodIterator = products.iterator();
		while(prodIterator.hasNext()) {
			Product prod= (Product) prodIterator.next();
			totalBill += prod.getPrice();
		}
		return totalBill;
	}

	private float getInitialDiscount(Iterable<Product> products, float highestDiscount) {
		float associationDiscountsOnGrocery = 0;
		Iterator<Product> prodIterator = products.iterator();
		while(prodIterator.hasNext()) {
			Product prod= (Product) prodIterator.next();
			if (!prod.getType().equals("GROCERY")){
				associationDiscountsOnGrocery += prod.getPrice() * highestDiscount;
			}
		}
		return associationDiscountsOnGrocery;
	}
	
	private float getHighestDiscountAvailable(User user, float loyaltyDiscount) {
		float highestDiscount = loyaltyDiscount;
		List<PercentageDiscount> percentageDiscounts = user.getPercentageDiscount();
		for(PercentageDiscount perDiscount : percentageDiscounts) {
			if (perDiscount.getPercentageDiscount() > highestDiscount) {
				highestDiscount = perDiscount.getPercentageDiscount();
			}
		}
		return highestDiscount;
	}
	
}
