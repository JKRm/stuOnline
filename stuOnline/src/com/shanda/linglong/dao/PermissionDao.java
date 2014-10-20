package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Permission;

public interface PermissionDao {

	public void savePermission(Permission permission);
	public void deletePermission(Permission permission);
	public void updatePermission(Permission permission);
	public Permission findPermission(String p_name);
	public List<Permission> findPermissions();
}
