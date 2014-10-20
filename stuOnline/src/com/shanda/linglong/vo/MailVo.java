package com.shanda.linglong.vo;

import java.util.List;

public class MailVo {
	
	private String[] to;
	
	private String subject;
	
	private String content;
	
	private boolean mimeContent;
	
	private String[] affix;
	
	private String[] affixName;
	
	private boolean affixFlag;
	
	public MailVo(){
		
		this.mimeContent = false;
		this.affixFlag = false;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isMimeContent() {
		return mimeContent;
	}

	public void setMimeContent(boolean mimeContent) {
		this.mimeContent = mimeContent;
	}

	public String[] getAffix() {
		return affix;
	}

	public void setAffix(String[] affix) {
		this.affix = affix;
	}

	public String[] getAffixName() {
		return affixName;
	}

	public void setAffixName(String[] affixName) {
		this.affixName = affixName;
	}

	public void setAffixFlag(boolean affixFlag) {
		this.affixFlag = affixFlag;
	}

	public boolean isAffixFlag() {
		return affixFlag;
	}
	
	
	
	

}
