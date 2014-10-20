/**
 * ���ݿ����������֤�����ݱ�
 * �ֶΰ��ţ����� 	��������
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
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long vc_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ���������֤��ı���ͼƬ���ӵ�ַ
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
