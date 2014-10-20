/**
 * ���ݿ�������ʼ��������ݱ�
 * �ֶΰ��ţ��������� 	�Զ�����ʱ��  	��������  	����
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
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long email_id;    					
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������Զ������ʼ�������
	 */
	private String email_content;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������Զ������ʼ�������
	 */
	private String email_theme;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������Ƿ����������
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
