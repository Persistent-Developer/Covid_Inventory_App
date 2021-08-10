package com.psl.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.psl.entity.Inventory;
import com.psl.entity.User;

public interface IUserDAO extends CrudRepository<User, Integer> {


}
