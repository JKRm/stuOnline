package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Test_produceDao;
import com.shanda.linglong.model.Test_produce;
import com.shanda.linglong.service.Test_produceService;


@Component("Test_produceService")
public class Test_produceServiceImpl implements Test_produceService{

	
	private Test_produceDao tpd;
	
	
	public Test_produceDao getTpd() {
		return tpd;
	}

    @Resource(name="test_produceDao")
	public void setTpd(Test_produceDao tpd) {
		this.tpd = tpd;
	}


	@Override
	public List<Test_produce> findAll() {
		// TODO Auto-generated method stub
		return tpd.getAll();
	}

}
