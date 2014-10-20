/*
 * ְԱ��ʱ��
 * 
 */


package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.persistence.Table;


@Entity
@Table(name = "PERSON_DETAIL")
@SequenceGenerator(name = "SEQUENCE_PD", sequenceName = "SEQUENCE_PD", allocationSize = 1)
public class Person_detail implements java.io.Serializable{

	/*
	 * ���������ݿ���ΪNUMBER����
	 */
	private long pd_id;

	/*
	 * ְԱ��ţ����ݿ���Ϊvarchar2����
	 */
	private String person_id;

	/*
	 * ���룬���ݿ���Ϊvarchar2����
	 */
	private String pd_password;

	/*
	 * �ǳƣ����ݿ���Ϊvarchar2����
	 */
	private String pd_nickname;

	/*
	 * �����ʼ������ݿ���Ϊvarchar2����
	 */
	private String pd_email;

	/*
	 * ͷ�����ݿ���Ϊvarchar2����
	 */
	private String pd_photo;
	
	
	/*
	 * ��ɫ�����ݿ���Ϊvarchar2����
	 */
	private String pd_role;

	/*
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PD")
	public long getPd_id() {
		return pd_id;
	}

	public void setPd_id(long pd_id) {
		this.pd_id = pd_id;
	}

	//
	public String getPerson_id() {
		return person_id;

	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	//
	public String getPd_password() {
		return pd_password;

	}

	public void setPd_password(String pd_password) {
		this.pd_password = pd_password;
	}

	//
	public String getPd_email() {
		return pd_email;

	}

	public void setPd_email(String pd_email) {
		this.pd_email = pd_email;
	}

	//
	public String getPd_nickname() {
		return pd_nickname;

	}

	public void setPd_nickname(String pd_nickname) {
		this.pd_nickname = pd_nickname;
	}

	//
	public String getPd_photo() {
		return pd_photo;

	}

	public void setPd_photo(String pd_photo) {
		this.pd_photo = pd_photo;
	}

	public String getPd_role() {
		return pd_role;
	}

	public void setPd_role(String pd_role) {
		this.pd_role = pd_role;
	}
	
}
