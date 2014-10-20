package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TRAIN_DETAIL")
@SequenceGenerator(name="SEQUENCE_TD",sequenceName="SEQUENCE_TD",allocationSize=1)
public class Train_detail implements java.io.Serializable{

	private long td_id;
	private long c_id;
	private long td_period;
	private String td_content;

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_TD")
	public long getTd_id() {
		return td_id;
	}
	public void setTd_id(long td_id) {
		this.td_id = td_id;
	}
	public long getC_id() {
		return c_id;
	}
	public void setC_id(long c_id) {
		this.c_id = c_id;
	}
	public long getTd_period() {
		return td_period;
	}
	public void setTd_period(long td_period) {
		this.td_period = td_period;
	}
	
	public String getTd_content() {
		return td_content;
	}
	public void setTd_content(String td_content) {
		this.td_content = td_content;
	}
	
}
