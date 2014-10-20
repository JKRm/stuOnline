package com.shanda.linglong.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shanda.linglong.model.Email_remind;
import com.shanda.linglong.model.Email_remind_appendix;
import com.shanda.linglong.model.Email_send;
import com.shanda.linglong.service.EmailService;
import com.shanda.linglong.vo.MailVo;

public class Sending {
	
	private EmailService ems;
	
	@Resource(name = "emailService")
	public void setEms(EmailService ems) {
		this.ems = ems;
	}

	public EmailService getEms() {
		return ems;
	}
	
	public void doSending(){
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		EmailService ems = (EmailService)ctx.getBean("emailService");
		
		List<Email_remind> erList = new ArrayList<Email_remind>();
		
		erList = ems.getList();
		
		List<Email_remind_appendix> eraList = new ArrayList<Email_remind_appendix>();
		
		List<Email_send> esList = new ArrayList<Email_send>();
		
		MailVo mv = new MailVo();
		
		
		if(erList!=null){
			
			for(int i=0;i<erList.size();i++){
				
				mv.setMimeContent(Boolean.parseBoolean(erList.get(i).getEmail_mimecontent()));
				System.out.println(erList.get(i).getEmail_content());
				
				if(erList.get(i).getEmail_content()==null||erList.get(i).getEmail_content().isEmpty()){
					mv.setContent("无信息内容");
				}
				else{
					mv.setContent(erList.get(i).getEmail_content());
				}
					
				mv.setSubject(erList.get(i).getEmail_theme());
				
				mv.setSubject(erList.get(i).getEmail_theme());
				
				if(ems.getListByEID(erList.get(i).getEmail_id())!=null){
				
					esList = ems.getListByEID(erList.get(i).getEmail_id());
				
				}
				
				if(ems.getLsitByEmailId(erList.get(i).getEmail_id())!=null){
					
					eraList = ems.getLsitByEmailId(erList.get(i).getEmail_id());
				}
				
				else{
					
					mv.setAffixFlag(false);
				}
				
				String[] toAddress = new String[esList.size()];
				
				String[] affix = new String[eraList.size()];
				
				String[] affixName = new String[eraList.size()];
				
				for(int m=0;m<esList.size();m++){
					
					if(esList.get(m)!=null&&esList.get(m).getReceive_id()!=null){
						toAddress[m] = esList.get(m).getReceive_id();
					}
				}
				
				for(int n=0;n<eraList.size();n++){
					
					if(eraList.get(n)!=null&&eraList.get(n).getEra_url()!=null){
					
					affix[n] = eraList.get(n).getEra_url();
					
					affixName[n] = eraList.get(n).getEra_name();
					
					}
				}
				
				mv.setAffix(affix);
				
				mv.setAffixName(affixName);
				
				mv.setTo(toAddress);
				
				send(mv);
				
				ems.delAppendixByEmailId(erList.get(i).getEmail_id());
				
				ems.delSendByEmailId(erList.get(i).getEmail_id());
				
				ems.delEmail(erList.get(i).getEmail_id());
				
			}	
			
		}
		

	}
		

	public void send(MailVo mv) {
		
		String host = "smtp.163.com";

		String username = "linglonget";

		String password = "linglong";

		String from = "linglonget@163.com";

		String[] to = mv.getTo();

		// String cc = null;

		String subject = mv.getSubject();

		String content = mv.getContent();

		boolean mimeContent = mv.isMimeContent();

		String[] affix = new String[mv.getAffix().length];

		String[] affixName = new String[mv.getAffix().length];

		for (int i = 0; i < mv.getAffix().length; i++) {

			affix[i] = System.getenv("CATALINA_HOME")
					+ "/webapps/studentOnline_source/CourseResource/"
					+ mv.getAffix()[i];

			affixName[i] = mv.getAffixName()[i];

		}

		boolean debug = false;

		// String userFile = "user.properties";

		// String addressFile = "mailaddress.properties";

		SendMail mail = null;

		try {

			try {

				User user = new User(host, username, password, from);

				MailAddress mailAddress = new MailAddress(to);

				// User user = new User(userFile);

				// MailAddress mailAddress = new MailAddress(SendMail.class

				// .getResourceAsStream(addressFile));

				MailBody mailBody = new MailBody(subject, content, mimeContent,

				affix, affixName);
				
				mailBody.setAffixFlag(mv.isAffixFlag());
				
				mail = new SendMail(user);

				// for (int i = 0; i < 5; i++) {

				// 设置发件人地址、收件人地址和邮件标题

				mail.setAddress(mailAddress);

				// 设置要发送附件的位置和标题

				mail.setMailBody(mailBody);

				// 设置smtp服务器以及邮箱的帐号和密码

				mail.send(debug);

				// try {

				// Thread.sleep(1 * 1000);

				// } catch (InterruptedException e) {

				// e.printStackTrace();

				// }

				// mailBody = new MailBody(subject + "_" + (i + 1), content);

				// }

			} finally {

				if (null != mail)

					mail.close();

			}

		} catch (AddressException e) {

			e.printStackTrace();

		} catch (MessagingException e) {

			e.printStackTrace();

			// } catch (IOException e) {

			// e.printStackTrace();

		}

	}
	

//	public static void main(String[] args) {
//		Sending sd = new Sending();
//		sd.doSending();
//	}


	
}
