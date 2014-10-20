package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Person_detailDao;
import com.shanda.linglong.model.Person_detail;

@Component("person_detailDao")
public class Person_detailDaoImpl implements Person_detailDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public boolean add(Person_detail pd) {
		try {
			hibernateTemplate.save(pd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean del(String person_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Person_detail.class, person_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modifyPss(String person_id, long pd_password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person_detail getInfo(String person_id) {
		List<Person_detail> list=hibernateTemplate.find(
				"from Person_detail person_detail where person_detail.person_id = ?", person_id);
		if(list.size()==0)
			return null;
		else
			return list.get(0);
//		return (Person_detail) hibernateTemplate.find(
//				"from Person_detail person_detail where person_detail.person_id = ?", person_id).get(0);
	}

	@Override
	public List<Person_detail> getinfoBynn(final String nickname,final int offset,final int length) {
//		return (List<Person_detail>) hibernateTemplate.find(
//				"from Person_detail person_detail where person_detail.pd_nickname like ?", "%%"+nickname+"%%");
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Person_detail person_detail where person_detail.pd_nickname like ?");
				query.setString(0, "%%"+nickname+"%%");
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	
	}

	@Override
	public boolean update(Person_detail pd) {
		try {
			hibernateTemplate.update(pd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.shanda.linglong.dao.Person_detailDao#getInfo(java.lang.String, java.lang.String)
	 * 
	 * 
	 * 通过职员编号和密码搜索唯一的记录，若有返回该条记录，否则返回NULL
	 */
	@Override
	public Person_detail getInfo(String person_id, String password) {
		// TODO Auto-generated method stub
		Person_detail person = new Person_detail();
		List<Person_detail> list = hibernateTemplate
				.find("from Person_detail person where person_id=? and pd_password=?",
						person_id, password);
        if(list.size()==1){
        	person=list.get(0);
        }
        else person=null;
		return person;
	}

}
