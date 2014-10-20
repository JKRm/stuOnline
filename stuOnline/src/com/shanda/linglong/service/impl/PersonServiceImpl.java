package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.PersonDAO;
import com.shanda.linglong.model.Person;
import com.shanda.linglong.service.PersonService;

@Component("PersonService")
public class PersonServiceImpl implements PersonService{

	
	public PersonDAO pd;
	public PersonDAO getPd() {
		return pd;
	}
	@Resource(name="PersonDao")
	public void setPd(PersonDAO pd) {
		this.pd = pd;
	}

	@Override
	public List<Person> gName(String name) {
		// TODO Auto-generated method stub
		return pd.getByName(name);
	}

	@Override
	public List<Person> gOrgnization(String or_id) {
		// TODO Auto-generated method stub
		return pd.getByOrgnization(or_id);
	}

	@Override
	public List<Person> gPosition(String zw) {
		// TODO Auto-generated method stub
		return pd.getByZw(zw);
	}

	@Override
	public List<Person> gPerson_id(String person_id) {
		// TODO Auto-generated method stub
		return pd.getById(person_id);
	}
	@Override
	public Person getPersonById(String person_id) {
		return pd.getPersonById(person_id);
	}

}
