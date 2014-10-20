package com.shanda.linglong.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shanda.linglong.service.Person_detailService;

public class DBtest {
	
	private static ApplicationContext ctx;
	//private static SessionFactory sessionFactory;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//sessionFactory = (SessionFactory)ctx.getBean("sessionFactory");
	}
	
//	@AfterClass
//	public static void afterClass() {
//		sessionFactory.close();
//	}
	
	@Test
	
	public void test(){
		
		//NewsService ns = (NewsService)ctx.getBean("newsService");
		
//		CourseService cs = (CourseService)ctx.getBean("courseService");
		
		Person_detailService pds = (Person_detailService)ctx.getBean("person_detailService");
		
		
		
		
		List<Record_discuss> rdList = new ArrayList<Record_discuss>();
		
		//rs.getDiscussListByrid(12,"true");
		
		//System.out.println(rs.getrid(19));
//		
//		Person_detail pd = new Person_detail();
//		
//		pd.setPd_email("≤‚ ‘” œ‰");
//		
//		pd.setPd_nickname("≤‚ ‘Í«≥∆");
//		
//		pd.setPd_password("≤‚ ‘√‹¬Î");
//		
//		pd.setPd_photo("≤‚ ‘’’∆¨¬∑æ∂");
//		
//		pd.setPerson_id("≤‚ ‘»À‘±id1");
//		
//		rs.addDetail(pd);
//		
//		System.out.println(rs.getInfo("≤‚ ‘»À‘±id1"));
		
		
		
		//Record_discuss rd = new Record_discuss();
		
//		rd.setPerson_id("≤‚ ‘»À‘±ID1");
//		
//		rd.setR_id(1);
//		
//		rd.setRd_content("≤‚ ‘∆¿¬€ƒ⁄»›1");
//		
//		rd.setRd_repeat(1);
//		
		//rs.RecordDiscussAdd(rd);
//		
//		boolean flag = rs.RecordDiscussDel(3);
//		
//		System.out.println(flag);
//		
//		List<Record_discuss> rdList = new ArrayList<Record_discuss>();
//		
//		rdList = rs.getDiscussListByrid(1);
//		
		
		
//		Record record = new Record();
//		
//		record.setPerson_id("≤‚ ‘»À‘±id2");
//		
//		record.setR_content("≤‚ ‘ƒ⁄»›2");
//		
//		record.setR_phourl("≤‚ ‘Õº∆¨¬∑æ∂2");
//		
//		record.setR_resend(2);
//		
//		record.setR_title("≤‚ ‘±ÍÃ‚2");
//		
//		record.setR_vistime(2);
//		
//		rs.RecordAdd(record);
//		
//		List<Record> recordList = new ArrayList<Record>();
//		
//		recordList = rs.getRecordListByPerson("≤‚ ‘»À‘±id2")	;	
//		
		
//		Email_remind er = new Email_remind();
//		
//		Email_send es = new Email_send();
//		
//		Email_remind_appendix era = new Email_remind_appendix();
//		
//		EmailService ns = (EmailService)ctx.getBean("emailService");
//		
//		Sending sd = new Sending();
//		
//		sd.doSending();
		
//		System.out.println(ns.delAppendixByEmailId(11));
//		System.out.println(ns.delSendByEmailId(11));
//		System.out.println(ns.delEmail(11));
		
//		List<Email_remind> erList = ns.getList();
//		
//		for(int i=0;i<rdList.size();i++){
//			
//			System.out.println(rdList.get(i).getRd_content());
//		}
//		
//		er.setEmail_content("test_content");
//		
//		er.setEmail_theme("test_theme");
//		
//		long id = ns.addEmail(er);
//		
//		//System.out.println(id);
//		
//		es.setEmail_id(id);
//		
//		es.setReceive_id("sacco123@126.com");
//		
//		ns.addSend(es);
//		
//		era.setEmail_id(id);
//		
//		era.setEra_name("test_era_name");
//		
//		era.setEra_url("test_era_url");
//		
//		ns.addAppendixs(era);
//		
//		List<Course> courseList = new ArrayList<Course>();
//		
//		courseList = cs.getCourseByIntorduction("÷™ ∂µ„");
//		
		//ResourceService rs = (ResourceService)ctx.getBean("resourceService");
		
//		Course_resource cr = new Course_resource();
//		
//		cr.setCr_name("≤‚ ‘.doc");
//		
//		cr.setCr_url("≤‚ ‘1.doc");
//		
//		cr.setKnowledge_id(1);
//		
//		rs.addResource(cr);
		
//		System.out.println(rs.getResource(9).getCr_name());
//		
//		rs.delResource(9);
//		
		
//		
//		Course_resource cr = new Course_resource();
//		
//		List<Course_resource> crList = new ArrayList<Course_resource>();
//		
//		crList = rs.getList();
//		
		//cr.setCr_id(1);
		
//		cr.setCr_url("≤‚ ‘url2");
//		
//		cr.setKnowledge_id(1);
//		
//		cr.setCr_name("wwww");
//		
//		rs.addResource(cr);
	
		
//		Enterprise_news es = new Enterprise_news();
//		
//		NewsVo nv = new NewsVo();
//		
//		es.setEn_content("new-≤‚ ‘ ˝æ›content");
//		
//		es.setEn_number(2);
//	
//		es.setEn_theme("new-≤‚ ‘ ˝æ›theme");
//		
//		es.setEn_time(DateUtil.currentDateTimeToString());
		
//		List<Enterprise_news> newss = new ArrayList<Enterprise_news>();
//		
//		newss = ns.getNews();
		
//		for (int i=0; i<crList.size(); ++i) {
//	  		System.out.println(crList.get(i).getCr_name());
//		}
////		
//		nv = ns.getNews(14);
//		
//		System.out.println(nv.getNews().getEn_theme());
//		System.out.println(nv.getAppendixs().get(0).getNa_name_show());
		
		//nd.add(es);
		
		//nd.update(es);
		
//		ns.addNews(es);
		
		
		
	
	}
	
	

}
