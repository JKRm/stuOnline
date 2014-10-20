/**
 * ���ݿ������Ȩ�޷����
 * �ֶΰ��ţ����� 	��Ա���		Ȩ�ޱ��
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERMISSION_ASSIGNMENT")
@SequenceGenerator(name="SEQUENCE_PA",sequenceName="SEQUENCE_PA",allocationSize=1)
public class Permission_assignment implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long pa_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ�������Ա���
	 */
	private String person_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ�����Ȩ������
	 */
	private String permission_name;

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_PA")
	public long getPa_id() {
		return pa_id;
	}

	public void setPa_id(long pa_id) {
		this.pa_id = pa_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	
	
}
