package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.PersonDAO;
import com.shanda.linglong.model.Person;

@Component("PersonDao")
public class PersonDAOImpl implements PersonDAO{

	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Person> getByName(String name) {
		// TODO Auto-generated method stub
		List<Person> list=hibernateTemplate.find("from Person p where p.personname=?", name);
		return list;
	}

	@Override
	public List<Person> getByOrgnization(String orgnization) {
		// TODO Auto-generated method stub
		List<Person> list=hibernateTemplate.find("from Person p where p.org_id=?", orgnization);
		return list;
	}

	@Override
	public List<Person> getByZw(String zw) {
		// TODO Auto-generated method stub
		List<Person> list=hibernateTemplate.find("from Person p where p.p_zc=?", zw);
		return list;
	}

	@Override
	public List<Person> getById(String id) {
		// TODO Auto-generated method stub
		List<Person> list=hibernateTemplate.find("from Person p where p.person_id=?", id);
		
		return list;
		
	}

	@Override
	public Person getPersonById(String person_id) {
		return (Person)hibernateTemplate.find("from Person p where p.person_id=?", person_id).get(0);
	}
	

}
