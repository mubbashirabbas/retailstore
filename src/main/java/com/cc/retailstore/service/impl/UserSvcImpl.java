package com.cc.retailstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.retailstore.dao.UserDao;
import com.cc.retailstore.model.User;
import com.cc.retailstore.service.UserSvc;

@Service
public class UserSvcImpl implements UserSvc{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User loadUser(Long userId) {
		return userDao.findOne(userId);
	}

}
