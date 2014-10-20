package com.shanda.linglong.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Test;
import com.shanda.linglong.service.TestService;
import com.shanda.linglong.vo.TestVo;

@Scope(value = "prototype")
public class UploadTestAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<TestVo> {

	private HttpServletRequest request;

	private HttpSession session;

	private TestVo testVo = new TestVo();

	private TestService testService;

	private InputStream inputStream;

	public TestService getTestService() {
		return testService;
	}

	@Resource(name = "testService")
	public void setTestService(TestService testService) {
		this.testService = testService;
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
	public TestVo getModel() {
		return testVo;
	}

	public String execute() {
		Test test = new Test();
		test.setT_name(testVo.getT_name());
		if(testVo.getT_explain() != null){
			test.setT_explain(testVo.getT_explain().replace("\n", "<br />"));
		}
		if (testService.add(test)) {
			session.setAttribute("t_id", test.getT_id());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String updateTest() throws Exception {
		Test test = testService.getTestByT_id(Long.valueOf(request
				.getParameter("t_id")));
		test.setT_name(testVo.getT_name());
		if(testVo.getT_explain() != null){
			test.setT_explain(testVo.getT_explain().replace("\n", "<br />"));
		}
		if (testService.update(test)) {
			request.setAttribute("t_id", test.getT_id());
			inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
			return SUCCESS;
		} else {
			inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			return ERROR;
		}
	}
}
