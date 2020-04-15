package com.cc.retailstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.retailstore.dao.TotalBillDiscountDao;
import com.cc.retailstore.model.AdditionalBillDiscount;
import com.cc.retailstore.service.BillDiscountSvc;

@Service
public class BillDiscountSvcImpl implements BillDiscountSvc {

	@Autowired
	private TotalBillDiscountDao totalBillDiscountDao;
	
	@Override
	public AdditionalBillDiscount findAdditionalDiscountDetail() {
		return totalBillDiscountDao.findAll().iterator().next();
	}

}
