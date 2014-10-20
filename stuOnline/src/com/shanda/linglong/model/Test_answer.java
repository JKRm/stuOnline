/**
 * 数据库表名：测评答题表
 * 字段安排：主键	答题人编号	测评表编号	是否完成		得分		评价分析
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_ANSWER")
@SequenceGenerator(name="SEQUENCE_TA",sequenceName="SEQUENCE_TA",allocationSize=1)
public class Test_answer implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long ta_id;
	
	/**
	 * 数据库中为varchar2类型，设置答题人编号
	 */
	private String person_id;
	
	/**
	 * 数据库中为number类型，设置测评表编号
	 */
	private long t_id;
	
	/**
	 * 数据库中为number类型，设置管理员是否批注完成，可以显示给前台学员
	 */
	private long ta_yon;
	
	/**
	 * 数据库中为number类型,设置该学员的调查问卷得分
	 */
	private long ta_score;
	
	/**
	 * 数据库中为varchar2类型，设置管理员对学员的分析评价
	 */
	private String ta_analyse;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TA")
	public long getTa_id() {
		return ta_id;
	}

	public void setTa_id(long ta_id) {
		this.ta_id = ta_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public long getTa_yon() {
		return ta_yon;
	}

	public void setTa_yon(long ta_yon) {
		this.ta_yon = ta_yon;
	}

	public long getTa_score() {
		return ta_score;
	}

	public void setTa_score(long ta_score) {
		this.ta_score = ta_score;
	}

	public String getTa_analyse() {
		return ta_analyse;
	}

	public void setTa_analyse(String ta_analyse) {
		this.ta_analyse = ta_analyse;
	}
	
}
