package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.RecordDao;
import com.shanda.linglong.model.Record;

@Component("recordDao")
public class RecordDaoImpl implements RecordDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean addRecord(Record record) {
		try {
			hibernateTemplate.save(record);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delRecord(long r_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Record.class, r_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Record> getAllList(final int offset, final int length) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Record record order by record.r_id desc");
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;

		// return (List<Record>) hibernateTemplate
		// .find("from Record record ");
	}

	@Override
	public List<Record> getList(final String person_id,final int offset,final int length) {
//		return (List<Record>) hibernateTemplate.find(
//				"from Record record where record.person_id = ?", person_id);
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Record record where record.person_id = ?");
				query.setString(0, person_id);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public Record getRecord(long r_id) {
		return (Record) hibernateTemplate.find(
				"from Record record where record.r_id = ?", r_id).get(0);
	}

	@Override
	public boolean update(Record record) {
		try {
			hibernateTemplate.update(record);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getTotalCount(final String hql) {

		 int count =this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				return ((Number) session.createQuery(hql).iterate().next())
						.intValue();	 
			}

		});
		return count;

	}

}
