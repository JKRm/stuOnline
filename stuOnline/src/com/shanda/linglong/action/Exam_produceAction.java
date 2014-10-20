package com.shanda.linglong.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Exam_tem;
import com.shanda.linglong.model.Test_produce;
import com.shanda.linglong.service.CourseService;
import com.shanda.linglong.service.ExamService;
import com.shanda.linglong.vo.Exam_produceLv1Vo;

@Scope("prototype")
public class Exam_produceAction extends ActionSupport implements ServletRequestAware,ModelDriven<Exam_produceLv1Vo>{
	
	private HttpServletRequest request;

	private HttpSession session;
	
	private CourseService courseService;
	
	private ExamService examService;
	
	private Exam_produceLv1Vo exam_produceLv1Vo = new Exam_produceLv1Vo();
	
	private String[] course;
	
	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public ExamService getExamService() {
		return examService;
	}

	@Resource(name="examService")
	public void setExamService(ExamService examService) {
		this.examService = examService;
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
	public Exam_produceLv1Vo getModel() {
		return exam_produceLv1Vo;
	}
	
	public String execute(){
		try{
			Test_produce test_produce = new Test_produce();
			test_produce.setC_id(Long.valueOf(exam_produceLv1Vo.getC_id()));
			test_produce.setTp_title(exam_produceLv1Vo.getTp_title());
			test_produce.setTp_describe(exam_produceLv1Vo.getTp_describe());
			examService.addTest_produce(test_produce);
			Set<Course> courseSet = courseService.getCourseId(test_produce.getC_id());
			session.setAttribute("courseSet", courseSet);
			session.setAttribute("tp_id", test_produce.getTp_id());
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String getList(){
		try{
			List<Course> courseProduceList = courseService.getExam_produceList();
			request.setAttribute("courseProduceList", courseProduceList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String munexe(){
		try{
			Test_produce test_produce = new Test_produce();
			test_produce.setC_id(Long.valueOf(exam_produceLv1Vo.getC_id()));
			test_produce.setTp_title(exam_produceLv1Vo.getTp_title());
			test_produce.setTp_describe(exam_produceLv1Vo.getTp_describe());
			examService.addTest_produce(test_produce);
			Set<Course> courseSet = courseService.getCourseId(test_produce.getC_id());
			List<Exam> exam1List = new ArrayList<Exam>();
			List<Exam> exam2List = new ArrayList<Exam>();
			List<Exam> exam3List = new ArrayList<Exam>();
			List<Exam> exam4List = new ArrayList<Exam>();
			List<Exam> exam5List = new ArrayList<Exam>();
			List<Exam> exam6List = new ArrayList<Exam>();
			List<Exam> exam7List = new ArrayList<Exam>();
			List<Exam> exam8List = new ArrayList<Exam>();
			for(Course course : courseSet){
				System.out.println(course.getC_name());
				List<Exam> tem = examService.getExamByC_id(course.getC_id());
				if(tem.size() > 0){
					for(int i = 0; i< tem.size(); ++i){
						if(tem.get(i).getE_type().equals("填空")){
							exam1List.add(tem.get(i));
						}else if(tem.get(i).getE_type().equals("名词解释")){
							exam2List.add(tem.get(i));
						}else if(tem.get(i).getE_type().equals("辨析题")){
							exam3List.add(tem.get(i));
						}else if(tem.get(i).getE_type().equals("判断题")){
							exam4List.add(tem.get(i));
						}else if(tem.get(i).getE_type().equals("简答题")){
							exam5List.add(tem.get(i));
						}else if(tem.get(i).getE_type().equals("计算题")){
							exam6List.add(tem.get(i));
						}else if(tem.get(i).getE_type().equals("实践题")){
							exam7List.add(tem.get(i));
						}else{
							exam8List.add(tem.get(i));
						}
					}
				}
			}
			request.setAttribute("exam1List", exam1List);
			request.setAttribute("exam2List", exam2List);
			request.setAttribute("exam3List", exam3List);
			request.setAttribute("exam4List", exam4List);
			request.setAttribute("exam5List", exam5List);
			request.setAttribute("exam6List", exam6List);
			request.setAttribute("exam7List", exam7List);
			request.setAttribute("exam8List", exam8List);
			session.setAttribute("tp_id", test_produce.getTp_id());
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String insertTem(){
		try{
			long tp_id = (Long)session.getAttribute("tp_id");
			for(String s_id : course){
				Exam_tem exam_tem = new Exam_tem();
				exam_tem.setTp_id(tp_id);
				long e_id = Long.valueOf(s_id);
				exam_tem.setE_id(e_id);
				examService.saveExam_tem(exam_tem);
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
}
