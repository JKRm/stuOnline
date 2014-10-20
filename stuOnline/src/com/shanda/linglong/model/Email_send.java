/**
 * ���ݿ�������ʼ�������Ա��
 * �ֶΰ��ţ��������� 	�ʼ��������ݱ� 	������
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
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long es_id;    					

	/**
	 * ���ݿ���Ϊnumber���ͣ������ʼ���������
	 */
	private long email_id;				
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ý�����
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
