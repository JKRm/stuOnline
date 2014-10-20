/**
 * ���ݿ���������Ÿ�����
 * �ֶΰ��ţ�����	���ű�id		�����ļ���ʾ����		�����ļ���ʵ����
 */

package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="NEWS_APPENDIX")
@SequenceGenerator(name="SEQUENCE_NA",sequenceName="SEQUENCE_NA",allocationSize=1)
public class News_appendix implements java.io.Serializable{

	/**
	 * ���ݿ���Ϊnumber���ͣ�����������
	 */
	private long na_id;
	
	/**
	 * ���ݿ���Ϊnumber���ͣ����ö�Ӧ����������
	 */
	private long news_id;

	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ø�������������ʾ����
	 */
	private String na_name_show;
	
	/**
	 * ���ݿ���Ϊvarchar2���ͣ����ø������ص���ʵ����
	 */
	private String na_name_load;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_NA")
	public long getNa_id() {
		return na_id;
	}

	public void setNa_id(long na_id) {
		this.na_id = na_id;
	}

	public long getNews_id() {
		return news_id;
	}

	public void setNews_id(long news_id) {
		this.news_id = news_id;
	}

	public String getNa_name_show() {
		return na_name_show;
	}

	public void setNa_name_show(String na_name_show) {
		this.na_name_show = na_name_show;
	}

	public String getNa_name_load() {
		return na_name_load;
	}

	public void setNa_name_load(String na_name_load) {
		this.na_name_load = na_name_load;
	}

}
