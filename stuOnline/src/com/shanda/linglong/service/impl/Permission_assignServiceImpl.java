package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Permission_assignDAO;
import com.shanda.linglong.model.Permission_assignment;
import com.shanda.linglong.service.Permission_assignService;

@Component("Permission_assignService")
public class Permission_assignServiceImpl implements Permission_assignService{

	Permission_assignDAO pad;
	
	
	public Permission_assignDAO getPad() {
		return pad;
	}

	@Resource(name="Permission_assignDao")
	public void setPad(Permission_assignDAO pad) {
		this.pad = pad;
	}


	@Override
	public void savePA(Permission_assignment pa) {
		// TODO Auto-generated method stub
		pad.save(pa);
		
	}

	@Override
	public List<Permission_assignment> findPA(String p_id) {
		// TODO Auto-generated method stub
		return pad.findByPerson_id(p_id);
	}
	@Override
	public List<Permission_assignment> findPAByName(String name) {
		// TODO Auto-generated method stub
		return pad.findByName(name);
	}

	@Override
	public boolean delPA(String personid, String name) {
		// TODO Auto-generated method stub
		List<Permission_assignment> list=pad.findByName(personid, name);
		if(list.size()==1){
			pad.del(list.get(0));
			return true;
		}
		else
		return false;
	}
}
