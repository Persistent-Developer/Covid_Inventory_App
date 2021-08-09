package com.psl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psl.entity.Inventory;

public interface IInventoryDao extends CrudRepository<Inventory, Integer>{
	
	@Query(value="select distinct i.category from inventory i join store s on i.fk5_storeid=s.id where s.id=?1",nativeQuery = true)
	public List<String> findAllbyID(int id);
	
	/*
	 * @Query(value="select * from inventory i where i.product_name=?1",nativeQuery
	 * = true) public List<Inventory> findAllbyStoreID(String name);
	 */
	
	@Query(value="select * from inventory where category=?1",nativeQuery = true)
	List<Inventory> findByCategory(String name);
	
	
	@Query(value="select * from inventory where product_code=?1",nativeQuery = true)
	Inventory findByProduct_code(String product_code);
}
