/**
 * 数据库表名：企业新闻表
 * 字段安排：主键	新闻内容		新闻题目		新闻发布时间		访问次数
 */

package com.shanda.linglong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ENTERPRISE_NEWS")
@SequenceGenerator(name="SEQUENCE_EN",sequenceName="SEQUENCE_EN",allocationSize=1)
public class Enterprise_news implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long en_id;
	
	/**
	 * 数据库中为varchar2类型，设置新闻内容
	 */
	private String en_content;
	
	/**
	 * 数据库中为varchar2类型，设置新闻题目
	 */
	private String en_theme;

	/**
	 * 数据库中为varchar2类型，设置新闻发布时间
	 */
	private String en_time;
	
	/**
	 * 数据库中为number类型，设置新闻被访问的次数
	 */
	private long en_number;
	
	private String is_download;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_EN")
	public long getEn_id() {
		return en_id;
	}

	public void setEn_id(long en_id) {
		this.en_id = en_id;
	}

	public String getEn_content() {
		return en_content;
	}

	public void setEn_content(String en_content) {
		this.en_content = en_content;
	}

	public String getEn_theme() {
		return en_theme;
	}

	public void setEn_theme(String en_theme) {
		this.en_theme = en_theme;
	}

	@Column(insertable = false,updatable = false)
	public String getEn_time() {
		return en_time;
	}

	public void setEn_time(String en_time) {
		this.en_time = en_time;
	}

	public long getEn_number() {
		return en_number;
	}

	public void setEn_number(long en_number) {
		this.en_number = en_number;
	}

	public void setIs_download(String is_download) {
		this.is_download = is_download;
	}

	public String getIs_download() {
		return is_download;
	}
	
	
}
