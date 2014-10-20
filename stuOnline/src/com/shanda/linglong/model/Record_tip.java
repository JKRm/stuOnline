/**
 * 数据库表名：日志举报表
 * 字段安排：主键	日志编号		举报人编号	举报内容
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECORD_TIP")
@SequenceGenerator(name="SEQUENCE_RT",sequenceName="SEQUENCE_RT",allocationSize=1)
public class Record_tip implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long rt_id;

	/**
	 * 数据库中为number类型，设置日志编号
	 */
	private long r_id;
	
	/**
	 * 数据库中为number类型，设置举报人的编号
	 */
	private String person_id;
	
	/**
	 * 数据库中为varchar2类型，设置举报的原因
	 */
	private String rt_reason;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_RT")
	public long getRt_id() {
		return rt_id;
	}

	public void setRt_id(long rt_id) {
		this.rt_id = rt_id;
	}

	public long getR_id() {
		return r_id;
	}

	public void setR_id(long r_id) {
		this.r_id = r_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getRt_reason() {
		return rt_reason;
	}

	public void setRt_reason(String rt_reason) {
		this.rt_reason = rt_reason;
	}
	

	
}
