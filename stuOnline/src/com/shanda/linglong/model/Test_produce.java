/**
 * 数据库表名：测试生成表
 * 字段安排：主键	课程安排表编号	生成时间		试卷名称		
 */

package com.shanda.linglong.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_PRODUCE")
@SequenceGenerator(name="SEQUENCE_TESTP",sequenceName="SEQUENCE_TESTP",allocationSize=1)
public class Test_produce implements Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long tp_id;
	
	/**
	 * 数据库中为number类型，设置对应的试卷范围编号，包括单元测试的单元编号，课程测试的课程编号，培训测试的培训编号
	 */
	private long c_id;
	
	/**
	 * 数据库中为varchar2类型，设置改试卷的生成时间
	 */
	private String tp_time_produce;
	
	/**
	 * 数据库中为varchar2类型，设置试卷名称
	 */
	private String tp_title;
	
	/**
	 * 数据库中为varchar2类型，设置试卷描述
	 */
	private String tp_describe;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TESTP")
	public long getTp_id() {
		return tp_id;
	}

	public void setTp_id(long tp_id) {
		this.tp_id = tp_id;
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	@Column(insertable = false,updatable = false)
	public String getTp_time_produce() {
		return tp_time_produce;
	}

	public void setTp_time_produce(String tp_time_produce) {
		this.tp_time_produce = tp_time_produce;
	}


	public String getTp_title() {
		return tp_title;
	}

	public void setTp_title(String tp_title) {
		this.tp_title = tp_title;
	}
	
	public String getTp_describe() {
		return tp_describe;
	}

	public void setTp_describe(String tp_describe) {
		this.tp_describe= tp_describe;
	}

	
}
