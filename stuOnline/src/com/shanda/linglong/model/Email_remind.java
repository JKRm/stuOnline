/**
 * 数据库表名：邮件提醒内容表
 * 字段安排：自增主键 	自动发送时间  	发送内容  	主题
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL_REMIND")
@SequenceGenerator(name="SEQUENCE_ER",sequenceName="SEQUENCE_ER",allocationSize=1)
public class Email_remind implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long email_id;    					
	
	/**
	 * 数据库中为varchar2类型，设置自动发送邮件的内容
	 */
	private String email_content;
	
	/**
	 * 数据库中为varchar2类型，设置自动发送邮件的主题
	 */
	private String email_theme;
	
	/**
	 * 数据库中为varchar2类型，设置是否包含超链接
	 */
	private String email_mimecontent;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_ER")
	public long getEmail_id() {
		return email_id;
	}

	public void setEmail_id(long email_id) {
		this.email_id = email_id;
	}

	public String getEmail_content() {
		return email_content;
	}

	public void setEmail_content(String email_content) {
		this.email_content = email_content;
	}

	public String getEmail_theme() {
		return email_theme;
	}

	public void setEmail_theme(String email_theme) {
		this.email_theme = email_theme;
	}

	public void setEmail_mimecontent(String email_mimecontent) {
		this.email_mimecontent = email_mimecontent;
	}

	public String getEmail_mimecontent() {
		return email_mimecontent;
	}
	
	

}
