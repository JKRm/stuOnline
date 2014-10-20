/**
 * ���ݿ���������������
 * �ֶΰ��ţ�����	�����˱��	��������	�Ƿ����		�÷�		���۷���
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_ANSWER")
@SequenceGenerator(name="SEQUENCE_TA",sequenceName="SEQUENCE_TA",allocationSize=1)
public class Test_answer implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long ta_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ô����˱��
	 */
	private String person_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ò�������
	 */
	private long t_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ù���Ա�Ƿ���ע��ɣ�������ʾ��ǰ̨ѧԱ
	 */
	private long ta_yon;
	
	/**
	 * ���ݿ���Ϊnumber����,���ø�ѧԱ�ĵ����ʾ�÷�
	 */
	private long ta_score;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ù���Ա��ѧԱ�ķ�������
	 */
	private String ta_analyse;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TA")
	public long getTa_id() {
		return ta_id;
	}

	public void setTa_id(long ta_id) {
		this.ta_id = ta_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public long getTa_yon() {
		return ta_yon;
	}

	public void setTa_yon(long ta_yon) {
		this.ta_yon = ta_yon;
	}

	public long getTa_score() {
		return ta_score;
	}

	public void setTa_score(long ta_score) {
		this.ta_score = ta_score;
	}

	public String getTa_analyse() {
		return ta_analyse;
	}

	public void setTa_analyse(String ta_analyse) {
		this.ta_analyse = ta_analyse;
	}
	
}
