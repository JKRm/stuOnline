/**
 * ���ݿ����������֤�鱳����
 * �ֶΰ��ţ����� 	����url
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
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long vbg_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ���������֤�����������
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
