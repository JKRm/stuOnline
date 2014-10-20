package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Exam_optionDao;
import com.shanda.linglong.model.Exam_option;

@Component("exam_optionDao")
public class Exam_optionDaoImpl implements Exam_optionDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean add(Exam_option exam_option) {
		try {
			hibernateTemplate.save(exam_option);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(final long eo_id) {
		try {
			this.hibernateTemplate.execute(
					new HibernateCallback<Integer>(){

						@Override
						public Integer doInHibernate(Session session)
								throws HibernateException, SQLException {
							session.delete("from Exam_option exam_option where exam_option.eo_id = ?", eo_id);
							return 0;
						}
						
					}
			);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Exam_option exam_option) {
		try {
			hibernateTemplate.update(exam_option);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Exam_option> getExamByE_id(long e_id) {
		return hibernateTemplate.find("from Exam_option exam_option where exam_option.e_id = ?",e_id);
	}

}
