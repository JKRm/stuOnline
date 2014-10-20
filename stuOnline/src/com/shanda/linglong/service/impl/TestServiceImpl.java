package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.TestDao;
import com.shanda.linglong.dao.Test_answerDao;
import com.shanda.linglong.dao.Test_questionDao;
import com.shanda.linglong.dao.Test_temDao;
import com.shanda.linglong.model.Test;
import com.shanda.linglong.model.Test_answer;
import com.shanda.linglong.model.Test_question;
import com.shanda.linglong.model.Test_tem;
import com.shanda.linglong.service.TestService;

@Component("testService")
public class TestServiceImpl implements TestService {

	private TestDao testDao;
	
	private Test_questionDao test_questionDao;
	
	private Test_answerDao test_answerDao;
	
	private Test_temDao test_temDao;
	
	public TestDao getTestDao() {
		return testDao;
	}

	@Resource(name="testDao")
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	public Test_questionDao getTest_questionDao() {
		return test_questionDao;
	}

	@Resource(name="test_questionDao")
	public void setTest_questionDao(Test_questionDao test_questionDao) {
		this.test_questionDao = test_questionDao;
	}

	public Test_answerDao getTest_answerDao() {
		return test_answerDao;
	}

	@Resource(name="test_answerDao")
	public void setTest_answerDao(Test_answerDao test_answerDao) {
		this.test_answerDao = test_answerDao;
	}

	public Test_temDao getTest_temDao() {
		return test_temDao;
	}

	@Resource(name="test_temDao")
	public void setTest_temDao(Test_temDao test_temDao) {
		this.test_temDao = test_temDao;
	}

	@Override
	public boolean add(Test test) {
		return testDao.add(test);
	}

	@Override
	public boolean delete(long t_id) {
		return testDao.delete(t_id);
	}

	@Override
	public boolean update(Test test) {
		return testDao.update(test);
	}

	@Override
	public List<Test> getTestList() {
		return testDao.getTestList();
	}

	@Override
	public Test getTestByT_id(long t_id) {
		return testDao.getTestByT_id(t_id);
	}

	@Override
	public boolean addTest_question(Test_question test_question) {
		return test_questionDao.add(test_question);
	}

	@Override
	public boolean deleteTest_question(long tq_id) {
		return test_questionDao.delete(tq_id);
	}

	@Override
	public boolean updateTest_question(Test_question test_question) {
		return test_questionDao.update(test_question);
	}

	@Override
	public Test_question getTest_question(int offset,long t_id) {
		return test_questionDao.getTest_question(offset, t_id);
	}

	@Override
	public List<Test_question> getTest_questions(long t_id) {
		return test_questionDao.getTest_questions(t_id);
	}

	@Override
	public boolean addTest_answer(Test_answer test_answer) {
		return test_answerDao.add(test_answer);
	}

	@Override
	public boolean deleteTest_answer(long ta_id) {
		return test_answerDao.delete(ta_id);
	}

	@Override
	public boolean updateTest_answer(Test_answer test_answer) {
		return test_answerDao.update(test_answer);
	}

	@Override
	public Test_answer getTest_answer(String person_id, long t_id) {
		return test_answerDao.getTest_answer(person_id, t_id);
	}

	@Override
	public List<Test_answer> getTest_answerByPerson_id(String person_id) {
		return test_answerDao.getTest_answerByPerson_id(person_id);
	}

	@Override
	public List<Test_answer> getTest_answerByT_id(long t_id) {
		return test_answerDao.getTest_answerByT_id(t_id);
	}

	@Override
	public boolean addTest_tem(Test_tem test_tem) {
		return test_temDao.add(test_tem);
	}

	@Override
	public boolean updateTest_tem(Test_tem test_tem) {
		return test_temDao.update(test_tem);
	}

	@Override
	public Test_tem getTest_tem(long tt_id) {
		return test_temDao.getTest_tem(tt_id);
	}

	@Override
	public float getTotalScore(String person_id, long t_id) {
		return test_temDao.getTotalScore(person_id, t_id);
	}

	@Override
	public List<Test_tem> getTest_temList(String person_id, long t_id) {
		return test_temDao.getTest_temList(person_id, t_id);
	}

}
