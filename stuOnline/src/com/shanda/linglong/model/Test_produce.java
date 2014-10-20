/**
 * ���ݿ�������������ɱ�
 * �ֶΰ��ţ�����	�γ̰��ű���	����ʱ��		�Ծ�����		
 */

package com.shanda.linglong.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEST_PRODUCE")
@SequenceGenerator(name="SEQUENCE_TESTP",sequenceName="SEQUENCE_TESTP",allocationSize=1)
public class Test_produce implements Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long tp_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ö�Ӧ���Ծ�Χ��ţ�������Ԫ���Եĵ�Ԫ��ţ��γ̲��ԵĿγ̱�ţ���ѵ���Ե���ѵ���
	 */
	private long c_id;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ø��Ծ������ʱ��
	 */
	private String tp_time_produce;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������Ծ�����
	 */
	private String tp_title;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ������Ծ�����
	 */
	private String tp_describe;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TESTP")
	public long getTp_id() {
		return tp_id;
	}

	public void setTp_id(long tp_id) {
		this.tp_id = tp_id;
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	@Column(insertable = false,updatable = false)
	public String getTp_time_produce() {
		return tp_time_produce;
	}

	public void setTp_time_produce(String tp_time_produce) {
		this.tp_time_produce = tp_time_produce;
	}


	public String getTp_title() {
		return tp_title;
	}

	public void setTp_title(String tp_title) {
		this.tp_title = tp_title;
	}
	
	public String getTp_describe() {
		return tp_describe;
	}

	public void setTp_describe(String tp_describe) {
		this.tp_describe= tp_describe;
	}

	
}
