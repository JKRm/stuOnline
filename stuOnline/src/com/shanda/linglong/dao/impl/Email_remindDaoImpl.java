package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Email_remindDao;
import com.shanda.linglong.model.Email_remind;

@Component("email_remindDao")
public class Email_remindDaoImpl implements Email_remindDao{
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public long add(Email_remind er) {
			hibernateTemplate.save(er);
			return er.getEmail_id();
			
	}
	@Override
	public boolean delByEmailId(final long email_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Email_remind.class, email_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Email_remind> getList() {
		// TODO Auto-generated method stub
		return (List<Email_remind>) hibernateTemplate
		.find("from Email_remind email_remind ");
	}


}
