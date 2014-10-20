package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AppendixDao;
import com.shanda.linglong.dao.Test_questionDao;
import com.shanda.linglong.model.Test_question;

@Component("test_questionDao")
public class Test_questionDaoImpl implements Test_questionDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Test_question test_question) {
		try {
			hibernateTemplate.save(test_question);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(long tq_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Test_question.class,
					tq_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Test_question test_question) {
		try {
			hibernateTemplate.update(test_question);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Test_question getTest_question(final int offset, final long t_id) {
		Test_question test_question = this.getHibernateTemplate().execute(
				new HibernateCallback<Test_question>() {

					@Override
					public Test_question doInHibernate(Session session)
							throws HibernateException, SQLException {
						return (Test_question) session
								.createQuery(
										"from Test_question test_question where test_question.t_id = ?")
								.setParameter(0, t_id).setFirstResult(offset)
								.setMaxResults(1).uniqueResult();
					}

				});
		return test_question;
	}

	@Override
	public List<Test_question> getTest_questions(long t_id) {
		return hibernateTemplate
				.find("from Test_question test_question where test_question.t_id = ?",
						t_id);
	}

}
