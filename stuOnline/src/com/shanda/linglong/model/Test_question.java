/**
 * ���ݿ������������ɱ�
 * �ֶΰ��ţ�����	�������� 	��Ŀ��� 		���		��				
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_QUESTION")
@SequenceGenerator(name="SEQUENCE_TQ",sequenceName="SEQUENCE_TQ",allocationSize=1)
public class Test_question implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long tq_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ò�������
	 */
	private long t_id;
	
	/**
	 * ���ݿ���Ϊvarchar2����,�������
	 */
	private String tq_question;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ô�
	 */

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TQ")
	public long getTq_id() {
		return tq_id;
	}

	public void setTq_id(long tq_id) {
		this.tq_id = tq_id;
	}

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public String getTq_question() {
		return tq_question;
	}

	public void setTq_question(String tq_question) {
		this.tq_question = tq_question;
	}


	
}
