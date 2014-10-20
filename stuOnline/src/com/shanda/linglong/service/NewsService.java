package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Enterprise_news;
import com.shanda.linglong.model.News_appendix;
import com.shanda.linglong.vo.NewsVo;

public interface NewsService {
	
	/**
	 * 添加新闻
	 * @param news 新闻实体类对象
	 * @return boolean 新闻添加是否成功
	 * @author 山大威海JoeyK
	 */
	public boolean addNews(Enterprise_news news);
	
	/**
	 * 获得最新的新闻
	 * @return Enterprise_news 新闻实体类
	 * @author 山大威海JoeyK
	 */
	public Enterprise_news getLatestNews();
	
	/**
	 * 添加新闻附件
	 * @param appendix 附件实体类对象
	 * @return boolean 添加是否成功标志
	 */
	public boolean addNewsAppendix(News_appendix appendix);
	
	
	/**
	 * 获取新闻列表
	 * @return List<Enterprise_news> 新闻列表
	 * @author 山大威海JoeyK
	 */
	public List<Enterprise_news> getNews();
	
	/**
	 * 根据新闻编号获取新闻及其附件
	 * @param nid 新闻编号
	 * @return NewsVo 新闻及其相应附件组成的值对
	 * @author 山大威海JoeyK
	 */
	public NewsVo getNews(long nid);
	
	/**
	 * 更新现有新闻
	 * @param news 新闻实体类对象
	 * @return boolean 更新是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean update(Enterprise_news news);
	
	/**
	 * 删除相应的附件
	 * @param appendix 附件实体类对象
	 * @return boolean 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delAppendix(News_appendix appendix);
	
	/**
	 * 删除一组附件
	 * @param appendixs 新闻附件列表
	 * @author 山大威海JoeyK
	 */
	public void delAppendixs(List<News_appendix> appendixs);
	
	/**
	 * 删除新闻
	 * @param news 新闻的实体类对象
	 * @return boolean 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delete(Enterprise_news news);
	
	/**
	 * 根据附件编号获取附件
	 * @param aid 附件编号
	 * @return News_appendix 附件实体类
	 * @author 山大威海JoeyK
	 */
	public News_appendix getAppendix(long aid);
	
	public List<Enterprise_news> getNewsByIsd(String isd);
}
