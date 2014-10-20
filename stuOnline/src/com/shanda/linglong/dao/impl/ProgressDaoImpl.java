package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.ProgressDao;
import com.shanda.linglong.model.Person_progress;

@Component("progressDao")
public class ProgressDaoImpl implements ProgressDao{
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean save(Person_progress pp) {
		try {
			this.hibernateTemplate.save(pp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean del(Person_progress pp) {
		try {
			hibernateTemplate.delete(pp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Person_progress pp) {
		try {
			hibernateTemplate.update(pp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public List<Person_progress> find(long train_id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Person_progress pp where pp.train_id=?", train_id);
	}

	@Override
	public boolean delBy_Pid_Cid(String personid, long cid) {
		// TODO Auto-generated method stub
		List<Person_progress> list=hibernateTemplate.find("from Person_progress pp where pp.person_id=? and pp.train_id=?", personid,cid);
		if(list.size()==1){
			del(list.get(0));
			return true;}
		return false;
	}
}
