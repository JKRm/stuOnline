/**
 * 数据库表名：权限分配表
 * 字段安排：主键 	人员编号		权限编号
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
	 * 数据库中为number类型，主键，自增
	 */
	private long pa_id;
	
	/**
	 * 数据库中为varchar2类型，设置人员编号
	 */
	private String person_id;
	
	/**
	 * 数据库中为varchar2类型，设置权限名称
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
