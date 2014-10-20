package com.shanda.linglong.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Answer;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Exam_option;
import com.shanda.linglong.model.Exam_paper;
import com.shanda.linglong.model.Exam_tem;
import com.shanda.linglong.model.Test_produce;
import com.shanda.linglong.service.ExamService;
import com.shanda.linglong.service.Exam_optionService;

@Scope("prototype")
public class AnswerExamAction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;

	private HttpSession session;
	
	private ExamService examService;

	private Exam_optionService exam_optionService;
	
	private String a_answer;
	
	private String[] a_score;
	
	private String[] a_annotate;
	
	private String[] ep_annlyse;
	
	public String[] getEp_annlyse() {
		return ep_annlyse;
	}

	public void setEp_annlyse(String[] ep_annlyse) {
		this.ep_annlyse = ep_annlyse;
	}

	public String[] getA_score() {
		return a_score;
	}

	public void setA_score(String[] a_score) {
		this.a_score = a_score;
	}

	public String[] getA_annotate() {
		return a_annotate;
	}

	public void setA_annotate(String[] a_annotate) {
		this.a_annotate = a_annotate;
	}

	public String getA_answer() {
		return a_answer;
	}

	public void setA_answer(String a_answer) {
		this.a_answer = a_answer;
	}

	public ExamService getExamService() {
		return examService;
	}

	@Resource(name="examService")
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	public Exam_optionService getExam_optionService() {
		return exam_optionService;
	}

	@Resource(name="exam_optionService")
	public void setExam_optionService(Exam_optionService exam_optionService) {
		this.exam_optionService = exam_optionService;
	}

	public String getList(){
		try{
			List<Test_produce> test_produceList = examService.getTest_produceList();
			request.setAttribute("test_produceList", test_produceList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String execute(){
		try{
			long tp_id = Long.valueOf(request.getParameter("tp_id"));
			session.setAttribute("tp_id", tp_id);
			Test_produce test_produce = examService.getTest_produce(tp_id);
			request.setAttribute("test_produce", test_produce);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

	public String personAnaly(){
		try{
			long tp_id = Long.valueOf(request.getParameter("tp_id"));
			List<Exam_paper> exam_paperList = examService.getExam_paperByTp_id(tp_id);
			session.setAttribute("exam_paperList", exam_paperList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String finshow(){
		try{
			List<Exam_paper> exam_paperList = (List<Exam_paper>)session.getAttribute("exam_paperList");
			for(int i = 0; i < exam_paperList.size(); ++i){
				exam_paperList.get(i).setEp_annlyse(ep_annlyse[i]);
				exam_paperList.get(i).setEp_yon(1);
				examService.updateExam_paper(exam_paperList.get(i));
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String grade(){
		try{
			long tp_id = Long.valueOf(request.getParameter("tp_id"));
			session.setAttribute("tp_id", tp_id);
			List<Exam_tem> exam_temList = examService.getExam_temList(tp_id);
			List<Exam> exam1List = new ArrayList<Exam>();
			List<Exam> exam2List = new ArrayList<Exam>();
			List<Exam> exam3List = new ArrayList<Exam>();
			List<Exam> exam4List = new ArrayList<Exam>();
			List<Exam> exam5List = new ArrayList<Exam>();
			List<Exam> exam6List = new ArrayList<Exam>();
			List<Exam> exam7List = new ArrayList<Exam>();
			List<Exam> exam8List = new ArrayList<Exam>();
			for(Exam_tem exam_tem : exam_temList){
				Exam exam = examService.getExamByE_id(exam_tem.getE_id());
				if(exam.getE_type().equals("判断题")){
					exam1List.add(exam);
				}else if(exam.getE_type().equals("辨析题")){
					exam2List.add(exam);
				}else if(exam.getE_type().equals("选择")){
					exam3List.add(exam);
				}else if(exam.getE_type().equals("填空")){
					exam4List.add(exam);
				}else if(exam.getE_type().equals("名词解释")){
					exam5List.add(exam);
				}else if(exam.getE_type().equals("计算题")){
					exam6List.add(exam);
				}else if(exam.getE_type().equals("简答题")){
					exam7List.add(exam);
				}else if(exam.getE_type().equals("实践题")){
					exam8List.add(exam);
				}else{
					
				}
			}
			request.setAttribute("exam1List", exam1List);
			request.setAttribute("exam2List", exam2List);
			request.setAttribute("exam3List", exam4List);
			request.setAttribute("exam4List", exam4List);
			request.setAttribute("exam5List", exam5List);
			request.setAttribute("exam6List", exam6List);
			request.setAttribute("exam7List", exam7List);
			request.setAttribute("exam8List", exam8List);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String examList(){
		try{
			long tp_id = (Long)session.getAttribute("tp_id");
			List<Exam_tem> exam_temList = examService.getExam_temList(tp_id);
			request.setAttribute("exam_temList", exam_temList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String analy(){
		long e_id = Long.valueOf(request.getParameter("e_id"));
		long tp_id = (Long)session.getAttribute("tp_id");
		Exam_tem exam_tem = examService.getExam_temBy(tp_id, e_id);
		Exam exam = examService.getExamByE_id(e_id);
		List<Answer> answerList = examService.getAnswerListBy(exam_tem.getE_title(), tp_id);
		request.setAttribute("exam",exam );
		if(answerList.size() > 0){
			session.setAttribute("answerList",answerList);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String subm(){
		List<Answer> answerList = (List<Answer>)session.getAttribute("answerList");
		for(int i = 0; i < answerList.size(); ++i){
			answerList.get(i).setA_annotate(a_annotate[i]);
			long s = Long.valueOf(a_score[i]);
			answerList.get(i).setA_score(s);
			examService.updateAnswer(answerList.get(i));
		}
		return SUCCESS;
	}
	
	public String exam(){
		long e_id = Long.valueOf(request.getParameter("e_id"));
		session.setAttribute("e_id", e_id);
		Exam exam = examService.getExamByE_id(e_id);
		request.setAttribute("exam", exam);
		if(exam.getE_type().equalsIgnoreCase("选择")){
			List<Exam_option> exam_optionList = exam_optionService.getExamByE_id(e_id);
			request.setAttribute("exam_optionList", exam_optionList);
		}
		return SUCCESS;
	}

	public String examPersonList(){
		try{
			System.out.println("1");
			String person_id = (String)session.getAttribute("myUser");
			System.out.println("2");
			List<Exam_paper> examPaperList = examService.getExam_paperByPerson_id(person_id);
			System.out.println("3");
			List<Test_produce> testProduceList = new ArrayList<Test_produce>();
			System.out.println("4");
			List<Long> ep_yon = new ArrayList<Long>();
			List<Integer> show = new ArrayList<Integer>();
			for(Exam_paper exam_paper : examPaperList){
				System.out.println("5");
				Test_produce test_produce = examService.getTest_produce(exam_paper.getTp_id());
				System.out.println("15");
				testProduceList.add(test_produce);
				System.out.println("25");
				ep_yon.add(exam_paper.getEp_yon());
				System.out.println("35");
				if(examService.getExam_temList(exam_paper.getTp_id()).size() == examService.getAnswerList(person_id, exam_paper.getTp_id()).size()){
					System.out.println("6");
					show.add(1);
				}else{
					System.out.println("7");
					show.add(0);
				}
			}
			System.out.println("8");
			request.setAttribute("testProduceList", testProduceList);
			request.setAttribute("ep_yon", ep_yon);
			request.setAttribute("show", show);
			return SUCCESS;
		}catch(Exception e){
			System.out.println("9");
			return ERROR;
		}
	}
	
	public String showAnalyse(){
		try{
			String person_id = (String) session.getAttribute("myUser");
			long tp_id = Long.valueOf((request.getParameter("tp_id")));
			Exam_paper examPaper = examService.getExam_paper(person_id, tp_id);
			request.setAttribute("examPaper", examPaper);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String examAnswerList(){
		try{
			long tp_id = (Long)session.getAttribute("tp_id");
			List<Exam_tem> exam_temList = examService.getExam_temList(tp_id);
			List<Exam> exam1List = new ArrayList<Exam>();
			List<Exam> exam2List = new ArrayList<Exam>();
			List<Exam> exam3List = new ArrayList<Exam>();
			List<Exam> exam4List = new ArrayList<Exam>();
			List<Exam> exam5List = new ArrayList<Exam>();
			List<Exam> exam6List = new ArrayList<Exam>();
			List<Exam> exam7List = new ArrayList<Exam>();
			List<Exam> exam8List = new ArrayList<Exam>();
			for(Exam_tem exam_tem : exam_temList){
				Exam exam = examService.getExamByE_id(exam_tem.getE_id());
				if(exam.getE_type().equals("判断题")){
					exam1List.add(exam);
				}else if(exam.getE_type().equals("辨析题")){
					exam2List.add(exam);
				}else if(exam.getE_type().equals("选择")){
					exam3List.add(exam);
				}else if(exam.getE_type().equals("填空")){
					exam4List.add(exam);
				}else if(exam.getE_type().equals("名词解释")){
					exam5List.add(exam);
				}else if(exam.getE_type().equals("计算题")){
					exam6List.add(exam);
				}else if(exam.getE_type().equals("简答题")){
					exam7List.add(exam);
				}else if(exam.getE_type().equals("实践题")){
					exam8List.add(exam);
				}else{

				}
			}
			request.setAttribute("exam1List", exam1List);
			request.setAttribute("exam2List", exam2List);
			request.setAttribute("exam3List", exam4List);
			request.setAttribute("exam4List", exam4List);
			request.setAttribute("exam5List", exam5List);
			request.setAttribute("exam6List", exam6List);
			request.setAttribute("exam7List", exam7List);
			request.setAttribute("exam8List", exam8List);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String insertAnswer(){
		try{
			String person_id = (String)session.getAttribute("myUser");
			long tp_id = (Long)session.getAttribute("tp_id");
			long e_id = (Long)session.getAttribute("e_id");
			Exam_tem exam_tem = examService.getExam_temBy(tp_id, e_id);
			examService.saveSubjectiveAnswer(person_id, tp_id, exam_tem.getE_title(), a_answer);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String examPaper(){
		try{
			long tp_id = Long.valueOf(request.getParameter("tp_id"));
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String showAnalysePerson(){
		try{
			long tp_id = Long.valueOf((request.getParameter("tp_id")));
			String person_id = (String)session.getAttribute("myUser");
			Exam_paper exam_paper = examService.getExam_paper(person_id, tp_id);
			request.setAttribute("exam_paper", exam_paper);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
}
