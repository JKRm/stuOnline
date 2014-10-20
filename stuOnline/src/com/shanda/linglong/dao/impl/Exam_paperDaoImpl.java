package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Exam_paperDao;
import com.shanda.linglong.model.Exam_paper;

@Component("exam_paperDao")
public class Exam_paperDaoImpl implements Exam_paperDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean add(String person_id, long tp_id) {
		try{
			Exam_paper exam_paper = new Exam_paper();
			exam_paper.setPerson_id(person_id);
			exam_paper.setTp_id(tp_id);
			hibernateTemplate.save(exam_paper);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(long ep_id) {
		try{
			Exam_paper exam_paper = hibernateTemplate.get(Exam_paper.class, ep_id);
			hibernateTemplate.delete(exam_paper);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Exam_paper exam_paper) {
		try{
			hibernateTemplate.update(exam_paper);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Exam_paper> getExam_paperByPerson_id(String person_id) {
		return hibernateTemplate.find("from Exam_paper exam_paper where exam_paper.person_id = ?",person_id);
	}

	@Override
	public List<Exam_paper> getExam_paperByTp_id(long tp_id) {
		return hibernateTemplate.find("from Exam_paper exam_paper where exam_paper.tp_id = ?",tp_id);
	}

	@Override
	public Exam_paper getExam_paper(String person_id, long tp_id) {
		return (Exam_paper)hibernateTemplate.find("from Exam_paper exam_paper where exam_paper.tp_id = ? and exam_paper.person_id = ?",tp_id,person_id).get(0);
	}

	@Override
	public void save_ep(Exam_paper exam_paper) {
		hibernateTemplate.save(exam_paper);
	}

}
