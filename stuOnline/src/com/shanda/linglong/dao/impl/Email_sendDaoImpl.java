package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Email_sendDao;
import com.shanda.linglong.model.Email_send;

@Component("email_sendDao")
public class Email_sendDaoImpl implements Email_sendDao{
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Email_send es) {
		try {
			hibernateTemplate.save(es);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delByEmailId(final long email_id) {
		try {
			this.hibernateTemplate.execute(
					new HibernateCallback<Integer>(){

						@Override
						public Integer doInHibernate(Session session)
								throws HibernateException, SQLException {
							//session.delete("delete from Exam_send es where es.email_id = ?", email_id);
							return session
							.createQuery(
									"delete from Email_send as email_send where email_send.email_id = ?")
							.setParameter(0, email_id).executeUpdate();
						}
						
					}
			);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Email_send> getListByEmailId(long email_id) {
		// TODO Auto-generated method stub
		return (List<Email_send>) hibernateTemplate
		.find("from Email_send email_send where email_send.email_id = ?", email_id);
	}
	

}
