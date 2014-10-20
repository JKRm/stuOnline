package com.shanda.linglong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AnswerDao;
import com.shanda.linglong.model.Answer;
import com.shanda.linglong.service.AnswerService;

@Component("answerService")
public class AnswerServiceImpl implements AnswerService{

	
	private AnswerDao ad;
	
	public AnswerDao getAd() {
		return ad;
	}
    @Resource(name="answerDao")
	public void setAd(AnswerDao ad) {
		this.ad = ad;
	}

	@Override
	public void save_Person_Testproduce(Answer a) {
		// TODO Auto-generated method stub
		ad.save_pt(a);
		
	}

}
