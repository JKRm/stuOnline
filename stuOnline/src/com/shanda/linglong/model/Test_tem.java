/**
 * ���ݿ������������Ŀ�ݴ��
 * �ֶΰ��ţ�����	�����˱��	��������	��Ŀ���		������
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_TEM")
@SequenceGenerator(name="SEQUENCE_TT",sequenceName="SEQUENCE_TT",allocationSize=1)
public class Test_tem implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long tt_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ô����˵ı��
	 */
	private String person_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ò�������
	 */
	private long t_id;
	
	
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ò�����Ŀѡ���id
	 */
	private long toption_id;
	
	private long tq_id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TT")
	public long getTt_id() {
		return tt_id;
	}

	public void setTt_id(long tt_id) {
		this.tt_id = tt_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public long getToption_id() {
		return toption_id;
	}

	public void setToption_id(long toption_id) {
		this.toption_id= toption_id;
	}

	public long getTq_id() {
		return tq_id;
	}

	public void setTq_id(long tq_id) {
		this.tq_id = tq_id;
	}
	
	
}
