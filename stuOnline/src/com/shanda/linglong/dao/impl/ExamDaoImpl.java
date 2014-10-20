package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.ExamDao;
import com.shanda.linglong.model.Exam;

@Component("examDao")
public class ExamDaoImpl implements ExamDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Exam exam) {
		try {
			hibernateTemplate.save(exam);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(final long e_id) {
		try {
			this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

				@Override
				public Integer doInHibernate(Session session)
						throws HibernateException, SQLException {
					session.delete("from Exam exam where exam.e_id = ?", e_id);
					return 0;
				}

			});
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Exam exam) {
		try {
			hibernateTemplate.update(exam);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Exam> getExamList() {
		return hibernateTemplate.find("from Exam exam");
	}

	@Override
	public Exam getExamByE_id(long e_id) {
		return (Exam) hibernateTemplate.find(
				"from Exam exam where exam.e_id = ?", e_id).get(0);
	}

	private List<Exam> getExamsByAuto(long e_kno_id, String e_type, long e_score,
			float e_diff) {
		return hibernateTemplate
				.find("from Exam exam where exam.e_kno_id = ? and exam.e_type = ? and exam.e_score = ? and 0 <= exam.e_diff and exam.e_diff <= ?",
						e_kno_id, e_type, e_score, e_diff);
	}
	
	@Override
	public Exam getExamByAuto(long e_kno_id,String e_type,long e_score,float e_diff){
		Random random = new Random();
		List<Exam> list = getExamsByAuto(e_kno_id,e_type,e_score,e_diff);
		int n = random.nextInt(list.size());
		return list.get(n);
	}

	@Override
	public String getAnswer(long e_id) {
		return (String)hibernateTemplate.get(Exam.class, e_id).getE_answer();
	}

	@Override
	public List<Exam> getExamByC_id(long e_kno_id) {
		return hibernateTemplate.find("from Exam exam where exam.e_kno_id = ?",e_kno_id);
	}

}
