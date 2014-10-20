/**
 * 数据库表名：试卷表
 * 字段安排：主键	答题人编号	测试生成表编号	得分		评价分析		是否完成
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM_PAPER")
@SequenceGenerator(name="SEQUENCE_EP",sequenceName="SEQUENCE_EP",allocationSize=1)
public class Exam_paper implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long ep_id;
	
	/**
	 * 数据库中为number类型，设置答题人编号
	 */
	private String person_id;
	
	/**
	 * 数据库中为number类型，设置测试生成表编号
	 */
	private long tp_id;
	
	/**
	 * 数据库中为number类型，设置该学员该试卷的得分
	 */
	private long ep_score;
	
	/**
	 * 数据库中为varchar2类型，设置管理员对该学员的分析评价
	 */
	private String ep_annlyse;
	
	/**
	 * 数据库中为number类型,设置管理员是否完成批注，是否可以显给学员查看
	 */
	private long ep_yon;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_EP")
	public long getEp_id() {
		return ep_id;
	}

	public void setEp_id(long ep_id) {
		this.ep_id = ep_id;
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

	public long getEp_score() {
		return ep_score;
	}

	public void setEp_score(long ep_score) {
		this.ep_score = ep_score;
	}

	public String getEp_annlyse() {
		return ep_annlyse;
	}

	public void setEp_annlyse(String ep_annlyse) {
		this.ep_annlyse = ep_annlyse;
	}

	public long getEp_yon() {
		return ep_yon;
	}

	public void setEp_yon(long ep_yon) {
		this.ep_yon = ep_yon;
	}


}
