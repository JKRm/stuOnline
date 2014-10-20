package com.shanda.linglong.vo;

import java.io.File;

public class PublishVo {

	private File upload;

	private String content;

	private String uploadFileName;

	private String uploadContentType;

	private String type;

	private String from;

	private String to;

	private String source;
	
	private String title;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	// 获取上传文件类型

	public void setType(String type) {
		type = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1,
				uploadFileName.length()).toLowerCase();
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

}
