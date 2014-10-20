package com.shanda.linglong.action;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Test;
import com.shanda.linglong.model.Test_option;
import com.shanda.linglong.model.Test_question;
import com.shanda.linglong.service.TestService;
import com.shanda.linglong.service.Test_optionService;

@Scope("prototype")
public class PreviewTestAction extends ActionSupport implements
		ServletRequestAware {

	private HttpServletRequest request;

	private HttpSession session;

	private TestService testService;

	private Test_optionService test_optionService;

	private InputStream inputStream;

	private static int offset;

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
			if(test.getT_explain() != null){
				request.setAttribute("t_explain",
						test.getT_explain().replace("<br />", "\n"));
			}
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
		long t_id = Long.valueOf(request.getParameter("t_id"));
		Test_question test_question = testService
				.getTest_question(offset, t_id);
		if (test_question != null) {
			request.setAttribute("test_question", test_question);
			List<Test_option> test_option = test_optionService
					.getTest_options(test_question.getTq_id());
			request.setAttribute("test_option", test_option);
			++offset;
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
