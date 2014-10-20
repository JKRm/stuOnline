package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Person_detail;
import com.shanda.linglong.vo.QueryResult;

public interface Person_detailService {
	
	public boolean addDetail(Person_detail pd);
	public boolean delDetail(String person_id);
	public boolean motifyPss(String person_id,long pd_password);
	public String getNickname(String person_id);
	public String getPhotourl(String person_id);
	public Person_detail getInfo(String person_id);
	public QueryResult<Person_detail> getinfoBynn(String nickname,final int offset,final int length);
	public boolean updateDetail(Person_detail pd);
	
	/*
	 * 合并增加
	 */
	public Person_detail isNull_person(String person_id,String password); 
}
