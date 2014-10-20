package com.shanda.linglong.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.shanda.linglong.model.Enterprise_news;
import com.shanda.linglong.model.News_appendix;
import com.shanda.linglong.service.NewsService;
import com.shanda.linglong.util.DateUtil;
import com.shanda.linglong.vo.NewsVo;

@Scope("prototype")
@Component("newsAction")
public class NewsAction extends ActionSupport implements ServletContextAware,
		ServletRequestAware {
	
	private String title;

	private String detail;

	private String savePath;

	private String[] atitle;

	private File[] upload;

	private String[] uploadContentType;

	private String[] uploadFileName;

	private HttpServletRequest request;

	private HttpSession session;

	private ServletContext context;

	private NewsService newsService;
	
	private String nid;
	
	private String aid;

	public NewsService getNewsService() {
		return newsService;
	}

	@Resource(name = "newsService")
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public String add() {
		
		boolean isDownload = true;
		if(request.getParameter("isd")==null){
			isDownload = false;
		}
		detail = detail.replace("\n", "</p><p>");
		Enterprise_news news = new Enterprise_news();
		news.setIs_download(String.valueOf(isDownload));
		news.setEn_theme(title);
		news.setEn_content(detail);
		news.setEn_time(DateUtil.currentDateTimeToString());
		news.setEn_number(0);
		System.out.println(news.getEn_content() + "  " + news.getEn_theme()
				+ "  " + news.getEn_number() + "  " + news.getEn_time());
		newsService.addNews(news);
		int id = (int) newsService.getLatestNews().getEn_id();
		File[] files = getUpload();
		try {
			if (files != null) {
				for (int i = 0; i < files.length; ++i) {
					// 给文件重新命名
					String type = uploadFileName[i].substring(
							uploadFileName[i].lastIndexOf("."),
							uploadFileName[i].length());
					String fileName = DateUtil.fileNameFromDate() + type;
					if (atitle[i] == null || atitle[i].equals("")) {
						atitle[i] = uploadFileName[i];
					} else {
						atitle[i] += type;
					}
					// 以服务器的文件保存地址和原文件名建立上传文件输出流
					FileOutputStream fos = new FileOutputStream(getSavePath()
							+ "\\" + fileName);
					FileInputStream fis = new FileInputStream(files[i]);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = fis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close(); // 注意：流应当关闭。
					fis.close();
					News_appendix appendix = new News_appendix();
					appendix.setNews_id(id);
					appendix.setNa_name_show(atitle[i]);
					appendix.setNa_name_load(fileName);
					newsService.addNewsAppendix(appendix);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error_info", "添加通知失败");
			return "addError";
		}
		session.setAttribute("success_info", "添加通知成功");
		return "addSuccess";
	}

	public String get() {
		boolean isDownload = true;
		if(request.getParameter("isd")==null){
			isDownload = false;
		}
		int nid = Integer.parseInt(request.getParameter("nid"));
		NewsVo newsVo = newsService.getNews(nid);
		session.setAttribute("newsVo", newsVo);
		if(isDownload){
			return "download";
		}
		else{
		return SUCCESS;
		}
	}

	public String read() {
		boolean isDownload = true;
		if(request.getParameter("isd")==null){
			isDownload = false;
		}
		int nid = Integer.parseInt(request.getParameter("nid"));
		NewsVo newsVo = newsService.getNews(nid);
		Enterprise_news news = newsVo.getNews();
		news.setEn_number(news.getEn_number() + 1);
		newsVo.setNews(news);
		newsService.update(news);
		session.setAttribute("newsVo", newsVo);
		if(isDownload){
			return "download";
		}
		else{
		return SUCCESS;
		}
	}

	public String edit() {
		boolean isDownload = true;
		if(request.getParameter("isd")==null){
			isDownload = false;
		}
		int nid = Integer.parseInt(request.getParameter("nid"));
		NewsVo newsVo = newsService.getNews(nid);
		Enterprise_news news = newsVo.getNews();
		String temp = news.getEn_content();
		temp = temp.replace("</p><p>", "\n");
		news.setEn_content(temp);
		newsVo.setNews(news);
		session.setAttribute("newsVo", newsVo);
		if(isDownload){
			
			return "download";
		}
		else{
		return SUCCESS;
		}
	}

	public String save() {
		boolean isDownload = true;
		if(request.getParameter("isd")==null){
			isDownload = false;
		}
		int id = Integer.parseInt(request.getParameter("nid"));
		detail = detail.replace("\n", "</p><p>");
		NewsVo nv = newsService.getNews(id);
		Enterprise_news news = nv.getNews();
		news.setIs_download(String.valueOf(isDownload));
		news.setEn_theme(title);
		news.setEn_content(detail);
		newsService.update(news);

		File[] files = getUpload();
		try {
			if (files != null) {
				for (int i = 0; i < files.length; ++i) {
					// 给文件重新命名
					String type = uploadFileName[i].substring(
							uploadFileName[i].lastIndexOf("."),
							uploadFileName[i].length());
					String fileName = DateUtil.fileNameFromDate() + type;
					if (atitle[i] == null || atitle[i].equals("")) {
						atitle[i] = uploadFileName[i];
					} else {
						atitle[i] += type;
					}
					// 以服务器的文件保存地址和原文件名建立上传文件输出流
					FileOutputStream fos = new FileOutputStream(getSavePath()
							+ "\\" + fileName);
					FileInputStream fis = new FileInputStream(files[i]);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = fis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close(); // 注意：流应当关闭。
					fis.close();
					News_appendix appendix = new News_appendix();
					appendix.setNews_id(id);
					appendix.setNa_name_show(atitle[i]);
					appendix.setNa_name_load(fileName);
					newsService.addNewsAppendix(appendix);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error_info", "修改通知失败");
			return "error";
		}
		session.setAttribute("success_info", "修改通知成功");
		return "success";
	}

	public String getList() {
		List<Enterprise_news> news = newsService.getNewsByIsd("false");
		session.setAttribute("news", news);
		return SUCCESS;
	}

	public String getNewss() {
		List<Enterprise_news> news = newsService.getNewsByIsd("false");
		session.setAttribute("news", news);
		return SUCCESS;
	}
	
	public String getDownload(){
		List<Enterprise_news> download = newsService.getNewsByIsd("true");
		session.setAttribute("Download", download);
		return SUCCESS;
	}
	
	public String getEnDownload(){
		List<Enterprise_news> download = newsService.getNewsByIsd("true");
		session.setAttribute("Download", download);
		return SUCCESS;
	}

	public String delete() {
		int id = Integer.parseInt(this.getNid());
		System.out.println(id+"!!!!!!");
		NewsVo nv = newsService.getNews(id);
		newsService.delete(nv.getNews());
		List<News_appendix> appendixs = nv.getAppendixs();
		for (int i = 0; i < appendixs.size(); ++i) {
			String url = appendixs.get(i).getNa_name_load();
			File file;
			try {
				file = new File(getSavePath() + "\\" + url);
				if (file.exists()) {
					file.delete();
				}
			} catch (Exception e) {
			}
		}
		newsService.delAppendixs(appendixs);
		session.setAttribute("success_info", "删除通知成功");
		return SUCCESS;
	}

	public String delAppendix() {
		//int id = Integer.parseInt(request.getParameter("aid"));
		long id = Long.parseLong(request.getParameter("aid"));
		System.out.println(id);
		News_appendix appendix = newsService.getAppendix(id);
		String url = appendix.getNa_name_load();
		File file;
		try {
			file = new File(getSavePath() + "\\" + url);
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
		}
		newsService.delAppendix(appendix);
		session.setAttribute("success_info", "删除附件成功");
		return SUCCESS;
	}

	/**
	 * 默认函数
	 */
	public String execute() {
		return SUCCESS;
	}

	public String getSavePath() throws Exception {
		//return ServletActionContext.getServletContext().getRealPath(savePath);
		return System.getenv("CATALINA_HOME")+"\\webapps\\studentOnline_source\\appendix";
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public File[] getUpload() {
		return upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String[] getAtitle() {
		return atitle;
	}

	public void setAtitle(String[] atitle) {
		this.atitle = atitle;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNid() {
		return nid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAid() {
		return aid;
	}

}
