package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Exam_temDao;
import com.shanda.linglong.model.Exam_tem;

@Component("exam_temDao")
public class Exam_temDaoImpl implements Exam_temDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Exam_tem exam_tem) {
		try {
			hibernateTemplate.save(exam_tem);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Exam_tem> getExam_temList(long tp_id) {
		return hibernateTemplate.find(
				"from Exam_tem exam_tem where exam_tem.tp_id = ?", tp_id);
	}

	@Override
	public Exam_tem getExam_tem(long tp_id, long e_title) {
		return (Exam_tem) hibernateTemplate
				.find("from Exam_tem exam_tem where exam_tem.tp_id = ? and exam_tem.e_title = ?",
						tp_id, e_title).get(0);
	}

	@Override
	public Exam_tem getExam_temBy(long tp_id, long e_id) {
		return (Exam_tem) hibernateTemplate
		.find("from Exam_tem exam_tem where exam_tem.tp_id = ? and exam_tem.e_id = ?",
				tp_id, e_id).get(0);
	}

}
