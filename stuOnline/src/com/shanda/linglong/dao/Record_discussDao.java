package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Record_discuss;

public interface Record_discussDao {
	
	public boolean add(Record_discuss rd);
	public boolean del(long rd_id);
	public List<Record_discuss> getList(final long r_id,final String iscom,final int offset,final int length);
	public boolean delByrid(long r_id);
	public long getRid(long rd_id);

}
