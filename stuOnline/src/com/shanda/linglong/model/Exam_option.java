/**
 * 数据库表名：试题库选项表
 * 字段安排：主键	试题编号		选项内容
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM_OPTION")
@SequenceGenerator(name="SEQUENCE_EO",sequenceName="SEQUENCE_EO",allocationSize=1)
public class Exam_option implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long eo_id;
	
	/**
	 * 数据库中为number类型，设置试题编号
	 */
	private long e_id;
	
	/**
	 * 数据库中为varchar2类型，设置选项内容
	 */
	private String eo_option;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_EO")
	public long getEo_id() {
		return eo_id;
	}

	public void setEo_id(long eo_id) {
		this.eo_id = eo_id;
	}

	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public String getEo_option() {
		return eo_option;
	}

	public void setEo_option(String eo_option) {
		this.eo_option = eo_option;
	}

}
