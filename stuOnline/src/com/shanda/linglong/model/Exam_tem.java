/**
 * 数据库表名：试题暂存表
 * 字段安排：主键	试题编号		测试生成表编号
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM_TEM")
@SequenceGenerator(name="SEQUENCE_ET",sequenceName="SEQUENCE_ET",allocationSize=1)
public class Exam_tem implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long et_id;
	
	/**
	 * 数据库中为number类型，设置试题库ID
	 */
	private long e_id;
	
	/**
	 * 数据库中为number类型，设置测试题编号
	 */
	private long e_title;
	
	/**
	 * 数据库中为number类型，设置测试生成表编号
	 */
	private long tp_id;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_ET")
	public long getEt_id() {
		return et_id;
	}

	public void setEt_id(long et_id) {
		this.et_id = et_id;
	}

	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public long getE_title() {
		return e_title;
	}

	public void setE_title(long e_title) {
		this.e_title = e_title;
	}
	
	public long getTp_id() {
		return tp_id;
	}

	public void setTp_id(long tp_id) {
		this.tp_id= tp_id;
	}

	
}
