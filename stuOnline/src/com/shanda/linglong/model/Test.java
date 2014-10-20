/**
 * 数据库表名为：职业测评表
 * 字段安排：主键	测评表名		问卷说明		添加日期
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
	 * 数据库中为number类型，主键，自增
	 */
	private long t_id;
	
	/**
	 * 数据库中为varchar2类型，设置测评表名称
	 */
	private String t_name;
	
	/**
	 * 数据库中为varchar2类型，设置问卷说明
	 */
	private String t_explain;
	
	/**
	 * 数据库中为varchar2类型，设置添加日期
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
