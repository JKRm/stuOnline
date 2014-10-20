/**
 * ���ݿ��������־���۱�
 * �ֶΰ��ţ�����	��־���		�����˱��	��������
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECORD_DISCUSS")
@SequenceGenerator(name="SEQUENCE_RD",sequenceName="SEQUENCE_RD",allocationSize=1)
public class Record_discuss implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long rd_id;

	/**
	 * ���ݿ���Ϊnumber���ͣ�������־���
	 */
	private long r_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����������˵ı��
	 */
	private String person_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ��������۵�����
	 */
	private String rd_content;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ��������۵�ʱ��
	 */
	private String rd_time;
	
	private String rd_iscom;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_RD")
	public long getRd_id() {
		return rd_id;
	}

	public void setRd_id(long rd_id) {
		this.rd_id = rd_id;
	}

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

	public String getRd_content() {
		return rd_content;
	}

	public void setRd_content(String rd_content) {
		this.rd_content = rd_content;
	}

	public void setRd_time(String rd_time) {
		this.rd_time = rd_time;
	}

	public String getRd_time() {
		return rd_time;
	}

	public void setRd_iscom(String rd_iscom) {
		this.rd_iscom = rd_iscom;
	}

	public String getRd_iscom() {
		return rd_iscom;
	}

	
	
}
