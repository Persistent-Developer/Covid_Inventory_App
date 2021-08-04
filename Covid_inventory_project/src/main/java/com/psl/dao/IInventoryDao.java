package com.psl.dao;

import org.springframework.data.repository.CrudRepository;

import com.psl.entity.Inventory;

public interface IInventoryDao extends CrudRepository<Inventory, Integer>{

}
