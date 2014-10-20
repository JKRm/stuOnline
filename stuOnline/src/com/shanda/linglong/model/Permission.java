/**
 * ���ݿ������Ȩ�ޱ�
 * �ֶΰ��ţ����� 	Ȩ������	 	Ȩ������
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERMISSION")
@SequenceGenerator(name="SEQUENCE_P",sequenceName="SEQUENCE_P",allocationSize=1)
public class Permission implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long p_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ�����Ȩ������
	 */
	private String p_name;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ�����Ȩ������
	 */
	private String p_describe;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_P")
	public long getP_id() {
		return p_id;
	}

	public void setP_id(long p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_describe() {
		return p_describe;
	}

	public void setP_describe(String p_describe) {
		this.p_describe = p_describe;
	}

	
}
