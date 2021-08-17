package com.psl.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psl.entity.StoreTime;

public interface IStoreTimeDao extends CrudRepository<StoreTime, Integer> {

	@Query(value="select st.start_time from store_time st join store s on st.fk3_storeid=s.id where s.id=?1",nativeQuery = true)
	public String getStoreStartTime(int id);
	
	@Query(value="select st.end_time from store_time st join store s on st.fk3_storeid=s.id where s.id=?1",nativeQuery = true)
	public String getStoreEndTime(int id);
}
