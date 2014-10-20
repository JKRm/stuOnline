package com.shanda.linglong.vo;

import java.io.File;

import com.shanda.linglong.model.Record;

public class DetailVo {
	
	private Record record; 
	
	private String nickname;
	
	private  String email;
	
	private File upload;
	
	private String photo_url;
	
	private String uploadFileName;

	private String uploadContentType;


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Record getRecord() {
		return record;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public String getPhoto_url() {
		return photo_url;
	}
	
	

}
