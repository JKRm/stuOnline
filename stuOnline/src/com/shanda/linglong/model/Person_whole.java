/**
 * 数据库表名：学员培训总体情况表
 * 字段安排：主键	培训学员编号		培训编号		学员首次登录该考核时间	考核分析		荣誉称号		添加时间		是否完成
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
@Table(name="PERSON_WHOLE")
@SequenceGenerator(name="SEQUENCE_PW",sequenceName="SEQUENCE_PW",allocationSize=1)
public class Person_whole implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long pw_id;

	/**
	 * 数据库中为number类型，设置培训学员编号
	 */
	private String person_id;

	/**
	 * 数据库中为number类型，设置培训编号
	 */
	private long train_id;
	
	/**
	 * 数据库中为String类型，设置学员首次登录时间
	 */
	private String pw_time_first;
	
	/**
	 * 数据库中为varchar2类型，设置管理员对该学员本次培训的考核分析
	 */
	private String pw_analyse;

	/**
	 * 数据库中为varchar2类型，设置学员本次培训获得的荣誉称号
	 */
	private String pw_honor;
	
	/**
	 * 数据库中为varchar2类型，设置管理员对该考核报告的添加时间
	 */
	private String pw_time;
	
	/**
	 * 数据库中为number类型，设置管理员是否完成对该考核报告的批注，是否可以显示给学员查看
	 */
	private long pw_yno;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_PW")	
	public long getPw_id() {
		return pw_id;
	}

	public void setPw_id(long pw_id) {
		this.pw_id = pw_id;
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

	@Column(insertable = false,updatable = false)
	public String getPw_time_first() {
		return pw_time_first;
	}

	public void setPw_time_first(String pw_time_first) {
		this.pw_time_first = pw_time_first;
	}

	public String getPw_analyse() {
		return pw_analyse;
	}

	public void setPw_analyse(String pw_analyse) {
		this.pw_analyse = pw_analyse;
	}

	public String getPw_honor() {
		return pw_honor;
	}

	public void setPw_honor(String pw_honor) {
		this.pw_honor = pw_honor;
	}

	public String getPw_time() {
		return pw_time;
	}

	public void setPw_time(String pw_time) {
		this.pw_time = pw_time;
	}

	public long isPw_yno() {
		return pw_yno;
	}

	public void setPw_yno(long pw_yno) {
		this.pw_yno = pw_yno;
	}
	
	
}
