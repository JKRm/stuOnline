/**
 * ���ݿ����Ϊ��ְҵ������
 * �ֶΰ��ţ�����	��������		�ʾ�˵��		�������
 */

package com.shanda.linglong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST")
@SequenceGenerator(name="SEQUENCE_T",sequenceName="SEQUENCE_T",allocationSize=1)
public class Test implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long t_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ò���������
	 */
	private String t_name;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������ʾ�˵��
	 */
	private String t_explain;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������������
	 */
	private String t_time;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_T")
	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_explain() {
		return t_explain;
	}

	public void setT_explain(String t_explain) {
		this.t_explain = t_explain;
	}

	@Column(insertable = false,updatable = false)
	public String getT_time() {
		return t_time;
	}

	public void setT_time(String t_time) {
		this.t_time = t_time;
	}
	
	
}
