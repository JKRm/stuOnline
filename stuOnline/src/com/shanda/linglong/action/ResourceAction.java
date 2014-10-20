package com.shanda.linglong.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.service.ResourceService;

@Component("resourceAction")
public class ResourceAction extends ActionSupport implements ServletRequestAware{
	
	private HttpServletRequest request;

	private HttpSession session;
	
	private ResourceService rs;

	@Resource(name = "resourceService")
	public void setRs(ResourceService rs) {
		this.rs = rs;
	}

	public ResourceService getRs() {
		return rs;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	public String execute(){
		
		List<Course_resource> crList = new ArrayList<Course_resource>();
		
		crList = rs.getList();
		
		request.setAttribute("crList", crList);
		
		return SUCCESS;
	}
	
	public String delete(){
		
		long id = Long.parseLong(request.getParameter("nid"));
		
		Course_resource cr = new Course_resource();
		
		cr = rs.getResource(id);
		
		String path = System.getenv("CATALINA_HOME")+"\\webapps\\studentOnline_source\\CourseResource\\";
		
		File swfFile;
		
		File sourceFile;
		
		try {
			
			swfFile = new File(path + cr.getCr_url());
			
			sourceFile = new File(path+cr.getCr_name());
			
			if (swfFile.exists()) {
				
				swfFile.delete();

			}
			
			if (sourceFile.exists()) {
				
				sourceFile.delete();
			}
			
			rs.delResource(id);
			
		}
		catch (Exception e) {
			
			return ERROR;
		}

		
		return SUCCESS;
	}

}
