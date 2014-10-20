package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.PermissionDao;
import com.shanda.linglong.model.Permission;
import com.shanda.linglong.service.PermissionService;

@Component("PermissionService")
public class PermissionServiceImpl implements PermissionService{

	
	private PermissionDao pd;
	
	public PermissionDao getPermissionDao(){
		return pd;
	}
	
	@Resource(name="PermissionDao")
	public void setPermissionDao(PermissionDao pd){
		this.pd=pd;
	}
	
	@Override
	public void saveP(Permission p) {
		// TODO Auto-generated method stub
		pd.savePermission(p);
	}

	@Override
	public void updateP(String p_name,String p_describe) {
		// TODO Auto-generated method stub
		Permission p=pd.findPermission(p_name);
		p.setP_describe(p_describe);
		pd.updatePermission(p);
	}

	@Override
	public void delectP(String p_name) {
		// TODO Auto-generated method stub
		pd.deletePermission(pd.findPermission(p_name));
	}

	@Override
	public List<Permission> findP() {
		// TODO Auto-generated method stub
		return pd.findPermissions();
		 
	}

}
