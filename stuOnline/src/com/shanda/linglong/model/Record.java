/**
 * 数据库表名：社区日志表
 * 字段安排：主键	标题		内容		发布人编号		访问次数		照片链接地址		发布时间
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECORD")
@SequenceGenerator(name="SEQUENCE_R",sequenceName="SEQUENCE_R",allocationSize=1)
public class Record implements java.io.Serializable{

	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long r_id;
	
	/**
	 * 数据库中为varchar类型，设置发布人的编号
	 */
	private String person_id;
	
	/**
	 * 数据库中为varchar2类型，设置发布的标题
	 */
	private String r_title;

	/**
	 * 数据库中为varchar2类型，设置发布的内容
	 */
	private String r_content;
	
	/**
	 * 数据库中为varchar2类型，设置照片的链接地址
	 */
	private String r_phourl;

	/**
	 * 数据库中为number类型，设置访问次数
	 */
	private long r_vistime;
	
	/**
	 * 数据库中为varchar2类型，设置发布的时间
	 */
	private String r_time;
	
	private long r_resend; 
	
	private long r_comment;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_R")
	public long getR_id() {
		return r_id;
	}

	public void setR_id(long r_id) {
		this.r_id = r_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_phourl() {
		return r_phourl;
	}

	public void setR_phourl(String r_phourl) {
		this.r_phourl = r_phourl;
	}

	public long getR_vistime() {
		return r_vistime;
	}

	public void setR_vistime(long r_vistime) {
		this.r_vistime = r_vistime;
	}

	public String getR_time() {
		return r_time;
	}

	public void setR_time(String r_time) {
		this.r_time = r_time;
	}

	public void setR_resend(long r_resend) {
		this.r_resend = r_resend;
	}

	public long getR_resend() {
		return r_resend;
	}

	public void setR_comment(long r_comment) {
		this.r_comment = r_comment;
	}

	public long getR_comment() {
		return r_comment;
	}
	
	
	
}
