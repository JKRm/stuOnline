/**
 * ���ݿ������������־��
 * �ֶΰ��ţ�����	����		����		�����˱��		���ʴ���		��Ƭ���ӵ�ַ		����ʱ��
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
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long r_id;
	
	/**
	 * ���ݿ���Ϊvarchar���ͣ����÷����˵ı��
	 */
	private String person_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����÷����ı���
	 */
	private String r_title;

	/**
	 * ���ݿ���Ϊvarchar2���ͣ����÷���������
	 */
	private String r_content;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ�������Ƭ�����ӵ�ַ
	 */
	private String r_phourl;

	/**
	 * ���ݿ���Ϊnumber���ͣ����÷��ʴ���
	 */
	private long r_vistime;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����÷�����ʱ��
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
