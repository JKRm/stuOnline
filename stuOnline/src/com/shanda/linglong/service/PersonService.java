package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Person;

public interface PersonService {

	public List<Person> gName(String name);
	public List<Person> gOrgnization(String or_id);
	public List<Person> gPosition(String zw);
	public List<Person> gPerson_id(String person_id);
	public Person getPersonById(String person_id);
}
