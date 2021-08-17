package com.psl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psl.entity.StoreHoliday;

public interface IStoreHolidayDao extends CrudRepository<StoreHoliday, Integer>{
	
	@Query(value="select sh.date from store_holiday sh join store s on sh.fk2_storeid=s.id where s.id=?1",nativeQuery = true)
	public List<String> getAllHolidays(int id); 
}
