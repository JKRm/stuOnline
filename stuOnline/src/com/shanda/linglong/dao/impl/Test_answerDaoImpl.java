package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Test_answerDao;
import com.shanda.linglong.model.Test_answer;

@Component("test_answerDao")
public class Test_answerDaoImpl implements Test_answerDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Test_answer test_answer) {
		try {
			hibernateTemplate.save(test_answer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(long ta_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Test_answer.class,
					ta_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Test_answer test_answer) {
		try {
			hibernateTemplate.update(test_answer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Test_answer getTest_answer(String person_id, long t_id) {
		return (Test_answer) hibernateTemplate
				.find("from Test_answer test_answer where test_answer.person_id = ? and test_answer.t_id = ?",
						person_id, t_id).get(0);
	}

	@Override
	public List<Test_answer> getTest_answerByPerson_id(String person_id) {
		return hibernateTemplate.find("from Test_answer test_answer where test_answer.person_id = ?",person_id);
	}

	@Override
	public List<Test_answer> getTest_answerByT_id(long t_id) {
		return hibernateTemplate.find("from Test_answer test_answer where test_answer.t_id = ?",t_id);
	}

	@Override
	public void savept(Test_answer ta) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(ta);
		
	}
}
