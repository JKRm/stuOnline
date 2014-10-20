/**
 * ���ݿ������ѧԱ��ѵ���������
 * �ֶΰ��ţ�����	��ѵѧԱ���		��ѵ���		ѧԱ�״ε�¼�ÿ���ʱ��	���˷���		�����ƺ�		���ʱ��		�Ƿ����
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
@Table(name="PERSON_WHOLE")
@SequenceGenerator(name="SEQUENCE_PW",sequenceName="SEQUENCE_PW",allocationSize=1)
public class Person_whole implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long pw_id;

	/**
	 * ���ݿ���Ϊnumber���ͣ�������ѵѧԱ���
	 */
	private String person_id;

	/**
	 * ���ݿ���Ϊnumber���ͣ�������ѵ���
	 */
	private long train_id;
	
	/**
	 * ���ݿ���ΪString���ͣ�����ѧԱ�״ε�¼ʱ��
	 */
	private String pw_time_first;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ù���Ա�Ը�ѧԱ������ѵ�Ŀ��˷���
	 */
	private String pw_analyse;

	/**
	 * ���ݿ���Ϊvarchar2���ͣ�����ѧԱ������ѵ��õ������ƺ�
	 */
	private String pw_honor;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ù���Ա�Ըÿ��˱�������ʱ��
	 */
	private String pw_time;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ù���Ա�Ƿ���ɶԸÿ��˱������ע���Ƿ������ʾ��ѧԱ�鿴
	 */
	private long pw_yno;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_PW")	
	public long getPw_id() {
		return pw_id;
	}

	public void setPw_id(long pw_id) {
		this.pw_id = pw_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public long getTrain_id() {
		return train_id;
	}

	public void setTrain_id(long train_id) {
		this.train_id = train_id;
	}

	@Column(insertable = false,updatable = false)
	public String getPw_time_first() {
		return pw_time_first;
	}

	public void setPw_time_first(String pw_time_first) {
		this.pw_time_first = pw_time_first;
	}

	public String getPw_analyse() {
		return pw_analyse;
	}

	public void setPw_analyse(String pw_analyse) {
		this.pw_analyse = pw_analyse;
	}

	public String getPw_honor() {
		return pw_honor;
	}

	public void setPw_honor(String pw_honor) {
		this.pw_honor = pw_honor;
	}

	public String getPw_time() {
		return pw_time;
	}

	public void setPw_time(String pw_time) {
		this.pw_time = pw_time;
	}

	public long isPw_yno() {
		return pw_yno;
	}

	public void setPw_yno(long pw_yno) {
		this.pw_yno = pw_yno;
	}
	
	
}
