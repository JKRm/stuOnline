/**
 * 数据库表名：答题表
 * 字段安排：主键	答题人编号	测试生成表编号	题目编号		答案		得分		批注
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ANSWER")
@SequenceGenerator(name="SEQUENCE_A",sequenceName="SEQUENCE_A",allocationSize=1)
public class Answer implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long a_id;
	
	/**
	 * 数据库中为number类型，设置答题人编号
	 */
	private String person_id;
	
	/**
	 * 数据库中为number类型，设置测试生成表编号
	 */
	private long tp_id;
	
	/**
	 * 数据库中为number类型，设置试题编号
	 */
	private long title_id;
	
	/**
	 * 数据库中为varchar2类型，设置该学员所做的答案
	 */
	private String a_answer;
	
	/**
	 * 数据库中为varchar2类型,设置该学员该题目的得分
	 */
	private long a_score;

	/**
	 * 数据库中为varchar2类型，设置管理员对该学员该题目的批注
	 */
	private String a_annotate;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_A")
	public long getA_id() {
		return a_id;
	}

	public void setA_id(long a_id) {
		this.a_id = a_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public long getTp_id() {
		return tp_id;
	}

	public void setTp_id(long tp_id) {
		this.tp_id = tp_id;
	}

	public long getTitle_id() {
		return title_id;
	}

	public void setTitle_id(long title_id) {
		this.title_id = title_id;
	}

	public String getA_answer() {
		return a_answer;
	}

	public void setA_answer(String a_answer) {
		this.a_answer = a_answer;
	}

	public long getA_score() {
		return a_score;
	}

	public void setA_score(long a_score) {
		this.a_score = a_score;
	}

	public String getA_annotate() {
		return a_annotate;
	}

	public void setA_annotate(String a_annotate) {
		this.a_annotate = a_annotate;
	}

}
