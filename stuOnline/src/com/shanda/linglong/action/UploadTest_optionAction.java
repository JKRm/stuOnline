package com.shanda.linglong.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Test;
import com.shanda.linglong.model.Test_option;
import com.shanda.linglong.model.Test_question;
import com.shanda.linglong.service.TestService;
import com.shanda.linglong.service.Test_optionService;
import com.shanda.linglong.vo.Test_questionVo;

@Scope(value="prototype")
public class UploadTest_optionAction extends ActionSupport implements ServletRequestAware,ModelDriven<Test_questionVo>{

	private HttpServletRequest request;

	private HttpSession session;
	
	private TestService testService;
	
	private Test_optionService test_optionService;
	
	private Test_questionVo test_questionVo = new Test_questionVo();
	
	private String toption_id;
	
	private String to_optionArray;
	
	private String to_scoreArray;
	
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String getToption_id() {
		return toption_id;
	}

	public void setToption_id(String toption_id) {
		this.toption_id = toption_id;
	}

	public String getTo_optionArray() {
		return to_optionArray;
	}

	public void setTo_optionArray(String to_optionArray) {
		this.to_optionArray = to_optionArray;
	}

	public String getTo_scoreArray() {
		return to_scoreArray;
	}

	public void setTo_scoreArray(String to_scoreArray) {
		this.to_scoreArray = to_scoreArray;
	}

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
	
	@Override
	public Test_questionVo getModel() {
		return test_questionVo;
	}
	
	public String execute(){
		try{
			Test_question test_question = new Test_question();
			test_question.setTq_question(test_questionVo.getTq_question());
			test_question.setT_id((Long)session.getAttribute("t_id"));
			testService.addTest_question(test_question);
			for(int i = 0; i < test_questionVo.getTo_option().length; ++i){
				Test_option test_option = new Test_option();
				test_option.setT_id((Long)session.getAttribute("t_id"));
				test_option.setTo_option(test_questionVo.getTo_option()[i]);
				test_option.setTo_score(Long.valueOf(test_questionVo.getTo_score()[i]));
				test_option.setTq_id(test_question.getTq_id());
				test_optionService.add(test_option);
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

	public String updateTest_question() throws Exception{
		try{
			String[] toA = toption_id.split(",");
			String[] toP = to_optionArray.split(",");
			String[] toS = to_scoreArray.split(",");
			for(int i = 0; i < toA.length; ++i){
				Test_option test_option = test_optionService.getTest_option(Long.valueOf(toA[i].trim()));
				test_option.setTo_option(toP[i].trim());
				test_option.setTo_score(Long.valueOf(toS[i].trim()));
				test_optionService.update(test_option);
			}
			inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	
}
