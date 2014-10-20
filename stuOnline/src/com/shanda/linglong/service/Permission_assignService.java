package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Permission_assignment;

public interface Permission_assignService {

	public void savePA(Permission_assignment pa);
	public List<Permission_assignment> findPA(String p_id);
	public List<Permission_assignment> findPAByName(String name);
	public boolean delPA(String personid,String name);
}
