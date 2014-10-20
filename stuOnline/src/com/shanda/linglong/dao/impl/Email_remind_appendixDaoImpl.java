package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Email_remind_appendixDao;
import com.shanda.linglong.model.Email_remind_appendix;
import com.shanda.linglong.model.Email_send;

@Component("email_remind_appendixDao")
public class Email_remind_appendixDaoImpl implements Email_remind_appendixDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Email_remind_appendix era) {
		try {
			hibernateTemplate.save(era);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteByEmailId(final long email_id) {

		this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// session.delete("from Email_remind_appendix as email_remind_appendix where email_remind_appendix.email_id = ?",
				// email_id);
				return session
						.createQuery(
								"delete from Email_remind_appendix as email_remind_appendix where email_remind_appendix.email_id = ?")
						.setParameter(0, email_id).executeUpdate();
			}

		});
		return true;

	}

	@Override
	public List<Email_remind_appendix> getListByEmailId(long email_id) {
		return (List<Email_remind_appendix>) hibernateTemplate
		.find("from Email_remind_appendix email_remind_appendix where email_remind_appendix.email_id = ?", email_id);
	}
}
