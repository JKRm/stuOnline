package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AppendixDao;
import com.shanda.linglong.model.News_appendix;


@Component("appendixDao")
public class AppendixDaoImpl implements AppendixDao {

	private HibernateTemplate hibernateTemplate;

	private AppendixDao appendixDao;

	public AppendixDao appendixDao() {
		return appendixDao;
	}

	@Resource(name = "appendixDao")
	public void setNoticeDao(AppendixDao appendixDao) {
		this.appendixDao = appendixDao;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(News_appendix appendix) {
		try {
			this.hibernateTemplate.save(appendix);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<News_appendix> getAppendixs(long nid) {
		return hibernateTemplate.find("from News_appendix appendix where appendix.news_id = ?", nid);
	}

	@Override
	public boolean delAppendix(News_appendix appendix) {
		try {
			hibernateTemplate.delete(appendix);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public News_appendix getAppendix(long aid) {
		return (News_appendix) hibernateTemplate.find("from News_appendix appendix where appendix.na_id = ?", aid).get(0);
	}

}
