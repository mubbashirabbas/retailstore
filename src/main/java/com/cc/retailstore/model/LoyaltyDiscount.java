package com.cc.retailstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_loyalty_discount")
public class LoyaltyDiscount extends BaseBean {

	@Column(name="required_tenure_in_days")
	private long tenure;
	
	@Column(name="discount")
	private float tenureDiscount;

	public long getTenure() {
		return tenure;
	}

	public void setTenure(long tenure) {
		this.tenure = tenure;
	}

	public float getTenureDiscount() {
		return tenureDiscount;
	}

	public void setTenureDiscount(float tenureDiscount) {
		this.tenureDiscount = tenureDiscount;
	}
}
