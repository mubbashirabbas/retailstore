package com.cc.retailstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_total_bill_discount")
public class AdditionalBillDiscount extends BaseBean{

	@Column(name="amount")
	private float amount;
	
	@Column(name="discount")
	private float applicableDiscount;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getApplicableDiscount() {
		return applicableDiscount;
	}

	public void setApplicableDiscount(float applicableDiscount) {
		this.applicableDiscount = applicableDiscount;
	}
}
