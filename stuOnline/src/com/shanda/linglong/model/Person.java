package com.shanda.linglong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="PERSON")
@SequenceGenerator(name="SEQUENCE_PERSON",sequenceName="SEQUENCE_PERSON",allocationSize=1)
public class Person implements java.io.Serializable{

	/*
	 * 表主键,数据库中为NUMBER类型
	 */
	private long p_id;
	
	/*
	 * 员工姓名，数据库中为VARCHAR2类型
	 */
	private String personname;
	
	/*
	 * 人员编号，数据库中为VARCHAR2类型
	 */
	private String person_id;
	
	/*
	 * 电子邮件，数据库中为VARCHAR2类型
	 */
	private String p_email;
	/*
	 * 机构编号，数据库中为VARCHAR2类型
	 */
	private String org_id;
	/*
	 * 学历，数据库中为VARCHAR2类型
	 */
	private String p_education;
	
	/*
	 * 职称，数据库中为VARCHAR2类型
	 */
	private String p_zc;
	
	/*
	 * 职位类别，数据库中为VARCHAR2类型
	 */
	private String p_poslevel;
	
	/*
	 * 专业，数据库中为VARCHAR2类型
	 */
	private String p_major;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_PERSON")
	public long getP_id() {
		return p_id;
	}
	
	public void setP_id(long p_id){
		this.p_id=p_id;
	}
	
	
	public String getPersonname(){
		
		return personname;
	}
	
	public void setPersonname(String personname){
		this.personname=personname;
	}
	
	
public String getPerson_id(){
		
		return person_id;
	}
	
	public void setPerson_id(String person_id){
		this.person_id=person_id;
	}
public String getP_email(){
		
		return p_email;
	}
	
	public void setP_email(String p_email){
		this.p_email=p_email;
	}
public String getOrg_id(){
		
		return org_id;
	}
	
	public void setOrg_id(String org_id){
		this.org_id=org_id;
	}
public String getP_education(){
		
		return p_education;
	}
	
	public void setP_education(String p_education){
		this.p_education=p_education;
	}
public String getP_zc(){
		
		return p_zc;
	}
	
	public void setP_zc(String p_zc){
		this.p_zc=p_zc;
	}
public String getP_poslevel(){
		
		return p_poslevel;
	}
	
	public void setP_poslevel(String p_poslevel){
		this.p_poslevel=p_poslevel;
	}
public String getP_major(){
		
		return p_major;
	}
	
	public void setP_major(String p_major){
		this.p_major=p_major;
	}
	
	
}
