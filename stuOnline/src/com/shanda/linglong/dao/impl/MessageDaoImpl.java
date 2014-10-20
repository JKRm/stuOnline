package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.MessageDao;
import com.shanda.linglong.model.Message_temp;
import com.shanda.linglong.model.Record_discuss;

@Component("messageDao")
public class MessageDaoImpl implements MessageDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public boolean add(Message_temp mt) {
		try {
			hibernateTemplate.save(mt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean del(long mt_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Message_temp.class, mt_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Message_temp> getList(final String person_id_recieve,final int offset,final int length) {
//		return (List<Message_temp>) hibernateTemplate
//		.find("from Message_temp mt where mt.person_id_recieve = ?", person_id_recieve);
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Message_temp mt where mt.person_id_recieve = ?");
				query.setString(0, person_id_recieve);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	
	}


	@Override
	public boolean delByRecieveId(final String person_id_recieve) {
		this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session
						.createQuery(
								"delete from Message_temp as mt where mt.person_id_recieve = ?")
						.setParameter(0, person_id_recieve).executeUpdate();
			}

		});
		return true;

	}

	@Override
	public boolean delByRid(final long r_id) {
		try{
			int count =this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
				@Override
				public Integer doInHibernate(Session session)
						throws HibernateException, SQLException {
					Transaction tx = session.beginTransaction(); 
					String hql = "delete Message_temp where r_id =?"; 
					Query query = session.createQuery(hql);
					query.setLong(0, r_id);
					 int updatedEntities = query.executeUpdate();
					 tx.commit();
					 return updatedEntities;
				}

			});
			return true;
			}catch (Exception e) {
				return false;
			}

		}


}
