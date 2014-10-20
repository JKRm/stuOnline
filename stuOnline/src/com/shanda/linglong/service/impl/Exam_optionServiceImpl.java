package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AnswerDao;
import com.shanda.linglong.dao.Exam_optionDao;
import com.shanda.linglong.model.Exam_option;
import com.shanda.linglong.service.Exam_optionService;

@Component("exam_optionService")
public class Exam_optionServiceImpl implements Exam_optionService{

	private Exam_optionDao exam_optionDao;
	
	private AnswerDao answerDao;
	
	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	@Resource(name="answerDao")
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	public Exam_optionDao getExam_optionDao() {
		return exam_optionDao;
	}

	@Resource(name="exam_optionDao")
	public void setExam_optionDao(Exam_optionDao exam_optionDao) {
		this.exam_optionDao = exam_optionDao;
	}

	@Override
	public boolean add(Exam_option exam_option) {
		return exam_optionDao.add(exam_option);
	}

	@Override
	public boolean delete(long eo_id) {
		return exam_optionDao.delete(eo_id);
	}

	@Override
	public boolean update(Exam_option exam_option) {
		return exam_optionDao.update(exam_option);
	}

	@Override
	public List<Exam_option> getExamByE_id(long e_id) {
		return exam_optionDao.getExamByE_id(e_id);
	}

}
