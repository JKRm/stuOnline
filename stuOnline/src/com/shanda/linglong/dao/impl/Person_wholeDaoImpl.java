package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Person_wholeDao;
import com.shanda.linglong.model.Person_whole;

@Component("person_wholeDao")
public class Person_wholeDaoImpl implements Person_wholeDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Person_whole person_whole) {
		try {
			hibernateTemplate.save(person_whole);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(long pw_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Person_whole.class,
					pw_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Person_whole person_whole) {
		try {
			hibernateTemplate.update(person_whole);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Person_whole getPerson_whole(long person_id, long train_id) {
		return (Person_whole) hibernateTemplate
				.find("from Person_whole person_whole where person_whole.person_id = ? and person_whole.train_id = ?",
						person_id, train_id).get(0);
	}

	@Override
	public List<Person_whole> getPerson_wholesByPerson_id(long person_id) {
		return hibernateTemplate
				.find("from Person_whole person_whole where person_whole.person_id = ?",
						person_id);
	}

}
