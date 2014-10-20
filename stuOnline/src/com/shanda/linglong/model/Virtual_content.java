/**
 * 数据库表名：虚拟证书内容表
 * 字段安排：主键 	文字内容
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VIRTUAL_CONTENT")
@SequenceGenerator(name="SEQUENCE_VC",sequenceName="SEQUENCE_VC",allocationSize=1)
public class Virtual_content implements java.io.Serializable{
	
	/**
	 * 数据库中为number类型，主键，自增
	 */
	private long vc_id;
	
	/**
	 * 数据库中为varchar2类型，设置虚拟证书的背景图片链接地址
	 */
	private String vc_url;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_VC")
	public long getVc_id() {
		return vc_id;
	}

	public void setVc_id(long vc_id) {
		this.vc_id = vc_id;
	}

	public String getVc_url() {
		return vc_url;
	}

	public void setVc_url(String vc_url) {
		this.vc_url = vc_url;
	}

	
}
