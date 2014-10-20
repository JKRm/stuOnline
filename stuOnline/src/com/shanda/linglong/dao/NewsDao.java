package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Enterprise_news;

public interface NewsDao {
	
	/**
	 * 获取最新的新闻
	 * @return Enterprise_news 新闻实体类
	 * @author 山大威海JoeyK
	 */
	public Enterprise_news getLatestNews();
	
	/**
	 * 添加新闻
	 * @param news 新闻实体类
	 * @return boolean 添加是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean add(Enterprise_news news);
	
	/**
	 * 更新新闻
	 * @param news 包含更新信息的新闻实体类
	 * @return boolean 更新是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean update(Enterprise_news news);
	
	/**
	 * 获取新闻列表
	 * @return List<Enterprise_news>新闻列表
	 * @author 山大威海JoeyK
	 */
	public List<Enterprise_news> getNews();
	
	/**
	 * 根据新闻编号获取对应新闻
	 * @param nid
	 * @return Enterprise_news
	 * @author 山大威海JoeyK
	 */
	public Enterprise_news getNews(long nid);
	
	/**
	 * 删除相应新闻
	 * @param news 新闻实体类
	 * @return boolean 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delete(Enterprise_news news);
	
	public List<Enterprise_news> getNewsByIsd(String isd);
}
