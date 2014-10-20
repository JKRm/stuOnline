package com.shanda.linglong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Test_answerDao;
import com.shanda.linglong.model.Test_answer;
import com.shanda.linglong.service.Test_answerService;

@Component("test_answerService")
public class Test_answerServiceImpl implements Test_answerService{

	private Test_answerDao tad;
	
	public Test_answerDao getTad() {
		return tad;
	}
    @Resource(name="test_answerDao")
	public void setTad(Test_answerDao tad) {
		this.tad = tad;
	}

	@Override
	public void save_person_test(Test_answer ta) {
		// TODO Auto-generated method stub
		tad.savept(ta);
	}

}
