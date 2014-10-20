/**
 * 数据库表名：新闻附件表
 * 字段安排：主键	新闻表id		下载文件显示名称		下载文件真实名称
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="NEWS_APPENDIX")
@SequenceGenerator(name="SEQUENCE_NA",sequenceName="SEQUENCE_NA",allocationSize=1)
public class News_appendix implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long na_id;
	
	/**
	 * 数据库中为number类型，设置对应的新闻内容
	 */
	private long news_id;

	/**
	 * 数据库中为varchar2类型，设置附件下载链接显示名称
	 */
	private String na_name_show;
	
	/**
	 * 数据库中为varchar2类型，设置附件下载的真实名称
	 */
	private String na_name_load;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_NA")
	public long getNa_id() {
		return na_id;
	}

	public void setNa_id(long na_id) {
		this.na_id = na_id;
	}

	public long getNews_id() {
		return news_id;
	}

	public void setNews_id(long news_id) {
		this.news_id = news_id;
	}

	public String getNa_name_show() {
		return na_name_show;
	}

	public void setNa_name_show(String na_name_show) {
		this.na_name_show = na_name_show;
	}

	public String getNa_name_load() {
		return na_name_load;
	}

	public void setNa_name_load(String na_name_load) {
		this.na_name_load = na_name_load;
	}

}
