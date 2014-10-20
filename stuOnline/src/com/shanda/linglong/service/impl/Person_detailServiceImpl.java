package com.shanda.linglong.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Person_detailDao;
import com.shanda.linglong.dao.RecordDao;
import com.shanda.linglong.model.Person_detail;
import com.shanda.linglong.service.Person_detailService;
import com.shanda.linglong.vo.QueryResult;

@Component("person_detailService")
public class Person_detailServiceImpl implements Person_detailService {
	
	private Person_detailDao pdDao;
	
	private RecordDao recordDao;
	
	public RecordDao getRecordDao() {
		return recordDao;
	}
	@Resource(name="recordDao")
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Resource(name="person_detailDao")
	public void setPdDao(Person_detailDao pdDao) {
		this.pdDao = pdDao;
	}

	public Person_detailDao getPdDao() {
		return pdDao;
	}

	@Override
	public boolean addDetail(Person_detail pd) {
		// TODO Auto-generated method stub
		return pdDao.add(pd);
	}

	@Override
	public boolean delDetail(String person_id) {
		// TODO Auto-generated method stub
		return pdDao.del(person_id);
	}

	@Override
	public boolean motifyPss(String person_id, long pd_password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNickname(String person_id) {
		
		String nickname = null;
		
		if(pdDao.getInfo(person_id)!=null){
			
			String get = pdDao.getInfo(person_id).getPd_nickname();
			
			if (get == null || get.equals("") ) {

				nickname = "暂无昵称";
			}

			else {

				nickname = get;
			}
			
		}
		
		else{
			nickname = "查无此人";
		}
		
		return nickname;
		
	}

	@Override
	public Person_detail getInfo(String person_id) {
		// TODO Auto-generated method stub
		return pdDao.getInfo(person_id);
	}

	@Override
	public QueryResult<Person_detail> getinfoBynn(String nickname,final int offset,final int length) {
		// TODO Auto-generated method stub
		//return pdDao.getinfoBynn(nickname, offset, length);
		QueryResult<Person_detail> qr = new QueryResult<Person_detail>();
		List<Person_detail> pdList = new ArrayList<Person_detail>();
		pdList = pdDao.getinfoBynn(nickname, offset, length);
		long total = recordDao.getTotalCount("select count(*) from Person_detail person_detail where person_detail.pd_nickname like '"+"%%"+nickname+"%%"+"'");
		qr.setResultlist(pdList);
		qr.setTotalrecord(total);
		return qr;
	
	}

	@Override
	public boolean updateDetail(Person_detail pd) {
		// TODO Auto-generated method stub
		return pdDao.update(pd);
	}

	@Override
	public String getPhotourl(String person_id) {
		Person_detail pd = new Person_detail();
		pd = pdDao.getInfo(person_id);
		return pd.getPd_photo();
	}
	/*
	 * (non-Javadoc)
	 * @see com.shanda.linglong.service.Person_detailService#isNull_person(java.lang.String, java.lang.String)
	 * 
	 * 
	 * 若查到记录返回FALSE，没有返回TRUE
	 */
	@Override
	public Person_detail isNull_person(String person_id,String password) {
		// TODO Auto-generated method stub
//		if(pdDao.getInfo(person_id, password)==null)
//			return true;
//		else
		return pdDao.getInfo(person_id, password);
	}

	
}
