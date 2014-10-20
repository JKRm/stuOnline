package com.shanda.linglong.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Train_detail;
import com.shanda.linglong.service.CourseService;
import com.shanda.linglong.service.ResourceService;
import com.shanda.linglong.util.GetPeriod;
import com.shanda.linglong.vo.TrainVo;

public class CourseDesignAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;

	private HttpSession session;

	private HttpServletResponse response;

	private InputStream inputStream;

	private CourseService cs;
	
	private ResourceService rs;
	
	private String content;
	
	private String cid;
	
	private String father;
	
	private String introduction;
	
	private String period; 
	
	private String trainName;

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCid() {
		return cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;

		this.session = request.getSession();

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {

		this.response = response;

	}

	@Resource(name = "courseService")
	public void setCs(CourseService cs) {
		this.cs = cs;
	}

	public CourseService getCs() {
		return cs;
	}

	@Resource(name = "resourceService")
	public void setRs(ResourceService rs) {
		this.rs = rs;
	}

	public ResourceService getRs() {
		return rs;
	}

	public String Gettrain() {
		
		int sort = Integer.parseInt(request.getParameter("sort"));

		List<Course> trainList = new ArrayList<Course>();

		trainList = cs.getCourseByIntorduction("培训");

		request.setAttribute("trainList", trainList);
		
		switch(sort){
		
		case 0: return "point";
		
		case 1: return "bar";
		
		case 2: return "unit";
		
		case 3: return "lesson";
		
		case 4: return "train";
		
		default: return "detail";
		
		}

	}

	public String Json4lesson() throws Exception {

		String c_pid = request.getParameter("c_pid");

		String jsonString = "[";

		List<Course> lessonList = new ArrayList<Course>();

		lessonList = cs.getCourseIntroductionAndpid("课程",
				Integer.parseInt(c_pid));

		for (int i = 0; i < lessonList.size(); i++) {

			Course course = lessonList.get(i);

			if (i != (lessonList.size() - 1)) {

				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\""

						+ course.getC_id() + "\"},";
			} else {
				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\"" + course.getC_id() + "\"}]";
			}
		}
		inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));

		// request.setAttribute("json4lesson", jsonString);

		return SUCCESS;

	}

	public String Json4unit() throws Exception {

		String c_pid = request.getParameter("c_pid");

		String jsonString = "[";

		List<Course> lessonList = new ArrayList<Course>();

		lessonList = cs.getCourseIntroductionAndpid("单元",
				Integer.parseInt(c_pid));

		for (int i = 0; i < lessonList.size(); i++) {

			Course course = lessonList.get(i);

			if (i != (lessonList.size() - 1)) {

				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\""

						+ course.getC_id() + "\"},";
			} else {
				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\"" + course.getC_id() + "\"}]";
			}
		}
		inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));

		// request.setAttribute("json4lesson", jsonString);

		return SUCCESS;

	}

	public String Json4bar() throws Exception {

		String c_pid = request.getParameter("c_pid");

		String jsonString = "[";

		List<Course> lessonList = new ArrayList<Course>();

		lessonList = cs.getCourseIntroductionAndpid("小节",
				Integer.parseInt(c_pid));
		
		for (int i = 0; i < lessonList.size(); i++) {

			Course course = lessonList.get(i);

			if (i != (lessonList.size() - 1)) {

				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\""

						+ course.getC_id() + "\"},";
			} else {
				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\"" + course.getC_id() + "\"}]";
			}
		}
		inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));

		// request.setAttribute("json4lesson", jsonString);

		return SUCCESS;

	}
	
	public String Json4point() throws Exception {

		String c_pid = request.getParameter("c_pid");

		String jsonString = "[";

		List<Course> lessonList = new ArrayList<Course>();

		lessonList = cs.getCourseIntroductionAndpid("知识点",
				Integer.parseInt(c_pid));

		for (int i = 0; i < lessonList.size(); i++) {

			Course course = lessonList.get(i);

			if (i != (lessonList.size() - 1)) {

				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\""

						+ course.getC_id() + "\"},";
			} else {
				jsonString += "{\"text\":\"" + course.getC_name()
						+ "\",\"value\":\"" + course.getC_id() + "\"}]";
			}
		}
		inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));

		// request.setAttribute("json4lesson", jsonString);

		return SUCCESS;

	}
	
	public boolean doDel(Course course){
		
		boolean flag = true;
		
		if(cs.getChildren(course.getC_id()).size()==0&&flag==true){
			
			flag = flag&&cs.delCourse(course.getC_id());
		}
		
		else{
			
			List<Course> courseList = new ArrayList<Course>();
			
			courseList = cs.getChildren(course.getC_id());
			
			for(int i=0;i<courseList.size();i++){
				
				flag = flag&&doDel(courseList.get(i));
			}
			
			flag = flag&&cs.delCourse(course.getC_id());
		}
		
		return flag;
	}
	
	public String delCourse() throws Exception{
		
		//String cid = request.getParameter("cid");
		
		//boolean flag = cs.delCourse(Long.parseLong(cid));
		
		Course course = new Course();
		
		course = cs.getCourseById(Long.parseLong(cid));
		
		boolean flag = doDel(course);
		
		if(flag){
			
			inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
		
			return SUCCESS;
		
		}
		
		else{
			
			inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			
			return ERROR;
		}
	}
	
	public String addCourse() throws Exception{
		
		Course course  = new Course();
		
		course.setC_introduction(introduction);
		
		course.setC_name(content);
		
		if(!(introduction.equals("培训"))){
			
			Course parent = new Course();
			
			parent = cs.getCourseById(Long.parseLong(father));
			
			course.setParent(parent);
			
		}
		
		cs.addCourse(course);
		
		if(true){
			
			String jsonString = "[";

			List<Course> lessonList = new ArrayList<Course>();

			if(introduction.equals("培训")){
				
				lessonList = cs.getCourseByIntorduction(introduction);
			}
			
			else{
				
				lessonList = cs.getCourseIntroductionAndpid(introduction,
						Integer.parseInt(father));
			}


			for (int i = 0; i < lessonList.size(); i++) {

				Course ncourse = lessonList.get(i);

				if (i != (lessonList.size() - 1)) {

					jsonString += "{\"text\":\"" + ncourse.getC_name()
							+ "\",\"value\":\""

							+ ncourse.getC_id() + "\"},";
				} else {
					jsonString += "{\"text\":\"" + ncourse.getC_name()
							+ "\",\"value\":\"" + ncourse.getC_id() + "\"}]";
				}
			}
			
			inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
			
			return SUCCESS;
		}
		
		else{
			
			return ERROR;
		}
		
	}
	
	public String updateCourse() throws Exception{
		
		Course course = new Course();
		
		course = cs.getCourseById(Long.parseLong(cid));
		
		course.setC_name(content);
		
		boolean flag = cs.updateCourse(course);
		
		if(flag){
			
			String jsonString = "[";

			List<Course> lessonList = new ArrayList<Course>();
			
			if(introduction.equals("培训")){
				
				lessonList = cs.getCourseByIntorduction(introduction);
			}
			
			else{
				
				lessonList = cs.getCourseIntroductionAndpid(introduction,
						Integer.parseInt(father));
			}

			for (int i = 0; i < lessonList.size(); i++) {

				Course ncourse = lessonList.get(i);

				if (i != (lessonList.size() - 1)) {

					jsonString += "{\"text\":\"" + ncourse.getC_name()
							+ "\",\"value\":\""

							+ ncourse.getC_id() + "\"},";
				} else {
					jsonString += "{\"text\":\"" + ncourse.getC_name()
							+ "\",\"value\":\"" + ncourse.getC_id() + "\"}]";
				}
			}
			
			inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	public String courseList(){     //change
		
		List<TrainVo> tvList = new ArrayList<TrainVo>();
		
		List<Course> courseList = new ArrayList<Course>();
		
		List<Person_progress> ppList = new ArrayList<Person_progress>();
		
		List<Train_detail> trainList = new ArrayList<Train_detail>();
		
		if(request.getParameter("cid")==null){
			
			ppList = cs.getAllList(session.getAttribute("myUser").toString());
			
			for(int i=0;i<ppList.size();i++){
				
				TrainVo tv = new TrainVo();
				
				long cido = ppList.get(i).getTrain_id();
				
				tv.setTrainName(cs.getCourseById(cido).getC_name());
				
				tv.setTrainId(cido);
				
				Train_detail td = new Train_detail();
				
				GetPeriod gp = new GetPeriod();
				
				if(cs.getTrainById(cido)!=null){
					
					td = cs.getTrainById(cido);
					
					System.out.println(td.getC_id());
				
					String old = ppList.get(i).getPp_begin();
				
					long period = td.getTd_period();
				
					long times = gp.getPeriod(old);
				
					if(period>=times){
						
						tv.setTrainNotice("剩余"+(period-times)+"天");
	
					}
				
					else{
						
						tv.setTrainNotice("已完成");
						
						Person_progress ppnew = new Person_progress();
						
						ppnew = ppList.get(i);
						
						ppnew.setPp_yno(1);
					
						cs.updatePP(ppnew);
					}
				
				}
				
				else{
					
					tv.setTrainNotice("时间尚未设置");

				}
				
				tvList.add(tv);
			}
			
			
			request.setAttribute("tvList", tvList);
			
			
		}
		
		else{
			
			long cid = Long.parseLong(request.getParameter("cid"));
			
			courseList = cs.getChildren(cid);
			
			if((courseList.size()==0)&&(cs.getCourseById(cid).getC_introduction().equals("知识点"))){
				
				session.setAttribute("kcid", cid);
								
				return "point";
				
			}
		}
		
		
		session.setAttribute("courseList", courseList);
		
		return SUCCESS;
	}
	
	
	
	public String resourcePage(){
		
		long cid = (Long)session.getAttribute("kcid");
		
		List<Course_resource> crList = new ArrayList<Course_resource>();
		
		crList = rs.getListBycid(cid);
		
		request.setAttribute("crList", crList);

		
		return SUCCESS;
	}
	
public String saveTrainDetail(){     //change
		
		Course course  = new Course();
		
		course.setC_introduction("培训");
		
		course.setC_name(trainName);
		
		long cid = cs.addCourse(course);
		
		Train_detail td = new Train_detail();
		
		td.setC_id(cid);
		
		td.setTd_content(content);
		
		td.setTd_period(Long.parseLong(period));
		
		boolean flag = true;
		
		if(cs.getTrainById(cid)==null){
		
			flag = cs.saveTrainDetail(td);
		
		}
		
		else{
			
			flag = cs.updateTrainDetail(td);
		}
		
		if(flag){
			
			return SUCCESS;
		}
		
		return ERROR;
		
	}

}
