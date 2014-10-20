package com.shanda.linglong.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Person;
import com.shanda.linglong.model.Test;
import com.shanda.linglong.model.Test_answer;
import com.shanda.linglong.model.Test_option;
import com.shanda.linglong.model.Test_question;
import com.shanda.linglong.model.Test_tem;
import com.shanda.linglong.service.PersonService;
import com.shanda.linglong.service.TestService;
import com.shanda.linglong.service.Test_optionService;

@Scope("prototype")
public class AnswerTestAction extends ActionSupport implements
		ServletRequestAware {

	private HttpServletRequest request;

	private HttpSession session;

	private TestService testService;

	private Test_optionService test_optionService;

	private InputStream inputStream;

	private static int offset;

	private PersonService personService;
	
	private String ta_analyse;
	
	public String getTa_analyse() {
		return ta_analyse;
	}

	public void setTa_analyse(String ta_analyse) {
		this.ta_analyse = ta_analyse;
	}

	public PersonService getPersonService() {
		return personService;
	}

	@Resource(name="PersonService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public TestService getTestService() {
		return testService;
	}

	public Test_optionService getTest_optionService() {
		return test_optionService;
	}

	@Resource(name = "test_optionService")
	public void setTest_optionService(Test_optionService test_optionService) {
		this.test_optionService = test_optionService;
	}

	@Resource(name = "testService")
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	public String execute() {
		try{
			Test test = testService.getTestByT_id(Long.valueOf(request
					.getParameter("t_id")));
			request.setAttribute("t_name", test.getT_name());
			request.setAttribute("t_explain", test.getT_explain());
			request.setAttribute("t_time", test.getT_time());
			session.setAttribute("t_id", test.getT_id());
			offset = 0;
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

	public String listTest() {
		try{
			List<Test> testList = testService.getTestList();
			session.setAttribute("testList", testList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

	public String listTest_question() {
		long t_id = (Long) session.getAttribute("t_id");
		long toption_id = Long.valueOf(request.getParameter("toption_id"));
		long tq_id = (Long)session.getAttribute("tq_id");
		Test_tem test_tem = new Test_tem();
		test_tem.setPerson_id((String) session.getAttribute("myUser"));
		test_tem.setT_id(t_id);
		test_tem.setToption_id(toption_id);
		test_tem.setTq_id(tq_id);
		testService.addTest_tem(test_tem);
		Test_question test_question = testService
				.getTest_question(offset, t_id);
		if(test_question != null){
			request.setAttribute("test_question", test_question);
			List<Test_option> test_option = test_optionService
			.getTest_options(test_question.getTq_id());
			session.setAttribute("tq_id", test_question.getTq_id());
			request.setAttribute("test_option", test_option);
			++offset;
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	public String Test_question() {
		try {
			long t_id = Long.valueOf((Long) session.getAttribute("t_id"));
			Test_question test_question = testService.getTest_question(offset,
					t_id);
			request.setAttribute("test_question", test_question);
			List<Test_option> test_option = test_optionService
					.getTest_options(test_question.getTq_id());
			session.setAttribute("tq_id", test_question.getTq_id());
			request.setAttribute("test_option", test_option);
			++offset;
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String test_answerList(){
		try{
			String person_id = (String) session.getAttribute("myUser");
			List<Test_answer> testAnswerList = testService.getTest_answerByPerson_id(person_id);
			List<Test> testList = new ArrayList<Test>();
			List<Long> yonList = new ArrayList<Long>();
			List<Integer> showList = new ArrayList<Integer>();
			for(Test_answer test_answer : testAnswerList){
				Test test = testService.getTestByT_id(test_answer.getT_id());
				testList.add(test);
				yonList.add(test_answer.getTa_yon());
				List<Test_question> test_questionList = testService.getTest_questions(test_answer.getT_id());
				List<Test_tem> test_temList = testService.getTest_temList(person_id, test_answer.getT_id());
				if(test_questionList.size() == test_temList.size())
					showList.add(1);
				else
					showList.add(0);
			}
			request.setAttribute("showList", showList);
			request.setAttribute("testList", testList);
			request.setAttribute("yonList", yonList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String searchAnalyse(){
		try{
			String person_id = (String) session.getAttribute("myUser");
			long t_id = Long.valueOf((request.getParameter("t_id")));
			System.out.println(person_id);
			System.out.println(t_id);
			Test_answer testAnswer = testService.getTest_answer(person_id, t_id);
			request.setAttribute("testAnswer", testAnswer);
			if(testAnswer==null){
				System.out.println("zhi dao le");
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String personList(){
		try{
			long t_id = Long.valueOf(request.getParameter("t_id"));
			session.setAttribute("t_id", t_id);
			List<Test_answer> test_answerList = testService.getTest_answerByT_id(t_id);
			List<Person> personList = new ArrayList<Person>();
			List<Integer> yonList = new ArrayList<Integer>();
			for(Test_answer test_answer : test_answerList){
				Person person = personService.getPersonById(test_answer.getPerson_id());
				personList.add(person);
				
				if(test_answer.getTa_yon() == 1)
					yonList.add(1);
				else
					yonList.add(0);
				
			}
			request.setAttribute("personList", personList);
			request.setAttribute("yonList", yonList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String personTestList(){
		try{
			String person_id = (String) request.getParameter("person_id");
			String yon = (String) request.getParameter("yon");
			request.setAttribute("yon", yon);
			long t_id = (Long) session.getAttribute("t_id");
			Test_answer test_answer = testService.getTest_answer(person_id, t_id);
			List<Test_tem> test_temList = testService.getTest_temList(person_id, t_id);
			long sum = 0;
			for(Test_tem test_tem : test_temList){
				Test_option test_option = test_optionService.getTest_option(test_tem.getToption_id());
				sum += test_option.getTo_score();
			}
			test_answer.setTa_score(sum);
			testService.updateTest_answer(test_answer);
			session.setAttribute("test_answer", test_answer);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String evaluateTest(){
		try{
			Test_answer test_answer = (Test_answer) session.getAttribute("test_answer");
			test_answer.setTa_analyse(ta_analyse);
			test_answer.setTa_yon(1);
			testService.updateTest_answer(test_answer);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
}
