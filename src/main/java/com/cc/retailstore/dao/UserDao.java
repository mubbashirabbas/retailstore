package com.cc.retailstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cc.retailstore.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{

}
