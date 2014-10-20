package com.shanda.linglong.vo;

public class LoginVo {

	
	private String person_id;
	private String password;
	private String confirm;
	private String rand;
	
	public void setRand(String rand){
		
		this.rand=rand;
	}
	public String getRand(){
		return rand;
	}
	
	
	public void setPerson_id(String person_id){
		this.person_id=person_id;
		
	}
	public String getPerson_id(){
		return person_id;
	}
	public void setPassword(String password){
		this.password=password;
		
	}
	public String getPassword(){
		return password;
	}
	public void setConfirm(String confirm){
		this.confirm=confirm;
		
	}
	public String getConfirm(){
		return confirm;
	}
}
