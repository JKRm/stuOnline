package com.shanda.linglong.vo;

import java.util.List;

import com.shanda.linglong.model.Enterprise_news;
import com.shanda.linglong.model.News_appendix;


public class NewsVo {
	private Enterprise_news news;
	private List<News_appendix> appendix;
	
	public Enterprise_news getNews() {
		return news;
	}
	public void setNews(Enterprise_news news) {
		this.news = news;
	}
	public List<News_appendix> getAppendixs() {
		return appendix;
	}
	public void setAppendixs(List<News_appendix> appendix) {
		this.appendix = appendix;
	}
}
