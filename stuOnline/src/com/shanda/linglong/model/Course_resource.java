/**
 * 数据库表名：课程资料表
 * 字段安排：主键	知识点编号	资料的链接地址	
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_RESOURCE")
@SequenceGenerator(name="SEQUENCE_CR",sequenceName="SEQUENCE_CR",allocationSize=1)
public class Course_resource {

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long cr_id;

	/**
	 * 数据库中为number类型，设置知识点编号
	 */
	private long knowledge_id;

	/**
	 * 数据库中为varchar2类型，设置swf名称
	 */
	private String cr_url;
	
	/**
	 * 数据库中为varchar2类型，设置文件显示名称
	 */
	private String cr_name;
	
	private String cr_urlname;
	
	private long cr_display;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_CR")	
	public long getCr_id() {
		return cr_id;
	}

	public void setCr_id(long cr_id) {
		this.cr_id = cr_id;
	}

	public long getKnowledge_id() {
		return knowledge_id;
	}

	public void setKnowledge_id(long knowledge_id) {
		this.knowledge_id = knowledge_id;
	}

	public String getCr_url() {
		return cr_url;
	}

	public void setCr_url(String cr_url) {
		this.cr_url = cr_url;
	}

	public void setCr_name(String cr_name) {
		this.cr_name = cr_name;
	}

	public String getCr_name() {
		return cr_name;
	}

	public void setCr_urlname(String cr_urlname) {
		this.cr_urlname = cr_urlname;
	}

	public String getCr_urlname() {
		return cr_urlname;
	}

	public void setCr_display(long cr_display) {
		this.cr_display = cr_display;
	}

	public long getCr_display() {
		return cr_display;
	}

	

	

}
