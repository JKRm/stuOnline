/**
 * 数据库表名：测评题干表
 * 字段安排：主键	测评表编号 	题目编号 		题干		答案				
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_QUESTION")
@SequenceGenerator(name="SEQUENCE_TQ",sequenceName="SEQUENCE_TQ",allocationSize=1)
public class Test_question implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long tq_id;
	
	/**
	 * 数据库中为number类型，设置测评表编号
	 */
	private long t_id;
	
	/**
	 * 数据库中为varchar2类型,设置题干
	 */
	private String tq_question;
	
	/**
	 * 数据库中为varchar2类型，设置答案
	 */

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TQ")
	public long getTq_id() {
		return tq_id;
	}

	public void setTq_id(long tq_id) {
		this.tq_id = tq_id;
	}

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public String getTq_question() {
		return tq_question;
	}

	public void setTq_question(String tq_question) {
		this.tq_question = tq_question;
	}


	
}
