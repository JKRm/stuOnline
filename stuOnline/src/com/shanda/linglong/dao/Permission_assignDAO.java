package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Permission_assignment;

public interface Permission_assignDAO {

	public void save(Permission_assignment pa);
	public List<Permission_assignment> findByPerson_id(String p_id);
	public List<Permission_assignment> findByName(String personid,String name);
	public void del(Permission_assignment pa);
	public List<Permission_assignment> findByName(String name);
}
