package com.shanda.linglong.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.service.CourseService;
import com.shanda.linglong.service.ResourceService;
import com.shanda.linglong.util.DateUtil;
import com.shanda.linglong.util.DocConverter;

@SuppressWarnings("serial")
public class FileUploadAction extends ActionSupport implements ServletRequestAware {

	private File upload; // ��װ�ϴ��ļ��������

	private String uploadContentType; // ��װ�ϴ��ļ����͵�����

	private String uploadFileName; // ��װ�ϴ��ļ���������

	private String type;

	private String title;
	
	private CourseService cs;
	
	private ResourceService rs;
	
	private HttpServletRequest request;

	private HttpSession session;
	
	private int point;
	
	private String isDownload;


	public String getIsDownload() {
		return isDownload;
	}

	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	@Resource(name = "courseService")
	public void setCs(CourseService cs) {
		this.cs = cs;
	}

	public CourseService getCs() {
		return cs;
	}
	
	@Resource(name = "resourceService")
	public void setRs(ResourceService rs) {
		this.rs = rs;
	}

	public ResourceService getRs() {
		return rs;
	}

	private String getSavePath() throws Exception // �����ϴ��ļ��ı���λ��
	{
		return System.getenv("CATALINA_HOME")+"\\webapps\\studentOnline_source\\CourseResource\\";
	}

	public String getType() {
		return type;
	}

	// ��ȡ�ϴ��ļ�����

	public void setType(String type) {
		type = uploadContentType.substring(
				uploadContentType.lastIndexOf("/") + 1,
				uploadContentType.length()).toLowerCase();
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUpload(File upload) // �ϴ��ļ���Ӧ�ļ����ݵ�setter��getter����
	{
		this.upload = upload;
	}

	public File getUpload() {
		return (this.upload);
	}

	public void setUploadContentType(String uploadContentType) // �ϴ��ļ����ļ����͵�setter��getter����
	{
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	public void setUploadFileName(String uploadFileName) // �ϴ��ļ����ļ�����setter��getter����
	{
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return (this.uploadFileName);
	}

	@Override
	public String execute() throws Exception 
	{
		
		String type = getUploadFileName().substring(
				 getUploadFileName().lastIndexOf("."),
				 getUploadFileName().length());
			String fileName = DateUtil.fileNameFromDate() + type;
		String filePath = getSavePath() + "\\"+ fileName;
		FileOutputStream fos = new FileOutputStream(filePath);
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		boolean flag = true;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		fos.close();

		Thread.sleep(300);
		
		DocConverter dc = new DocConverter(filePath);
		
		 dc.conver();
		 
		 Course_resource cr = new Course_resource();
		 
		 cr.setCr_url(dc.getSwfName());
		 
		 cr.setKnowledge_id(point);
		 
		 cr.setCr_name(this.getTitle());
		 
		 cr.setCr_urlname(fileName);   //change
		 
		 cr.setCr_display(Long.parseLong(isDownload));
		 
		 flag = rs.addResource(cr);
		 
		 if(flag){
			 return SUCCESS;
		 }
		 
		 else{
			 session.setAttribute("error_info", "��ӿγ�����ʧ��");
			 return ERROR;
		 }
		
	}
	
	public String initSelect(){
		
		List<Course> trainList = new ArrayList<Course>();

		trainList = cs.getCourseByIntorduction("��ѵ");

		request.setAttribute("trainList", trainList);
		
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

}
