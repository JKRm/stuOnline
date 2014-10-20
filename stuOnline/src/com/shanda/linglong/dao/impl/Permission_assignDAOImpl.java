package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Permission_assignDAO;
import com.shanda.linglong.model.Permission_assignment;


@Component("Permission_assignDao")
public class Permission_assignDAOImpl implements Permission_assignDAO{

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Override
	public void save(Permission_assignment pa) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(pa);
		
	}

	@Override
	public List<Permission_assignment> findByPerson_id(String p_id) {
		// TODO Auto-generated method stub
		return  hibernateTemplate.find("from Permission_assignment a where a.person_id=?", p_id);
	
	
		
	}
	@Override
	public List<Permission_assignment> findByName(String name) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Permission_assignment a where a.permission_name=?", name);
	}

	@Override
	public void del(Permission_assignment pa) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(pa);
		
	}

	@Override
	public List<Permission_assignment> findByName(String personid, String name) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Permission_assignment pa where pa.permission_name=? and pa.person_id=?", name,personid);
	}

}
