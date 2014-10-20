package com.shanda.linglong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Exam_paperDao;
import com.shanda.linglong.model.Exam_paper;
import com.shanda.linglong.service.Exam_paperService;

@Component("exam_paperservice")
public class Exam_paperServiceImpl implements Exam_paperService{

	
	private Exam_paperDao epd;
	public Exam_paperDao getEpd() {
		return epd;
	}
	@Resource(name="exam_paperDao")
	public void setEpd(Exam_paperDao epd) {
		this.epd = epd;
	}
	@Override
	public void save_Person_Testproduce(Exam_paper ep) {
		// TODO Auto-generated method stub
		epd.save_ep(ep);
		
	}

}
