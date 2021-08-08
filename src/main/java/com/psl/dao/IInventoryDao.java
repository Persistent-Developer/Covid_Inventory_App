package com.psl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psl.entity.Inventory;

public interface IInventoryDao extends CrudRepository<Inventory, Integer>{
	
	@Query(value="select distinct i.category from inventory i join store s on i.fk5_storeid=s.id where S.id=?1",nativeQuery = true)
	public List<String> findAllbyID(int id);
}
