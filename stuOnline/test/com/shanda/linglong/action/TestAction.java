package com.shanda.linglong.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements ServletRequestAware{
	
	private String email;
	
	private String title;
	
	private boolean success;
	
	private List<String> hello;
	
	private HttpServletRequest request;

	private HttpSession session;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	
	public void setHello(List<String> hello) {
		this.hello = hello;
	}

	public List<String> getHello() {
		return hello;
	}

	public String execute(){
		
		System.out.println(this.getEmail()+"  "+this.getTitle());
		
		this.success = true;
		
		this.hello.add("!!!");
		
		request.setAttribute("test", "test!");
		
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request = request;

		this.session = request.getSession();
	}

	
	
	

}
