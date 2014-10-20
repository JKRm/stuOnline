package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Message_temp;
import com.shanda.linglong.model.Record;
import com.shanda.linglong.model.Record_discuss;
import com.shanda.linglong.vo.QueryResult;

public interface RecordService {	
	public boolean RecordAdd(Record record);
	public boolean RecordDel(long r_id);
	public Record getRecord(long r_id);
	public QueryResult<Record> getRecordList(final int offset,final int length);
	public QueryResult<Record> getRecordListByPerson(String person_id,final int offset,final int length);
	public boolean RecordDiscussAdd(Record_discuss rd);
	public boolean RecordDiscussDel(long rd_id);
	public QueryResult<Record_discuss> getDiscussListByrid(final int offset,final int length,long r_id,String iscom);
	public boolean updateRecord(Record record);
	public boolean delDiscussByrid(long r_id);
	public boolean addMessage(Message_temp mt);
	public boolean delMessage(long mt_id);
	public boolean delMessageByRecieveId(String person_id_recieve);
	public QueryResult<Message_temp> getMessageList(String person_id_recieve,final int offset,final int length);
	public long getrid(long rd_id);
	public int messageListCount(String person_id_recieve);
	public boolean delMessageByRid(long r_id);
}
