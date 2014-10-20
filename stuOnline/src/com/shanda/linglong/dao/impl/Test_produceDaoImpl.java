package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Test_produceDao;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Test_produce;

@Component("test_produceDao")
public class Test_produceDaoImpl implements Test_produceDao{

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean add(Test_produce test_produce) {
		try {
			hibernateTemplate.save(test_produce);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(final long tp_id) {
		try {
			this.hibernateTemplate.execute(
					new HibernateCallback<Integer>(){

						@Override
						public Integer doInHibernate(Session session)
								throws HibernateException, SQLException {
							session.delete("from Test_produce test_produce where test_produce.tp_id = ?", tp_id);
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
	public boolean update(Test_produce test_produce) {
		try {
			hibernateTemplate.update(test_produce);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Test_produce getTest_produce(long tp_id) {
		return (Test_produce) hibernateTemplate.find("from Test_produce test_produce where test_produce.tp_id = ?",tp_id).get(0);
	}

	@Override
	public List<Test_produce> getTest_produceList() {
		return hibernateTemplate.find("from Test_produce test_produce");
	}

	//获取全部记录
	@Override
	public List<Test_produce> getAll() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Test_produce");
	}

}
