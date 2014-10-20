package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Permission;

public interface PermissionService {

	
	public void saveP(Permission p);
	public void updateP(String p_name,String p_describe);
	public void delectP(String p_name);
	public List<Permission> findP();
}
