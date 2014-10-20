package com.shanda.linglong.action;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Person_detail;
import com.shanda.linglong.service.Person_detailService;

public class SendEmail extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private String get_personid;
	private Person_detailService pds;

	public Person_detailService getPds() {
		return pds;
	}

	@Resource(name = "person_detailService")
	public void setPds(Person_detailService pds) {
		this.pds = pds;
	}

	public String getGet_personid() {
		return get_personid;
	}

	public void setGet_personid(String get_personid) {
		this.get_personid = get_personid;
	}

	public String sendEmail() {
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost("smtp.139.com");
		mail.setPort(25);
		mail.setPassword("9428586495");
		mail.setUsername("15953897419@139.com");
		mail.setDefaultEncoding("utf-8");

		MimeMessage mailMessage = mail.createMimeMessage();
		MimeMessageHelper messageHelper = null;
		Person_detail pd = new Person_detail();
		pd = pds.getInfo(get_personid);
		if (pd != null) {
			try {

				messageHelper = new MimeMessageHelper(mailMessage, true,
						"UTF-8");
				messageHelper.setFrom("15953897419@139.com");
				messageHelper.setTo(pd.getPd_email());

				messageHelper.setSubject("找回密码");
				messageHelper.setText("您的密码是："+pd.getPd_password(),
						false);
				// messageHelper.addAttachment("附件", new File(""));

				mail.send(mailMessage);
				request.setAttribute("get_message", "密码已发送到您的邮箱中！");
				System.out.println("发送成功");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
            request.setAttribute("get_message", "职工编号不正确");
		}

		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
