/**
 * 数据库表名：邮件附件表
 * 字段安排：自增主键 	邮件提醒内容表 	附件地址       附件名
 */
package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL_REMIND_APPENDIX")
@SequenceGenerator(name="SEQUENCE_ERA",sequenceName="SEQUENCE_ERA",allocationSize=1)
public class Email_remind_appendix implements java.io.Serializable{
	
	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long era_id;
	
	
	/**
	 * 数据库中为number类型，设置邮件提醒内容
	 */
	private long email_id;
	
	/**
	 * 数据库中为varchar2类型，设置邮件附件地址
	 */
	private String era_url;
	
	/**
	 * 数据库中为varchar2类型，设置邮件附件名
	 */
	private String era_name;

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_ERA")
	public long getEra_id() {
		return era_id;
	}

	public void setEra_id(long era_id) {
		this.era_id = era_id;
	}

	public long getEmail_id() {
		return email_id;
	}

	public void setEmail_id(long email_id) {
		this.email_id = email_id;
	}

	public String getEra_url() {
		return era_url;
	}

	public void setEra_url(String era_url) {
		this.era_url = era_url;
	}

	public String getEra_name() {
		return era_name;
	}

	public void setEra_name(String era_name) {
		this.era_name = era_name;
	}

	

}
