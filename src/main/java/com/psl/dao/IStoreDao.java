package com.psl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psl.entity.Store;

public interface IStoreDao extends CrudRepository<Store, Integer>{
	
	

}
