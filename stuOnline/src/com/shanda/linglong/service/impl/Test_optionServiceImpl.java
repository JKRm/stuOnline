package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Test_optionDao;
import com.shanda.linglong.model.Test_option;
import com.shanda.linglong.service.Test_optionService;

@Component("test_optionService")
public class Test_optionServiceImpl implements Test_optionService {

	private Test_optionDao test_optionDao;
	
	public Test_optionDao getTest_optionDao() {
		return test_optionDao;
	}

	@Resource(name="test_optionDao")
	public void setTest_optionDao(Test_optionDao test_optionDao) {
		this.test_optionDao = test_optionDao;
	}

	@Override
	public boolean add(Test_option test_option) {
		return test_optionDao.add(test_option);
	}

	@Override
	public boolean delete(long toption_id) {
		return test_optionDao.delete(toption_id);
	}

	@Override
	public boolean update(Test_option test_option) {
		return test_optionDao.update(test_option);
	}

	@Override
	public Test_option getTest_option(long toption_id) {
		return test_optionDao.getTest_option(toption_id);
	}

	@Override
	public List<Test_option> getTest_options(long tq_id) {
		return test_optionDao.getTest_options(tq_id);
	}

}
