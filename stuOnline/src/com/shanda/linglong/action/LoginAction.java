package com.shanda.linglong.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Permission_assignment;
import com.shanda.linglong.model.Person_detail;
import com.shanda.linglong.service.Permission_assignService;
import com.shanda.linglong.service.Person_detailService;
import com.shanda.linglong.service.impl.Person_detailServiceImpl;
import com.shanda.linglong.vo.LoginVo;

public class LoginAction extends ActionSupport implements ModelDriven<LoginVo>,
		ServletRequestAware {

	//修改密码所用
	private String change_user;
	private String change_password_old;
	private String change_password_new;
	private String change_password_new2;
	//END
	private LoginVo lv = new LoginVo();
	private Person_detailService pdsi;
	private HttpServletRequest request;
	private Permission_assignService pas;

	
	
	public String getChange_user() {
		return change_user;
	}
	public void setChange_user(String change_user) {
		this.change_user = change_user;
	}
	public String getChange_password_old() {
		return change_password_old;
	}
	public void setChange_password_old(String change_password_old) {
		this.change_password_old = change_password_old;
	}
	public String getChange_password_new() {
		return change_password_new;
	}
	public void setChange_password_new(String change_password_new) {
		this.change_password_new = change_password_new;
	}
	public String getChange_password_new2() {
		return change_password_new2;
	}
	public void setChange_password_new2(String change_password_new2) {
		this.change_password_new2 = change_password_new2;
	}
	public Permission_assignService getPas() {
		return pas;
	}
	@Resource(name = "Permission_assignService")
	public void setPas(Permission_assignService pas) {
		this.pas = pas;
	}

	@Resource(name = "Person_detailService")
	public void setPerson_detailService(Person_detailService pdsi) {
		this.pdsi = pdsi;
	}

	public Person_detailService getPerson_detailService() {
		return pdsi;
	}

	@Override
	public LoginVo getModel() {
		// TODO Auto-generated method stub
		return lv;
	}

	@Override
	public String execute() {

		String rand = (String) request.getSession().getAttribute("rand");
		
		request.getSession().setAttribute("myUser", lv.getPerson_id());
		request.getSession().setAttribute("myPassword", lv.getPassword());

		if (lv.getConfirm().trim().toLowerCase()
				.equals(rand.trim().toLowerCase())) {
			Person_detail pd=pdsi.isNull_person(lv.getPerson_id(), lv.getPassword());
			if ( pd== null) {
				
				request.setAttribute("message", "用户名或密码错误");
				return ERROR;
			} else {
				if(pd.getPd_role().equals("1"))
				return SUCCESS;
				else return "admin";
			}
		} else {
			
			request.setAttribute("message", "验证码错误");
			return INPUT;
		}

	}
	
	public String admin(){
		List<Permission_assignment> list=pas.findPA(lv.getPerson_id());
		if(list.size()==0||list==null){
			request.setAttribute("error_message", "您没有系统管理权限");
			return ERROR;
		}
		else{
		request.getSession().setAttribute("quanxian", list);
		return SUCCESS;
		}
	}
	
	public String changePassword(){
		
		Person_detail pd=pdsi.isNull_person(change_user, change_password_old);
		if(pd==null){
			request.setAttribute("change", "原用户名或原密码有错误");
		}
		else{
			
			if(change_password_new.isEmpty()||change_password_new==null){
				request.setAttribute("change", "新密码不能为空");
			}
			else{
			if(change_password_new.equals(change_password_new2)){
				request.setAttribute("change", "修改成功");
				pd.setPd_password(change_password_new);
				pdsi.updateDetail(pd);
			}
			else{
				request.setAttribute("change", "两次输入的新密码不一致");
			}
			
			
			}
			
			
		}
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	
	public String exit(){
		//request.getSession().setAttribute("myUser", null);
		request.getSession().removeAttribute("myUser");
		return SUCCESS;
		
	}
}
