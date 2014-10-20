package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Email_remindDao;
import com.shanda.linglong.dao.Email_remind_appendixDao;
import com.shanda.linglong.dao.Email_sendDao;
import com.shanda.linglong.model.Email_remind;
import com.shanda.linglong.model.Email_remind_appendix;
import com.shanda.linglong.model.Email_send;
import com.shanda.linglong.service.EmailService;

@Component("emailService")
public class EmailServiceImpl implements EmailService{
	
	private Email_remind_appendixDao eraDao;
	private Email_remindDao erDao;
	private Email_sendDao esDao;

	@Resource(name="email_remind_appendixDao")
	public void setEraDao(Email_remind_appendixDao eraDao) {
		this.eraDao = eraDao;
	}

	public Email_remind_appendixDao getEraDao() {
		return eraDao;
	}
	
	public Email_remindDao getErDao() {
		return erDao;
	}
	@Resource(name="email_remindDao")
	public void setErDao(Email_remindDao erDao) {
		this.erDao = erDao;
	}
	
	@Resource(name="email_sendDao")
	public void setEsDao(Email_sendDao esDao) {
		this.esDao = esDao;
	}

	public Email_sendDao getEsDao() {
		return esDao;
	}
	

	@Override
	public boolean addAppendixs(Email_remind_appendix era) {
		// TODO Auto-generated method stub
		return eraDao.add(era);
	}

	@Override
	public boolean delAppendixByEmailId(long email_id) {
		// TODO Auto-generated method stub
		return eraDao.deleteByEmailId(email_id);
	}

	@Override
	public long addEmail(Email_remind er) {
		// TODO Auto-generated method stub
		return erDao.add(er);
	}

	@Override
	public boolean delEmail(long email_id) {
		// TODO Auto-generated method stub
		return erDao.delByEmailId(email_id);
	}

	@Override
	public boolean addSend(Email_send es) {
		// TODO Auto-generated method stub
		return esDao.add(es);
	}

	@Override
	public boolean delSendByEmailId(long email_id) {
		// TODO Auto-generated method stub
		return esDao.delByEmailId(email_id);
	}

	@Override
	public List<Email_remind> getList() {
		// TODO Auto-generated method stub
		return erDao.getList();
	}

	@Override
	public List<Email_remind_appendix> getLsitByEmailId(long email_id) {
		// TODO Auto-generated method stub
		return eraDao.getListByEmailId(email_id);
	}

	@Override
	public List<Email_send> getListByEID(long email_id) {
		// TODO Auto-generated method stub
		return esDao.getListByEmailId(email_id);
	}

	


	
}
