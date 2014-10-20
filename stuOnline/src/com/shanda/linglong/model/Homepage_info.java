/**
 * ���ݿ��������ҳ��Ϣ��
 * �ֶΰ��ţ�����	��Ϣ����		����ʱ��
 */

package com.shanda.linglong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HOMEPAGE_INFO")
@SequenceGenerator(name="SEQUENCE_HI",sequenceName="SEQUENCE_HI",allocationSize=1)
public class Homepage_info implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long hp_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ�������Ϣ����
	 */
	private String hp_content;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ø���ʱ��
	 */
	private String hp_time;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_HI")
	public long getHp_id() {
		return hp_id;
	}

	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}

	public String getHp_content() {
		return hp_content;
	}

	public void setHp_content(String hp_content) {
		this.hp_content = hp_content;
	}

	@Column(insertable = false,updatable = false)
	public String getHp_time() {
		return hp_time;
	}

	public void setHp_time(String hp_time) {
		this.hp_time = hp_time;
	}
	
}
