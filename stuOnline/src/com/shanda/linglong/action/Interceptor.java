package com.shanda.linglong.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = invocation.getInvocationContext();
		Map session = (Map) ac.get(ServletActionContext.SESSION);
		if (session == null) {
			System.out.print("no session");
			return "login";
		} else {
			String username = (String) session.get("username");
			
			if (username == null) {
				System.out.print("no session.name");
				return "login";
			} else {
				return invocation.invoke();
			}
	}

}
}