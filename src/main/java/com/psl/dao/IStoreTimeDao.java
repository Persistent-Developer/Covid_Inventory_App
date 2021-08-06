package com.psl.dao;

import org.springframework.data.repository.CrudRepository;

import com.psl.entity.StoreTime;

public interface IStoreTimeDao extends CrudRepository<StoreTime, Integer> {

}
