/**
 * ���ݿ�����������ѡ���
 * �ֶΰ��ţ�����	������		ѡ������
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM_OPTION")
@SequenceGenerator(name="SEQUENCE_EO",sequenceName="SEQUENCE_EO",allocationSize=1)
public class Exam_option implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long eo_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long e_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ�����ѡ������
	 */
	private String eo_option;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_EO")
	public long getEo_id() {
		return eo_id;
	}

	public void setEo_id(long eo_id) {
		this.eo_id = eo_id;
	}

	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public String getEo_option() {
		return eo_option;
	}

	public void setEo_option(String eo_option) {
		this.eo_option = eo_option;
	}

}
