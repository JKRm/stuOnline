/**
 * 数据库表名：题目选项表
 * 字段安排：主键	测评表编号	题目编号		选项	
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_OPTION")
@SequenceGenerator(name="SEQUENCE_TO",sequenceName="SEQUENCE_TO",allocationSize=1)
public class Test_option implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long toption_id;
	
	/**
	 * 数据库中为number类型，设置测评表编号
	 */
	private long t_id;

	/**
	 * 数据库中为number类型，设置题目编号
	 */
	private long tq_id;
	
	/**
	 * 数据库中为varchar2类型，设置选项内容
	 */
	private String to_option;
	
	private long to_score;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TO")
	public long getToption_id() {
		return toption_id;
	}

	public void setToption_id(long toption_id) {
		this.toption_id = toption_id;
	}

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public long getTq_id() {
		return tq_id;
	}

	public void setTq_id(long tq_id) {
		this.tq_id = tq_id;
	}

	public String getTo_option() {
		return to_option;
	}

	public void setTo_option(String to_option) {
		this.to_option = to_option;
	}

	public void setTo_score(long to_score) {
		this.to_score = to_score;
	}

	public long getTo_score() {
		return to_score;
	}
	
}
