package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AppendixDao;
import com.shanda.linglong.dao.NewsDao;
import com.shanda.linglong.model.Enterprise_news;
import com.shanda.linglong.model.News_appendix;
import com.shanda.linglong.service.NewsService;
import com.shanda.linglong.vo.NewsVo;


@Component("newsService")
public class NewsServiceImpl implements NewsService{

	private NewsDao newsDao;
	private AppendixDao appendixDao;
	
	@Resource(name="newsDao")
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	@Resource(name="appendixDao")
	public void setAppendixDao(AppendixDao appendixDao) {
		this.appendixDao = appendixDao;
	}
	
	@Override
	public boolean addNews(Enterprise_news news) {
		return newsDao.add(news);
	}

	@Override
	public Enterprise_news getLatestNews() {
		return newsDao.getLatestNews();
	}

	@Override
	public boolean addNewsAppendix(News_appendix appendix) {
		return appendixDao.add(appendix);
	}

	@Override
	public List<Enterprise_news> getNews() {
		return newsDao.getNews();
	}

	@Override
	public NewsVo getNews(long nid) {
		Enterprise_news news = newsDao.getNews(nid);
		List<News_appendix> appendixs = appendixDao.getAppendixs(nid);
		NewsVo nv = new NewsVo();
		nv.setNews(news);
		nv.setAppendixs(appendixs);
		return nv;
	}

	@Override
	public boolean update(Enterprise_news news) {
		return newsDao.update(news);
	}

	@Override
	public boolean delAppendix(News_appendix appendix) {
		return appendixDao.delAppendix(appendix);
	}

	@Override
	public boolean delete(Enterprise_news news) {
		return newsDao.delete(news);
	}

	@Override
	public News_appendix getAppendix(long aid) {
		return appendixDao.getAppendix(aid);
	}

	@Override
	public void delAppendixs(List<News_appendix> appendixs) {
		for (int i=0; i<appendixs.size(); ++i) {
			News_appendix appendix = appendixs.get(i);
			this.delAppendix(appendix);
		}
	}

	@Override
	public List<Enterprise_news> getNewsByIsd(String isd) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByIsd(isd);
	}

}
