package com.shanda.linglong.vo;

import com.shanda.linglong.model.Record_discuss;

public class DiscussVo {
	
	private String nickname;
	
	private Record_discuss record_discuss;

	public void setRecord_discuss(Record_discuss record_discuss) {
		this.record_discuss = record_discuss;
	}

	public Record_discuss getRecord_discuss() {
		return record_discuss;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}	

}
