/**
 * 数据库表名：学员培训单元进度表
 * 字段安排：主键	培训学员编号	培训编号		单元编号		是否完成	
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERSON_PROGRESS")
@SequenceGenerator(name="SEQUENCE_PP",sequenceName="SEQUENCE_PP",allocationSize=1)
public class Person_progress implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long pp_id;

	/**
	 * 数据库中为number类型，设置培训学员编号
	 */
	private String person_id;

	/**
	 * 数据库中为number类型，设置培训编号
	 */
	private long train_id;
	
	/**
	 * 数据库中为number类型，设置单元编号
	 */
	private long pp_unit;
	
	/**
	 * 数据库中为number类型，设置学员是否完成该单元的学习
	 */
	private long pp_yno;
	
	private String pp_begin;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_PP")	
	public long getPp_id() {
		return pp_id;
	}

	public void setPp_id(long pp_id) {
		this.pp_id = pp_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public long getTrain_id() {
		return train_id;
	}

	public void setTrain_id(long train_id) {
		this.train_id = train_id;
	}

	public long getPp_unit() {
		return pp_unit;
	}

	public void setPp_unit(long pp_unit) {
		this.pp_unit = pp_unit;
	}

	public long getPp_yno() {
		return pp_yno;
	}

	public void setPp_yno(long pp_yno) {
		this.pp_yno = pp_yno;
	}

	public void setPp_begin(String pp_begin) {
		this.pp_begin = pp_begin;
	}

	public String getPp_begin() {
		return pp_begin;
	}
	
}
