package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="MESSAGE_TEMP")
@SequenceGenerator(name="SEQUENCE_MT",sequenceName="SEQUENCE_MT",allocationSize=1)
public class Message_temp implements java.io.Serializable{

	
	private long mt_id;
	private String person_id_send;
	private String person_id_recieve;
	private long r_id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_MT")
	public long getMt_id(){
		return mt_id;
	}
	
	public void setMt_id(long mt_id){
		this.mt_id=mt_id;
	}
	
	
	public long getR_id(){
		return r_id;
	}
	
	public void setR_id(long r_id){
		this.r_id=r_id;
	}
	
	
	public String getPerson_id_send(){
		return person_id_send;
	}
	public void setPerson_id_send(String person_id_send){
		this.person_id_send=person_id_send;
	}
	
	
	public String getPerson_id_recieve(){
		return person_id_recieve;
	}
	public void setPerson_id_recieve(String person_id_recieve){
		this.person_id_recieve=person_id_recieve;
	}
}
