package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Person_progress;

public interface ProgressDao {
	
	public boolean save(Person_progress pp);
	
	public boolean del(Person_progress pp);
	
	public boolean update(Person_progress pp);
	public List<Person_progress> find(long train_id);
	public boolean delBy_Pid_Cid(String personid,long cid);

}
