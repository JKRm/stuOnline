/**
 * 数据库表名：试题库表
 * 字段安排：主键	知识点编号	       难度设定		答案		类型		分数		题干
 */

package com.shanda.linglong.model;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM")
@SequenceGenerator(name="SEQUENCE_E",sequenceName="SEQUENCE_E",allocationSize=1)
public class Exam implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long e_id;
	
	/**
	 * 数据库中为number类型，设置知识点的编号
	 */
	private long e_kno_id;
	
	/**
	 * 数据库中为float类型，设置预期难度【预期分数/总分数】
	 */
	private float e_diff;
	
	/**
	 * 数据库中为varchar2类型，设置答案
	 */
	private String e_answer;
	
	/**
	 * 数据库中为varchar2类型,设置题目类型【判断、选择、简答、论述】
	 */
	private String e_type;
	
	/**
	 * 数据库中为number类型，设置该题目的分数
	 */
	private long e_score;

	/**
	 * 数据库中为Clob类型，设置题目题干
	 */
	private String e_question;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_E")
	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public long getE_kno_id() {
		return e_kno_id;
	}

	public void setE_kno_id(long e_kno_id) {
		this.e_kno_id = e_kno_id;
	}

	public float getE_diff() {
		return e_diff;
	}

	public void setE_diff(float e_diff) {
		this.e_diff = e_diff;
	}

	public String getE_answer() {
		return e_answer;
	}

	public void setE_answer(String e_answer) {
		this.e_answer = e_answer;
	}

	public String getE_type() {
		return e_type;
	}

	public void setE_type(String e_type) {
		this.e_type = e_type;
	}

	public long getE_score() {
		return e_score;
	}

	public void setE_score(long e_score) {
		this.e_score = e_score;
	}

	public String getE_question() {
		return e_question;
	}

	public void setE_question(String e_question) {
		this.e_question= e_question;
	}

}
