/**
 * ���ݿ�������ʼ�������
 * �ֶΰ��ţ��������� 	�ʼ��������ݱ� 	������ַ       ������
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
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long era_id;
	
	
	/**
	 * ���ݿ���Ϊnumber���ͣ������ʼ���������
	 */
	private long email_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������ʼ�������ַ
	 */
	private String era_url;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������ʼ�������
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
