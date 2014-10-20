/**
 * 数据库表名：虚拟证书背景表
 * 字段安排：主键 	背景url
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VIRTUAL_BG")
@SequenceGenerator(name="SEQUENCE_VB",sequenceName="SEQUENCE_VB",allocationSize=1)
public class Virtual_bg implements java.io.Serializable{
	
	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long vbg_id;
	
	/**
	 * 数据库中为varchar2类型，设置虚拟证书的文字内容
	 */
	private String vbg_url;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_VB")
	public long getVbg_id() {
		return vbg_id;
	}

	public void setVbg_id(long vbg_id) {
		this.vbg_id = vbg_id;
	}

	public String getVbg_url() {
		return vbg_url;
	}

	public void setVbg_url(String vbg_url) {
		this.vbg_url = vbg_url;
	}
	
	
}
