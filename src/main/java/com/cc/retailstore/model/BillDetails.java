package com.cc.retailstore.model;

public class BillDetails{
	private long customerId;
	
	private String customerName;
	
	private float totalBill;
	
	private float associationDiscount;
			
	private float billDiscount;
	
	private float totalDiscount;
	
	private float finalBill;

	public BillDetails() {
		
	}
	
	public BillDetails(long customerId, String customerName, float totalBill, float associationDiscount, float billDiscount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalBill = totalBill;
		this.associationDiscount = associationDiscount;
		this.billDiscount = billDiscount;
		this.totalDiscount = associationDiscount + billDiscount;
		this.finalBill = totalBill - this.totalDiscount;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

	public float getAssociationDiscount() {
		return associationDiscount;
	}

	public void setAssociationDiscount(float associationDiscount) {
		this.associationDiscount = associationDiscount;
	}

	public float getBillDiscount() {
		return billDiscount;
	}

	public void setBillDiscount(float billDiscount) {
		this.billDiscount = billDiscount;
	}

	public float getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public float getFinalBill() {
		return finalBill;
	}

	public void setFinalBill(float finalBill) {
		this.finalBill = finalBill;
	}

}
