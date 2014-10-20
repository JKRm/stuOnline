package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Person_detail;

public interface Person_detailDao {
	
	public boolean add(Person_detail pd);
	public boolean del(String person_id);
	public boolean modifyPss(String person_id,long pd_password);
	public Person_detail getInfo(String person_id);
	public  List<Person_detail> getinfoBynn(String nickname,final int offset,final int length);
	public boolean update(Person_detail pd);
	
	/*
	 * 合并增加
	 */
	public Person_detail getInfo(String person_id,String password);
}
