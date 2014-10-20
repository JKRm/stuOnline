/**
 * ���ݿ�����������ݴ��
 * �ֶΰ��ţ�����	������		�������ɱ���
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM_TEM")
@SequenceGenerator(name="SEQUENCE_ET",sequenceName="SEQUENCE_ET",allocationSize=1)
public class Exam_tem implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long et_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����������ID
	 */
	private long e_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ò�������
	 */
	private long e_title;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ò������ɱ���
	 */
	private long tp_id;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_ET")
	public long getEt_id() {
		return et_id;
	}

	public void setEt_id(long et_id) {
		this.et_id = et_id;
	}

	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public long getE_title() {
		return e_title;
	}

	public void setE_title(long e_title) {
		this.e_title = e_title;
	}
	
	public long getTp_id() {
		return tp_id;
	}

	public void setTp_id(long tp_id) {
		this.tp_id= tp_id;
	}

	
}
