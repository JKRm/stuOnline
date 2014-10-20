package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AnswerDao;
import com.shanda.linglong.model.Answer;

@Component("answerDao")
public class AnswerDaoImpl implements AnswerDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveAnswer(String person_id, long tp_id, long title_id,
			String a_answer) {
		try {
			List<Answer> list = hibernateTemplate
					.find("from Answer answer where answer.person_id = ? and answer.tp_id = ? and answer.title_id = ?",
							person_id, tp_id, title_id);
			if (list.size() == 1) {
				list.get(0).setA_answer(a_answer);
				hibernateTemplate.update(list.get(0));
			} else {
				Answer answer = new Answer();
				answer.setPerson_id(person_id);
				answer.setTp_id(tp_id);
				answer.setTitle_id(title_id);
				answer.setA_answer(a_answer);
				hibernateTemplate.save(answer);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Long> getScores(long title_id) {
		List<Answer> listAnswer = hibernateTemplate.find("from Answer answer where answer.title_id = ?",title_id);
		List<Long> list = new ArrayList<Long>();
		for(Answer answer : listAnswer)
			list.add(answer.getA_score());
		return list;
	}

	@Override
	public void save_pt(Answer a) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(a);
	}

	@Override
	public List<Answer> getAnswerList(String person_id, long tp_id) {
		return hibernateTemplate.find("from Answer answer where answer.person_id = ? and answer.tp_id = ?",person_id,tp_id);
	}

	@Override
	public List<Answer> getAnswerListBy(long title_id, long tp_id) {
		return hibernateTemplate.find("from Answer answer where answer.title_id = ? and answer.tp_id = ?",title_id,tp_id);
	}

	@Override
	public Long getMax(final long tp_id) {
		return this.hibernateTemplate.execute(
				new HibernateCallback<Long>(){

					@Override
					public Long doInHibernate(Session session)
							throws HibernateException, SQLException {
						Long q = (Long)session.createQuery("select max(answer.title_id) from Answer answer where answer.tp_id = ? order by answer.title_id;").uniqueResult();
						
						return q;
					}
					
				}
		);
	}

	@Override
	public void update(Answer answer) {
		hibernateTemplate.update(answer);
		
	}

}
