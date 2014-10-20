package com.shanda.linglong.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.MessageDao;
import com.shanda.linglong.dao.RecordDao;
import com.shanda.linglong.dao.Record_discussDao;
import com.shanda.linglong.model.Message_temp;
import com.shanda.linglong.model.Record;
import com.shanda.linglong.model.Record_discuss;
import com.shanda.linglong.service.RecordService;
import com.shanda.linglong.vo.QueryResult;

@Component("recordService")
public class RecordServiceImpl implements RecordService {
	
	private RecordDao recordDao;
	
	private Record_discussDao rdDao;
	
	private MessageDao messageDao;
	
	@Resource(name="recordDao")
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public RecordDao getRecordDao() {
		return recordDao;
	}

	@Resource(name="record_discuessDao")
	public void setRdDao(Record_discussDao rdDao) {
		this.rdDao = rdDao;
	}

	public Record_discussDao getRdDao() {
		return rdDao;
	}
	
	public MessageDao getMessageDao() {
		return messageDao;
	}

	@Resource(name="messageDao")
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	

	@Override
	public boolean RecordAdd(Record record) {
		// TODO Auto-generated method stub
		return recordDao.addRecord(record);
	}

	@Override
	public boolean RecordDel(long r_id) {
		// TODO Auto-generated method stub
		return recordDao.delRecord(r_id);
	}

	@Override
	public QueryResult<Record> getRecordList(final int offset,final int length) {
		// TODO Auto-generated method stub
		QueryResult<Record> qr = new QueryResult<Record>();
		List<Record> rList = new ArrayList<Record>();
		rList = recordDao.getAllList(offset,length);
		long total = recordDao.getTotalCount("select count(*) from Record as record");
		qr.setResultlist(rList);
		qr.setTotalrecord(total);
		return qr;
	}

	@Override
	public QueryResult<Record> getRecordListByPerson(String person_id,final int offset,final int length) {
		// TODO Auto-generated method stub
		//return recordDao.getList(person_id, offset, length);
		QueryResult<Record> qr = new QueryResult<Record>();
		List<Record> rList = new ArrayList<Record>();
		rList = recordDao.getList(person_id, offset, length);
		long total = recordDao.getTotalCount("select count(*) from Record record where record.person_id ='" + person_id+"'");
		qr.setResultlist(rList);
		qr.setTotalrecord(total);
		return qr;
	}

	@Override
	public boolean RecordDiscussAdd(Record_discuss rd) {
		// TODO Auto-generated method stub
		return rdDao.add(rd);
	}

	@Override
	public boolean RecordDiscussDel(long rd_id) {
		// TODO Auto-generated method stub
		return rdDao.del(rd_id);
	}

	@Override
	public QueryResult<Record_discuss> getDiscussListByrid(final int offset,final int length,long r_id,String iscom) {
		// TODO Auto-generated method stub
		QueryResult<Record_discuss> qr = new QueryResult<Record_discuss>();
		List<Record_discuss> rdList = new ArrayList<Record_discuss>();
		rdList = rdDao.getList(r_id, iscom, offset, length);
		long total = recordDao.getTotalCount("select count(*) from Record_discuss rd where rd.r_id = "+ r_id +
				" and rd_iscom ='"+iscom+"'");
		qr.setResultlist(rdList);
		qr.setTotalrecord(total);
		return qr;
	}

	@Override
	public Record getRecord(long r_id) {
		// TODO Auto-generated method stub
		return recordDao.getRecord(r_id);
	}

	@Override
	public boolean updateRecord(Record record) {
		// TODO Auto-generated method stub
		return recordDao.update(record);
	}

	@Override
	public boolean delDiscussByrid(long r_id) {
		// TODO Auto-generated method stub
		return rdDao.delByrid(r_id);
	}

	@Override
	public boolean addMessage(Message_temp mt) {
		// TODO Auto-generated method stub
		return messageDao.add(mt);
	}

	@Override
	public boolean delMessage(long mt_id) {
		// TODO Auto-generated method stub
		return messageDao.del(mt_id);
	}

	@Override
	public boolean delMessageByRecieveId(String person_id_recieve) {
		// TODO Auto-generated method stub
		return messageDao.delByRecieveId(person_id_recieve);
	}

	@Override
	public QueryResult<Message_temp> getMessageList(String person_id_recieve,final int offset,final int length) {
		// TODO Auto-generated method stub
		//return messageDao.getList(person_id_recieve, offset, length);
		QueryResult<Message_temp> qr = new QueryResult<Message_temp>();
		List<Message_temp> mtList = new ArrayList<Message_temp>();
		mtList = messageDao.getList(person_id_recieve, offset, length);
		long total = recordDao.getTotalCount("select count(*) from Message_temp mt where mt.person_id_recieve = '"+person_id_recieve+"'");
		qr.setResultlist(mtList);
		qr.setTotalrecord(total);
		return qr;
	}

	@Override
	public long getrid(long rd_id) {
		// TODO Auto-generated method stub
		return rdDao.getRid(rd_id);
	}

	@Override
	public int messageListCount(String person_id_recieve) {
		// TODO Auto-generated method stub
		return recordDao.getTotalCount("select count(*) from Message_temp mt where mt.person_id_recieve = '"+person_id_recieve+"'");
	}

	@Override
	public boolean delMessageByRid(long r_id) {
		// TODO Auto-generated method stub
		return messageDao.delByRid(r_id);
	}

	
}
