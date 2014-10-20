/**
 * 数据库表名：邮件发送人员表
 * 字段安排：自增主键 	邮件提醒内容表 	接收人
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL_SEND")
@SequenceGenerator(name="SEQUENCE_ES",sequenceName="SEQUENCE_ES",allocationSize=1)
public class Email_send implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long es_id;    					

	/**
	 * 数据库中为number类型，设置邮件提醒内容
	 */
	private long email_id;				
	
	/**
	 * 数据库中为varchar2类型，设置接收人
	 */
	private String receive_id;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_ES")
	public long getEs_id() {
		return es_id;
	}

	public void setEs_id(long es_id) {
		this.es_id = es_id;
	}

	public long getEmail_id() {
		return email_id;
	}

	public void setEmail_id(long email_id) {
		this.email_id = email_id;
	}

	public String getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(String receive_id) {
		this.receive_id = receive_id;
	}
	

}
