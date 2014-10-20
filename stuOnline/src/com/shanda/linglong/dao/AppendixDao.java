package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.News_appendix;

public interface AppendixDao {
	
	/**
	 * 添加新闻附件
	 * @param appendix 附件实体类
	 * @return boolean 添加是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean add(News_appendix appendix);
	
	/**
	 * 获得相同新闻编号的附件列表
	 * @param nid 新闻标号
	 * @return List<News_appendix> 新闻附件列表
	 * @author 山大威海JoeyK
	 */
	public List<News_appendix> getAppendixs(long nid);
	
	/**
	 * 删除附件
	 * @param appendix 附件实体类
	 * @return boolean 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delAppendix(News_appendix appendix);
	
	/**
	 * 根据附件编号获取附件
	 * @param aid 附件编号
	 * @return News_appendix 附件实体类
	 * @author 山大威海JoeyK
	 */
	public News_appendix getAppendix(long aid);
}
