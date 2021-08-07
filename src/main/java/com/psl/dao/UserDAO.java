package com.psl.dao;

import org.springframework.data.repository.CrudRepository;

import com.psl.entity.User;

public interface UserDAO extends CrudRepository<User, Integer> {

}
