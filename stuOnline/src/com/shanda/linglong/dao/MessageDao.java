package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Message_temp;

public interface MessageDao {
	
	public boolean add(Message_temp mt);
	public boolean del(long mt_id);
	public List<Message_temp> getList(String person_id_recieve,final int offset,final int length);
	public boolean delByRecieveId(String person_id_recieve);
	public boolean delByRid(long r_id);
}
