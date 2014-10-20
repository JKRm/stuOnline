/**
 * 数据库表名：课程安排表【包括培训——课程——单元——小节——知识点，五级树结构】
 * 字段安排：主键	名称		介绍		添加时间		父id		
 */

package com.shanda.linglong.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
@SequenceGenerator(name="SEQUENCE_C",sequenceName="SEQUENCE_C",allocationSize=1)
public class Course implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long c_id;

	/**
	 * 数据库中为varchar2类型，设置名称
	 */
	private String c_name;
	
	/**
	 * 数据库中为varchar2类型，设置介绍【限制为培训、课程、单元、小节、知识点，五选一】
	 */
	private String c_introduction;
	
	/**
	 * 数据库中为varchar2类型，设置添加时间
	 */
	private String c_time;
	
	/**
	 * 数据库中为number类型，设置父id
	 */
	private Course parent;

	/**
	 * 数据库中设置外间关联
	 */
	private	Set<Course> children = new HashSet<Course>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_C")	
	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_introduction() {
		return c_introduction;
	}

	public void setC_introduction(String c_introduction) {
		this.c_introduction = c_introduction;
	}

	@Column(insertable = false,updatable = false)
	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	@ManyToOne
	@JoinColumn(name="c_pid")
	public Course getParent() {
		return parent;
	}

	public void setParent(Course parent) {
		this.parent = parent;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="parent",fetch=FetchType.EAGER)
	public Set<Course> getChildren() {
		return children;
	}

	public void setChildren(Set<Course> children) {
		this.children = children;
	}

}
