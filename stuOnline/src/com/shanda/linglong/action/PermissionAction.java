package com.shanda.linglong.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Answer;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Email_remind;
import com.shanda.linglong.model.Email_send;
import com.shanda.linglong.model.Exam_paper;
import com.shanda.linglong.model.Orgnization;
import com.shanda.linglong.model.Permission;
import com.shanda.linglong.model.Permission_assignment;
import com.shanda.linglong.model.Person;
import com.shanda.linglong.model.Person_detail;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Test;
import com.shanda.linglong.model.Test_answer;
import com.shanda.linglong.model.Test_produce;
import com.shanda.linglong.model.Train_detail;
import com.shanda.linglong.service.AnswerService;
import com.shanda.linglong.service.CourseService;
import com.shanda.linglong.service.EmailService;
import com.shanda.linglong.service.Exam_paperService;
import com.shanda.linglong.service.OrgnizationService;
import com.shanda.linglong.service.PermissionService;
import com.shanda.linglong.service.Permission_assignService;
import com.shanda.linglong.service.PersonService;
import com.shanda.linglong.service.Person_detailService;
import com.shanda.linglong.service.TestService;
import com.shanda.linglong.service.Test_answerService;
import com.shanda.linglong.service.Test_produceService;
import com.shanda.linglong.vo.PermissionVo;

public class PermissionAction extends ActionSupport implements ModelDriven<PermissionVo>,ServletRequestAware{

	private PermissionService  ps;
	private PersonService person;
	private HttpServletRequest request;
	PermissionVo pv=new PermissionVo();
	private String cxfs;
	private String cxxx;
	private String cxxx2;
	private String cxxx3;
	private String cxxx4;
	private Permission_assignService pas;
	private String qxzl;
	private Test_produceService tps;
	private TestService ts;
	private AnswerService as;
	private Test_answerService tas;
	private OrgnizationService os;
	private Exam_paperService eps;
	private CourseService cs;
	private EmailService es;
	private String parameter;
	private String delete_px;
	private String delete_person;
	private String delete_xtqx;
	private Person_detailService pds;
	
	
	
	
	
	
	
	
	
	public Person_detailService getPds() {
		return pds;
	}
	@Resource(name="person_detailService")
	public void setPds(Person_detailService pds) {
		this.pds = pds;
	}
	public String getDelete_xtqx() {
		return delete_xtqx;
	}
	public void setDelete_xtqx(String delete_xtqx) {
		this.delete_xtqx = delete_xtqx;
	}
	public String getDelete_person() {
		return delete_person;
	}
	public void setDelete_person(String delete_person) {
		this.delete_person = delete_person;
	}
	public String getDelete_px() {
		return delete_px;
	}
	public void setDelete_px(String delete_px) {
		this.delete_px = delete_px;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public EmailService getEs() {
		return es;
	}
	@Resource(name="emailService")
	public void setEs(EmailService es) {
		this.es = es;
	}
	public CourseService getCs() {
		return cs;
	}
	@Resource(name="courseService")
	public void setCs(CourseService cs) {
		this.cs = cs;
	}
	public Exam_paperService getEps() {
		return eps;
	}
	@Resource(name="exam_paperservice")
	public void setEps(Exam_paperService eps) {
		this.eps = eps;
	}
	public String getCxxx2() {
		return cxxx2;
	}
	public void setCxxx2(String cxxx2) {
		this.cxxx2 = cxxx2;
	}
	public String getCxxx3() {
		return cxxx3;
	}
	public void setCxxx3(String cxxx3) {
		this.cxxx3 = cxxx3;
	}
	public String getCxxx4() {
		return cxxx4;
	}
	public void setCxxx4(String cxxx4) {
		this.cxxx4 = cxxx4;
	}
	public OrgnizationService getOs() {
		return os;
	}
	@Resource(name="OrgnizationService")
	public void setOs(OrgnizationService os) {
		this.os = os;
	}
	public Test_answerService getTas() {
		return tas;
	}
	@Resource(name="test_answerService")
	public void setTas(Test_answerService tas) {
		this.tas = tas;
	}
	public AnswerService getAs() {
		return as;
	}
	@Resource(name="answerService")
	public void setAs(AnswerService as) {
		this.as = as;
	}
	public TestService getTs() {
		return ts;
	}
	@Resource(name="testService")
	public void setTs(TestService ts) {
		this.ts = ts;
	}
	public Test_produceService getTps() {
		return tps;
	}
	@Resource(name="Test_produceService")
	public void setTps(Test_produceService tps) {
		this.tps = tps;
	}
	public String getQxzl() {
		return qxzl;
	}
	public void setQxzl(String qxzl) {
		this.qxzl = qxzl;
	}
	public Permission_assignService getPas() {
		return pas;
	}
	@Resource(name="Permission_assignService")
	public void setPas(Permission_assignService pas) {
		this.pas = pas;
	}
	public PersonService getPerson() {
		return person;
	}
	@Resource(name="PersonService")
	public void setPerson(PersonService person) {
		this.person = person;
	}

	
	public String getCxfs() {
		return cxfs;
	}

	public void setCxfs(String cxfs) {
		this.cxfs = cxfs;
	}

	public String getCxxx() {
		return cxxx;
	}

	public void setCxxx(String cxxx) {
		this.cxxx = cxxx;
	}

	@Override
	public PermissionVo getModel() {
		// TODO Auto-generated method stub
		return pv;
	}
	
	@Resource(name="PermissionService")
	public void setPermissionService(PermissionService ps){
		this.ps=ps;
	}
	
	public PermissionService getPermissionService(){
		return ps;
	}
	public String execute(){
		
		Permission p=new Permission();
		System.out.println(pv.getP_name());
		if(pv.getP_name().trim().equals(null)||pv.getP_name().isEmpty()){
			request.setAttribute("error_message", "权限名称不能为空");
			return ERROR;
		}
		else
		{
		p.setP_describe(pv.getP_describe());
		p.setP_name(pv.getP_name());
		ps.saveP(p);
		return SUCCESS;
		}
		
		
	}
	public String delete(){
		//ps.delectP(pv.getP_name());
		
		
		String name[]=request.getParameterValues("name");
		if(name==null){
			request.setAttribute("error_message", "请至少选择一个权限");
			return ERROR;
		}
		else{
		try {
			for(int i=0;i<name.length;i++){
			String a = new String(name[i].getBytes("ISO-8859-1"),"UTF-8");
			//if(name[0].equals("管理者"))
				//System.out.println(name[0]);
			ps.delectP(a);}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return SUCCESS;
		}
	}
	
	public String update(){
		if(request.getParameter("test2").equals(null)||request.getParameter("test2").isEmpty()||request.getParameter("test2").equals("false")){
			request.setAttribute("error_message", "请至少选择一个权限");
			return ERROR;
			
		}
		else{
		try {
			String a = new String(request.getParameter("test2").getBytes("ISO-8859-1"),"UTF-8");
			String b = new String(request.getParameter("test1").getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(b);
			ps.updateP(a,b);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
		}
	}
 
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	//系统权限不同操作
	public String results(){
		String right=request.getParameter("right");
		List<Orgnization> ol=os.getAll();
		List<Permission> list=ps.findP();
		request.getSession().setAttribute("delete_permission", list);
		request.getSession().setAttribute("orgnization", ol);
		request.getSession().setAttribute("canshu", right);
		request.getSession().setAttribute("qxzl2", null);
		request.getSession().setAttribute("person_info", null);
		return SUCCESS;
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 试卷
	 */
	
	//跳转到试卷分配
	public String fp_sj(){
		List<Orgnization> ol=os.getAll();
		List<Test_produce> list=tps.findAll();
		request.getSession().setAttribute("orgnization", ol);
		request.getSession().setAttribute("list_dtqx", list);
		return SUCCESS;
	}
public String save_sj(){
		
		//职工编号
		String[] person_id=request.getParameterValues("person_name");
		//权限代码
		String[] permission_id=request.getParameterValues("name2");
		long[] zh=switch_sl(permission_id);
		//哪种权限参数
	//	String hid_pd=request.getParameter("hid_pd");
		if(person_id==null){
			request.setAttribute("error_message", "请至少选择一名职工");
			return ERROR;
			
		}
		if(permission_id==null){
			request.setAttribute("error_message", "请至少选择一项权限或试卷或测评表或培训");
			return ERROR;
		}
		for(int i=0;i<person_id.length;i++){
			
			 Exam_paper ep=new Exam_paper();
	    	 for(int j=0;j<zh.length;j++){
	    		 ep.setPerson_id(person_id[i]);
	    		 ep.setTp_id(zh[j]);
	    		 eps.save_Person_Testproduce(ep);
	    		 
	    	 }
		}
		return SUCCESS;
	}
	
	//试卷分配
	public String select_fpsj(){
			
			
			List<Person> p=null;
			request.getSession().setAttribute("canshu", "allot");
			if(cxfs.equals("zgbh")){
				p=person.gPerson_id(cxxx);
				
			}
			else if(cxfs.equals("zgxm")){
				try {
					System.out.println(cxxx);
					String a=new String(cxxx.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(a);
					p=person.gName(a);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(cxfs.equals("jgmc")){
				try {
					System.out.println(cxxx3);
					String a=new String(cxxx3.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(a);
					p=person.gOrgnization(a);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(cxfs.equals("zwmc")){
				try {
					System.out.println(cxxx4);
					String a=new String(cxxx4.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(a);
					p=person.gPosition(a);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p=person.gPosition(cxxx);
			}
			request.getSession().setAttribute("person_info", p);
			request.getSession().setAttribute("qxzl2", "xtqx");
			return SUCCESS;
		}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * END 试卷
	 */
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 培训
	 */
	//跳转到培训分配
	public String pxfp(){
		
		List<Orgnization> ol=os.getAll();
		List<Course> list=cs.getCourseByIntorduction("培训");
		request.getSession().setAttribute("orgnization", ol);
		request.getSession().setAttribute("list_pxfp", list);
		if(parameter!=null)
			return "delete";
		else
		return SUCCESS;
	}
	//删除查询
	public String select_pxfp_train(){
		List<Person_progress> list=cs.getByTrain_id(Long.parseLong(delete_px));
		System.out.println(delete_px);
		
		if(list!=null){
			String[] a=new String[list.size()];
			String[] b=new String[list.size()]; 
			for(int i=0;i<list.size();i++){
				a[i]=list.get(i).getPerson_id();
				b[i]=person.getPersonById(list.get(i).getPerson_id()).getPersonname();
			}
			request.getSession().setAttribute("person_info2", a);
			request.getSession().setAttribute("person_info3", b);
			request.getSession().setAttribute("person_info4", delete_px);
		}
		else{
			System.out.println("no");
		}
		return SUCCESS;
	}
	//培训查询
	public String select_pxfp(){
			
			List<Person> p=null;
			request.getSession().setAttribute("canshu", "allot");
			if(cxfs.equals("zgbh")){
				p=person.gPerson_id(cxxx);
				
			}
			else if(cxfs.equals("zgxm")){
				try {
					System.out.println(cxxx);
					String a=new String(cxxx.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(a);
					p=person.gName(a);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(cxfs.equals("jgmc")){
				try {
					System.out.println(cxxx3);
					String a=new String(cxxx3.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(a);
					p=person.gOrgnization(a);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(cxfs.equals("zwmc")){
				try {
					System.out.println(cxxx4);
					String a=new String(cxxx4.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(a);
					p=person.gPosition(a);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p=person.gPosition(cxxx);
			}
			request.getSession().setAttribute("person_info", p);
			request.getSession().setAttribute("qxzl2", "xtqx");
			return SUCCESS;
			}
		//删除培训
	public String delete_pxfp(){
		String[] person_id=request.getParameterValues("person_name");
		if(person_id!=null){
		for(int i=0;i<person_id.length;i++){
			cs.delPerson_progress(person_id[i],Long.parseLong(request.getParameter("delete_px2")));
		}
		return SUCCESS;
		}
		else{
			request.setAttribute("delete_error", "请至少选择一名职员");
			return ERROR;
		}
	}
	//保存培训
	public String save_pxfp(){
		
		//职工编号
		String[] person_id=request.getParameterValues("person_name");
		//权限代码
		String[] permission_id=request.getParameterValues("name2");
		
		//哪种权限参数
//		String hid_pd=request.getParameter("hid_pd");
		if(person_id==null){
			request.setAttribute("error_message", "请至少选择一名职工");
			return ERROR;
			
		}
		if(permission_id==null){
			request.setAttribute("error_message", "请至少选择一项权限或试卷或测评表或培训");
			return ERROR;
		}
		long[] zh=switch_sl(permission_id);
		//保存分配
		for(int i=0;i<person_id.length;i++){
			
			 Person_progress pp=new Person_progress();
			 for(int j=0;j<zh.length;j++){
				 pp.setPerson_id(person_id[i]);
				 pp.setTrain_id(zh[j]);
				 cs.add2pp(pp);
			 }
		}
		//包培训保存到EMAIL_REMIND中
		long[] email_remind_id=new long[zh.length];
		for(int i=0;i<zh.length;i++){
			Course c=cs.getCourseById(zh[i]);
			Train_detail td=cs.getTrainById(zh[i]);
			Email_remind er=new Email_remind();
			er.setEmail_mimecontent("false");
			er.setEmail_theme(c.getC_name()+"通知");
			er.setEmail_content("该培训持续时间为："+td.getTd_period()+"天<br/>该培训简介："+td.getTd_content());
			email_remind_id[i]=es.addEmail(er);
		}
		//将EMAIL_REMIND.ID和PERSON_ID写到EMAIL_SEND中
		for(int i=0;i<person_id.length;i++){
			Person p=person.getPersonById(person_id[i]);
			for(int j=0;j<email_remind_id.length;j++){
				Email_send esend=new Email_send();
				esend.setReceive_id(p.getP_email());
				esend.setEmail_id(email_remind_id[j]);
				es.addSend(esend);
			}
			
		}
		
		return SUCCESS;
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * END 培训
	 */
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 测评表
	 */
	//跳转到测评表分配
	public String cpb(){
		List<Orgnization> ol=os.getAll();
		List<Test> list=ts.getTestList();
		request.getSession().setAttribute("orgnization", ol);
		request.getSession().setAttribute("list_cpqx", list);
		return SUCCESS;
	}
	//测评表查询
public String select_cpb(){
		
		
		List<Person> p=null;
		request.getSession().setAttribute("canshu", "allot");
		if(cxfs.equals("zgbh")){
			p=person.gPerson_id(cxxx);
			
		}
		else if(cxfs.equals("zgxm")){
			try {
				System.out.println(cxxx);
				String a=new String(cxxx.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(a);
				p=person.gName(a);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(cxfs.equals("jgmc")){
			try {
				System.out.println(cxxx3);
				String a=new String(cxxx3.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(a);
				p=person.gOrgnization(a);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(cxfs.equals("zwmc")){
			try {
				System.out.println(cxxx4);
				String a=new String(cxxx4.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(a);
				p=person.gPosition(a);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p=person.gPosition(cxxx);
		}
		request.getSession().setAttribute("person_info", p);
		request.getSession().setAttribute("qxzl2", "xtqx");
		return SUCCESS;
	}
//保存测评表
public String save_cpb(){
		
		//职工编号
		String[] person_id=request.getParameterValues("person_name");
		//权限代码
		String[] permission_id=request.getParameterValues("name2");
		long[] zh=switch_sl(permission_id);
		//哪种权限参数
	//	String hid_pd=request.getParameter("hid_pd");
		if(person_id==null){
			request.setAttribute("error_message", "请至少选择一名职工");
			return ERROR;
			
		}
		if(permission_id==null){
			request.setAttribute("error_message", "请至少选择一项权限或试卷或测评表或培训");
			return ERROR;
		}
		for(int i=0;i<person_id.length;i++){
			
			 Test_answer ta=new Test_answer();
	    	 for(int j=0;j<zh.length;j++){
	    		 ta.setPerson_id(person_id[i]);
	    		 ta.setT_id(zh[j]);
	    		 tas.save_person_test(ta);
	    		 
	    	 }
		}
		return SUCCESS;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * END测评表
	 */
	
/*
 * 
 * 
 * 
 * 系统权限
 */

	//查询职工
	public String select(){
		
		
		List<Person> p=null;
		request.getSession().setAttribute("canshu", "allot");
		if(cxfs.equals("zgbh")){
			p=person.gPerson_id(cxxx);
			
		}
		else if(cxfs.equals("zgxm")){
			try {
				System.out.println(cxxx);
				String a=new String(cxxx.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(a);
				p=person.gName(a);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(cxfs.equals("jgmc")){
			try {
				System.out.println(cxxx3);
				String a=new String(cxxx3.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(a);
				p=person.gOrgnization(a);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(cxfs.equals("zwmc")){
			try {
				System.out.println(cxxx4);
				String a=new String(cxxx4.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(a);
				p=person.gPosition(a);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p=person.gPosition(cxxx);
		}
		request.getSession().setAttribute("person_info", p);
		request.getSession().setAttribute("qxzl2", "xtqx");
		return SUCCESS;
	}
	//跳到删除
	public String to_delete(){
		List<Permission> list=ps.findP();
		request.getSession().setAttribute("permissions", list);
		return SUCCESS;
	}
	//查找要删除的
	public String select_xtqx_delete(){
		
		String a;
		try {
			a = new String(delete_xtqx.getBytes("ISO-8859-1"),"UTF-8");
			List<Permission_assignment> list=pas.findPAByName(a);
			if(list!=null){
				Person[] p=new Person[list.size()];
				for(int i=0;i<list.size();i++){
					System.out.println(a);
					System.out.println(list.get(i).getPerson_id());
					Person p2=person.getPersonById(list.get(i).getPerson_id());
					if(p!=null){
						p[i]=p2;
					}
				}
				request.getSession().setAttribute("list_person", p);
				request.getSession().setAttribute("xtqx_delete", a);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	//收回权限
	public String delete_xtqx(){
		
		try {
			String a = new String(request.getParameter("delete_xtqx_again").getBytes("ISO-8859-1"),"UTF-8");
			String[] person_id=request.getParameterValues("person_name");
			if(person_id!=null){
				for(int i=0;i<person_id.length;i++){
					pas.delPA(person_id[i], a);
					List<Permission_assignment> list=pas.findPA(person_id[i]);
					//System.out.println(list.size());
					//System.out.println("kk2");
					if(list.size()==0){
						System.out.println("kk");
						Person_detail list2=pds.getInfo(person_id[i]);
						if(list2==null){
							System.out.println("person_id出错_删除");
						}
						else 
							if(list2.getPd_role().equals("2")){
							    list2.setPd_role("1");
							    pds.updateDetail(list2);
						    }
					}
				}
				return SUCCESS;
				
			}
			else
				return ERROR;
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//保存权限分配
	public String save_permission(){
		
		
		//职工编号
		String[] person_id=request.getParameterValues("person_name");
		//权限代码
		String[] permission_id=request.getParameterValues("name2");
		//哪种权限参数
	//	String hid_pd=request.getParameter("hid_pd");
		if(person_id==null){
			request.setAttribute("error_message", "请至少选择一名职工");
			return ERROR;
			
		}
		if(permission_id==null){
			request.setAttribute("error_message", "请至少选择一项权限或试卷或测评表或培训");
			return ERROR;
		}
		for(int i=0;i<person_id.length;i++){
		
		  
			//保存用户和系统权限
			for(int j=0;j<permission_id.length;j++){
				 Permission_assignment pa=new Permission_assignment();
				 try {
					String a=new String(permission_id[j].getBytes("ISO-8859-1"),"UTF-8");
					 pa.setPermission_name(a);
					 pa.setPerson_id(person_id[i]);
					 pas.savePA(pa);
					
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		//修改角色成为管理员
			Person_detail list=pds.getInfo(person_id[i]);
			if(list==null){
				System.out.println("person_id出错");
			}
			else 
				if(list.getPd_role().equals("1")){
				    list.setPd_role("2");
				    pds.updateDetail(list);
			}
			
		}
		return SUCCESS;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * END系统权限
	 */


	//查询权限种类
	
	public String cxqxzl(){
		if(qxzl.equals("xtqx")){
			request.getSession().setAttribute("qxzl2", "xtqx");
		}
		else if(qxzl.equals("cpqx")){
			List<Test> list=ts.getTestList();
			request.getSession().setAttribute("qxzl2", "cpqx");
			request.getSession().setAttribute("list_dtqx2", list);
			
		}
		else if(qxzl.equals("dtqx")){
			
			List<Test_produce> list=tps.findAll();
			request.getSession().setAttribute("qxzl2", "dtqx");
			request.getSession().setAttribute("list_dtqx", list);
		}
		else if(qxzl.equals("pxqx")){
			List<Course> list=cs.getCourseByIntorduction("培训");
			request.getSession().setAttribute("qxzl2", "pxqx");
			request.getSession().setAttribute("list_pxqx", list);
			
		}
		return SUCCESS;
	}
	public long[] switch_sl(String[] a){
		long[] b=new long[a.length];
		for(int i=0;i<a.length;i++){
			b[i]=Long.parseLong(a[i]);
		}
		return b;
	}
}
