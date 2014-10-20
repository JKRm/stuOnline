package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.TestDao;
import com.shanda.linglong.model.Test;

@Component("testDao")
public class TestDaoImpl implements TestDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean add(Test test) {
		try {
			hibernateTemplate.saveOrUpdate(test);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(long t_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Test.class, t_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Test test) {
		try {
			hibernateTemplate.update(test);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Test> getTestList() {
		return hibernateTemplate.find("from Test test");
	}

	@Override
	public Test getTestByT_id(long t_id) {
		return (Test)hibernateTemplate.find("from Test test where test.t_id = ?",t_id).get(0);
	}

}
