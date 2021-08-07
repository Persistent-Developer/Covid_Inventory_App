package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.RoleDAO;
import com.psl.entity.Role;

@Service("roleService")
public class RoleService {

	@Autowired
	private RoleDAO dao;
	
	public void addRole(Role role)
	{
		dao.save(role);
	}
	
	public Role getRole(int id)
	{
		return dao.findById(id).get();
	}
	
}
