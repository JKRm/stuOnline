package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AppendixDao;
import com.shanda.linglong.dao.Test_optionDao;
import com.shanda.linglong.model.Test_option;

@Component("test_optionDao")
public class Test_optionDaoImpl implements Test_optionDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Test_option test_option) {
		try {
			hibernateTemplate.save(test_option);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(long toption_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Test_option.class,
					toption_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Test_option test_option) {
		try {
			hibernateTemplate.update(test_option);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Test_option getTest_option(long toption_id) {
		return (Test_option) hibernateTemplate
				.find("from Test_option test_option where test_option.toption_id = ?",
						toption_id).get(0);
	}

	@Override
	public List<Test_option> getTest_options(long tq_id) {
		return hibernateTemplate
				.find("from Test_option test_option where test_option.tq_id = ?",
						tq_id);
	}

}
