package com.shanda.linglong.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Test_option;
import com.shanda.linglong.model.Test_tem;
import com.shanda.linglong.service.TestService;
import com.shanda.linglong.service.Test_optionService;

@Scope("prototype")
public class AnalyseTestAction extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;

	private HttpSession session;
	
	private TestService testService;
	
	private Test_optionService test_optionService;
	
	public Test_optionService getTest_optionService() {
		return test_optionService;
	}

	@Resource(name="test_optionService")
	public void setTest_optionService(Test_optionService test_optionService) {
		this.test_optionService = test_optionService;
	}

	public TestService getTestService() {
		return testService;
	}

	@Resource(name="testService")
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	public String execute(){
		try{
			String person_id = (String)session.getAttribute("person_id");
			long t_id = (Long)session.getAttribute("t_id");
			List<Test_tem> test_temList = testService.getTest_temList(person_id, t_id);
			List<Test_option> test_optionList = new ArrayList<Test_option>();
			for(Test_tem test_tem : test_temList){
				Test_option test_option = test_optionService.getTest_option(test_tem.getToption_id());
				test_optionList.add(test_option);
			}
			request.setAttribute("test_optionList", test_optionList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
	public String getTotal(){
		try{
			String person_id = (String)session.getAttribute("person_id");
			long t_id = (Long)session.getAttribute("t_id");
			float total = testService.getTotalScore(person_id, t_id);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
}
