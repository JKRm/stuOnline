package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.OrgnizationDao;
import com.shanda.linglong.model.Orgnization;

@Component("OrgnizationDao")
public class OrgnizationDaoImpl implements OrgnizationDao{

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public List<Orgnization> findAll() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Orgnization");
	}

}
