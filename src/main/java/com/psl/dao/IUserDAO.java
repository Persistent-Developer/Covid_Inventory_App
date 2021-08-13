package com.psl.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psl.entity.User;

public interface IUserDAO extends CrudRepository<User, Integer> {
	
	@Modifying
	@Query("update User set email=:?1 where id=:?2")
	public void changeEmailId(String newEmail ,Integer id);
	

}
