package com.psl.dao;

import org.springframework.data.repository.CrudRepository;

import com.psl.entity.User;

public interface IUserDAO extends CrudRepository<User, Integer> {

}
