package com.shanda.linglong.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Exam_option;
import com.shanda.linglong.service.CourseService;
import com.shanda.linglong.service.ExamService;
import com.shanda.linglong.service.Exam_optionService;
import com.shanda.linglong.vo.ExamVo;

@Scope("prototype")
public class ExamUploadAction extends ActionSupport implements ServletRequestAware, ModelDriven<ExamVo> {

	private HttpServletRequest request;

	private HttpSession session;
	
	private CourseService courseService;
	
	private ExamService examService;
	
	private ExamVo examVo = new ExamVo();
	
	private Exam_optionService exam_optionService;
	
	public Exam_optionService getExam_optionService() {
		return exam_optionService;
	}

	@Resource(name="exam_optionService")
	public void setExam_optionService(Exam_optionService exam_optionService) {
		this.exam_optionService = exam_optionService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public ExamService getExamService() {
		return examService;
	}

	@Resource(name="examService")
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public ExamVo getExamVo() {
		return examVo;
	}

	public void setExamVo(ExamVo examVo) {
		this.examVo = examVo;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	@Resource(name="courseService")
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	public ExamVo getModel() {
		return examVo;
	}

	public String getList(){
		try{
			List<Course> courseList = courseService.getKno("知识点");
			session.setAttribute("courseList", courseList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String execute(){
		try{
			Exam exam = new Exam();
			exam.setE_answer(examVo.getE_answer());
			exam.setE_kno_id(Long.valueOf(examVo.getE_kno_id()));
			exam.setE_question(examVo.getE_question());
			exam.setE_score(Long.valueOf(examVo.getE_score()));
			exam.setE_type(examVo.getE_type());
			System.out.println(exam.getE_type());
			examService.add(exam);
			if(exam.getE_type().equalsIgnoreCase("选择")){
				String[] eo_option = examVo.getEo_option();
				for(int i = 0; i < eo_option.length; ++i){
					Exam_option exam_option = new Exam_option();
					exam_option.setE_id(exam.getE_id());
					exam_option.setEo_option(examVo.getEo_option()[i]);
					exam_optionService.add(exam_option);
				}
				
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

}
