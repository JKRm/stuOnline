package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ORGNIZATION")
@SequenceGenerator(name="SEQUENCE_O",sequenceName="SEQUENCE_O",allocationSize=1)
public class Orgnization implements java.io.Serializable{
 
	private long orgnization_id;
	private String org_id;
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_O")
	public long getOrgnization_id(){
		return orgnization_id;
	}
	
	public void setOrgnization_id(long orgnization_id){
		
		this.orgnization_id=orgnization_id;
	}
	
	public String getOrg_id(){
		return org_id;
	}
	
	public void setOrg_id(String org_id){
		this.org_id=org_id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
		
	}
}
