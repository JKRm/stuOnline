/**
 * ���ݿ�������γ̰��ű�������ѵ�����γ̡�����Ԫ����С�ڡ���֪ʶ�㣬�弶���ṹ��
 * �ֶΰ��ţ�����	����		����		���ʱ��		��id		
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
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long c_id;

	/**
	 * ���ݿ���Ϊvarchar2���ͣ���������
	 */
	private String c_name;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ý��ܡ�����Ϊ��ѵ���γ̡���Ԫ��С�ڡ�֪ʶ�㣬��ѡһ��
	 */
	private String c_introduction;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ��������ʱ��
	 */
	private String c_time;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ø�id
	 */
	private Course parent;

	/**
	 * ���ݿ�������������
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
