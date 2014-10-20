package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Person;

public interface PersonDAO {

	public List<Person> getByName(String name);
	public List<Person> getByOrgnization(String orgnization);
	public List<Person> getByZw(String zw);
	public List<Person> getById( String id);
	public Person getPersonById(String person_id);
}
