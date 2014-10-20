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

import com.shanda.linglong.dao.Record_discussDao;
import com.shanda.linglong.model.Record;
import com.shanda.linglong.model.Record_discuss;

@Component("record_discuessDao")
public class Record_discuessDaoImpl implements Record_discussDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public boolean add(Record_discuss rd) {
		try {
			hibernateTemplate.save(rd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean del(long rd_id) {
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Record_discuss.class, rd_id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Record_discuss> getList(final long r_id,final String iscom,final int offset,final int length) {
//		return (List<Record_discuss>) hibernateTemplate
//		.find("from Record_discuss rd where rd.r_id = ? and rd_iscom = ?", r_id,iscom);
		
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Record_discuss rd where rd.r_id = ? and rd_iscom = ?");
				query.setLong(0, r_id);
				query.setString(1, iscom);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public boolean delByrid(final long r_id) {
		try{
		int count =this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Transaction tx = session.beginTransaction(); 
				String hql = "delete Record_discuss where r_id =?"; 
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


	@Override
	public long getRid(long rd_id) {
		Record_discuss rd =  (Record_discuss) hibernateTemplate.find(
				"from Record_discuss rd where rd.rd_id = ?", rd_id).get(0);
		return rd.getR_id();
	}

}
