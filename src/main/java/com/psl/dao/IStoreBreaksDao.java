package com.psl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psl.entity.Inventory;
import com.psl.entity.StoreBreaks;

public interface IStoreBreaksDao extends CrudRepository<StoreBreaks, Integer>{

	@Query(value="select sb.break_from from store_breaks sb join store s on sb.fk1_storeid=s.id where s.id=?1",nativeQuery = true)
	public List<String> getAllStartBreaks(int id);
	
	@Query(value="select sb.break_to from store_breaks sb join store s on sb.fk1_storeid=s.id where s.id=?1",nativeQuery = true)
	public List<String> getAllEndBreaks(int id);
}
