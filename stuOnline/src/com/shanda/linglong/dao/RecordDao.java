package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Record;

public interface RecordDao {
	public boolean addRecord(Record record);
	public boolean delRecord(long r_id);
	public Record getRecord(long r_id);
	public List<Record> getAllList(final int offset,final int length);
	public List<Record> getList(String person_id,final int offset,final int length);
	public boolean update(Record record);
	public int getTotalCount(String hql);
}
