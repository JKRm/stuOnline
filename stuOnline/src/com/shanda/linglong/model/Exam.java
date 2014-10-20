/**
 * ���ݿ������������
 * �ֶΰ��ţ�����	֪ʶ����	       �Ѷ��趨		��		����		����		���
 */

package com.shanda.linglong.model;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM")
@SequenceGenerator(name="SEQUENCE_E",sequenceName="SEQUENCE_E",allocationSize=1)
public class Exam implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long e_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ�����֪ʶ��ı��
	 */
	private long e_kno_id;
	
	/**
	 * ���ݿ���Ϊfloat���ͣ�����Ԥ���Ѷȡ�Ԥ�ڷ���/�ܷ�����
	 */
	private float e_diff;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ô�
	 */
	private String e_answer;
	
	/**
	 * ���ݿ���Ϊvarchar2����,������Ŀ���͡��жϡ�ѡ�񡢼��������
	 */
	private String e_type;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ø���Ŀ�ķ���
	 */
	private long e_score;

	/**
	 * ���ݿ���ΪClob���ͣ�������Ŀ���
	 */
	private String e_question;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_E")
	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public long getE_kno_id() {
		return e_kno_id;
	}

	public void setE_kno_id(long e_kno_id) {
		this.e_kno_id = e_kno_id;
	}

	public float getE_diff() {
		return e_diff;
	}

	public void setE_diff(float e_diff) {
		this.e_diff = e_diff;
	}

	public String getE_answer() {
		return e_answer;
	}

	public void setE_answer(String e_answer) {
		this.e_answer = e_answer;
	}

	public String getE_type() {
		return e_type;
	}

	public void setE_type(String e_type) {
		this.e_type = e_type;
	}

	public long getE_score() {
		return e_score;
	}

	public void setE_score(long e_score) {
		this.e_score = e_score;
	}

	public String getE_question() {
		return e_question;
	}

	public void setE_question(String e_question) {
		this.e_question= e_question;
	}

}
