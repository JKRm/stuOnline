package com.shanda.linglong.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.model.Email_remind;
import com.shanda.linglong.model.Email_remind_appendix;
import com.shanda.linglong.model.Email_send;
import com.shanda.linglong.service.EmailService;
import com.shanda.linglong.service.ResourceService;
import com.shanda.linglong.util.MailAddress;
import com.shanda.linglong.util.MailBody;
import com.shanda.linglong.util.SendMail;
import com.shanda.linglong.util.User;
import com.shanda.linglong.vo.MailVo;

public class MailAction extends ActionSupport implements ModelDriven<MailVo>,
		ServletRequestAware {

	private MailVo mv = new MailVo();

	private HttpServletRequest request;

	private HttpSession session;

	private ResourceService rs;

	private EmailService ems;

	@Resource(name = "resourceService")
	public void setRs(ResourceService rs) {
		this.rs = rs;
	}

	public ResourceService getRs() {
		return rs;
	}

	public EmailService getEms() {
		return ems;
	}

	@Resource(name = "emailService")
	public void setEms(EmailService ems) {
		this.ems = ems;
	}

	public String initSel() {

		List<Course_resource> crList = new ArrayList<Course_resource>();

		crList = rs.getList();

		request.setAttribute("crList", crList);

		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;

		this.session = request.getSession();

	}

	@Override
	public MailVo getModel() {
		// TODO Auto-generated method stub
		return mv;
	}

	public String doSave() {

		boolean flag = true;

		Email_send es = new Email_send();

		Email_remind er = new Email_remind();

		Email_remind_appendix era = new Email_remind_appendix();

		er.setEmail_content(mv.getContent());

		er.setEmail_theme(mv.getSubject());

		er.setEmail_mimecontent(String.valueOf(mv.isMimeContent()));

		long eid = ems.addEmail(er);

		for (int i = 0; i < mv.getTo().length; i++) {

			es.setEmail_id(eid);

			es.setReceive_id(mv.getTo()[i]);

			flag = flag && ems.addSend(es);

		}

		if (mv.isAffixFlag()) {

			for (int j = 0; j < mv.getAffix().length; j++) {

				era.setEmail_id(eid);
				
				String type = mv.getAffix()[j].substring(
						
						mv.getAffix()[j].lastIndexOf("."),
						
						mv.getAffix()[j].length());
				
				if (mv.getAffixName()[j] == null || mv.getAffixName()[j].equals("")) {
					
					mv.getAffixName()[j] = mv.getAffix()[j];
					
				} else {
					
					mv.getAffixName()[j] += type;
					
				}

				era.setEra_name(mv.getAffixName()[j]);

				era.setEra_url(mv.getAffix()[j]);

				flag = flag && ems.addAppendixs(era);
			}
		}

		if (flag) {
			
			session.setAttribute("success_info", "添加邮件发送成功");

			return SUCCESS;

		}
		
		session.setAttribute("success_info", "添加邮件发送失败");

		return ERROR;
	}

}
