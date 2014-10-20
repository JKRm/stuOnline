/**
 * ���ݿ�������Ծ��
 * �ֶΰ��ţ�����	�����˱��	�������ɱ���	�÷�		���۷���		�Ƿ����
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAM_PAPER")
@SequenceGenerator(name="SEQUENCE_EP",sequenceName="SEQUENCE_EP",allocationSize=1)
public class Exam_paper implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long ep_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ô����˱��
	 */
	private String person_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ò������ɱ���
	 */
	private long tp_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ø�ѧԱ���Ծ�ĵ÷�
	 */
	private long ep_score;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ù���Ա�Ը�ѧԱ�ķ�������
	 */
	private String ep_annlyse;
	
	/**
	 * ���ݿ���Ϊnumber����,���ù���Ա�Ƿ������ע���Ƿ�����Ը�ѧԱ�鿴
	 */
	private long ep_yon;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_EP")
	public long getEp_id() {
		return ep_id;
	}

	public void setEp_id(long ep_id) {
		this.ep_id = ep_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public long getTp_id() {
		return tp_id;
	}

	public void setTp_id(long tp_id) {
		this.tp_id = tp_id;
	}

	public long getEp_score() {
		return ep_score;
	}

	public void setEp_score(long ep_score) {
		this.ep_score = ep_score;
	}

	public String getEp_annlyse() {
		return ep_annlyse;
	}

	public void setEp_annlyse(String ep_annlyse) {
		this.ep_annlyse = ep_annlyse;
	}

	public long getEp_yon() {
		return ep_yon;
	}

	public void setEp_yon(long ep_yon) {
		this.ep_yon = ep_yon;
	}


}
