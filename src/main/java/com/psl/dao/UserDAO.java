package com.psl.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.psl.entity.User;

public interface UserDAO extends CrudRepository<User, Integer> {

}
