package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.NewsDao;
import com.shanda.linglong.model.Enterprise_news;


@Component("newsDao")
public class NewsDaoImpl implements NewsDao {

	private HibernateTemplate hibernateTemplate;

	private NewsDao newsDao;

	public NewsDao getNewsDao() {
		return newsDao;
	}

	@Resource(name = "newsDao")
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Enterprise_news news) {
		try {
			hibernateTemplate.save(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Enterprise_news news) {
		try {
			hibernateTemplate.update(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Enterprise_news getLatestNews() {
		List<Enterprise_news> news = hibernateTemplate
				.find("from Enterprise_news news where news.en_id = (select MAX(en_id) from news)");
		return news.get(0);
	}

	@Override
	public List<Enterprise_news> getNews() {
		return hibernateTemplate
				.find("from Enterprise_news news)");
	}

	@Override
	public Enterprise_news getNews(long nid) {
		return (Enterprise_news) hibernateTemplate
			.find("from Enterprise_news news where news.en_id = ?", nid).get(0);
	}

	@Override
	public boolean delete(Enterprise_news news) {
		try {
			hibernateTemplate.delete(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Enterprise_news> getNewsByIsd(String isd) {
		return (List<Enterprise_news>) hibernateTemplate
		.find("from Enterprise_news news where news.is_download = ?", isd);
	}

}
