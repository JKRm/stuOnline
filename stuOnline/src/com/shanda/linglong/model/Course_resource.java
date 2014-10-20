/**
 * ���ݿ�������γ����ϱ�
 * �ֶΰ��ţ�����	֪ʶ����	���ϵ����ӵ�ַ	
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_RESOURCE")
@SequenceGenerator(name="SEQUENCE_CR",sequenceName="SEQUENCE_CR",allocationSize=1)
public class Course_resource {

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long cr_id;

	/**
	 * ���ݿ���Ϊnumber���ͣ�����֪ʶ����
	 */
	private long knowledge_id;

	/**
	 * ���ݿ���Ϊvarchar2���ͣ�����swf����
	 */
	private String cr_url;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������ļ���ʾ����
	 */
	private String cr_name;
	
	private String cr_urlname;
	
	private long cr_display;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_CR")	
	public long getCr_id() {
		return cr_id;
	}

	public void setCr_id(long cr_id) {
		this.cr_id = cr_id;
	}

	public long getKnowledge_id() {
		return knowledge_id;
	}

	public void setKnowledge_id(long knowledge_id) {
		this.knowledge_id = knowledge_id;
	}

	public String getCr_url() {
		return cr_url;
	}

	public void setCr_url(String cr_url) {
		this.cr_url = cr_url;
	}

	public void setCr_name(String cr_name) {
		this.cr_name = cr_name;
	}

	public String getCr_name() {
		return cr_name;
	}

	public void setCr_urlname(String cr_urlname) {
		this.cr_urlname = cr_urlname;
	}

	public String getCr_urlname() {
		return cr_urlname;
	}

	public void setCr_display(long cr_display) {
		this.cr_display = cr_display;
	}

	public long getCr_display() {
		return cr_display;
	}

	

	

}
