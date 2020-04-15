package com.cc.retailstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_internal_users_discount")
public class PercentageDiscount extends BaseBean{

	@Column(name="association_type")
	private String associationType;
	
	@Column(name="discount")
	private float percentageDiscount;

	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}

	public float getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(float percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
}
