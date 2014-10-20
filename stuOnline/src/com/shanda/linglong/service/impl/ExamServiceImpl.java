package com.shanda.linglong.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.AnswerDao;
import com.shanda.linglong.dao.ExamDao;
import com.shanda.linglong.dao.Exam_paperDao;
import com.shanda.linglong.dao.Exam_temDao;
import com.shanda.linglong.dao.Person_wholeDao;
import com.shanda.linglong.dao.Test_produceDao;
import com.shanda.linglong.model.Answer;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Exam_paper;
import com.shanda.linglong.model.Exam_tem;
import com.shanda.linglong.model.Person_whole;
import com.shanda.linglong.model.Test_produce;
import com.shanda.linglong.service.ExamService;

@Component("examService")
public class ExamServiceImpl implements ExamService{

	private ExamDao examDao;
	
	private Exam_temDao exam_temDao;
	
	private Test_produceDao test_produceDao;
	
	private AnswerDao answerDao;
	
	private Exam_paperDao exam_paperDao;
	
	private Person_wholeDao person_wholeDao;
	
	public Person_wholeDao getPerson_wholeDao() {
		return person_wholeDao;
	}

	@Resource(name="person_wholeDao")
	public void setPerson_wholeDao(Person_wholeDao person_wholeDao) {
		this.person_wholeDao = person_wholeDao;
	}

	public Exam_paperDao getExam_paperDao() {
		return exam_paperDao;
	}

	@Resource(name="exam_paperDao")
	public void setExam_paperDao(Exam_paperDao exam_paperDao) {
		this.exam_paperDao = exam_paperDao;
	}

	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	@Resource(name="answerDao")
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	public ExamDao getExamDao() {
		return examDao;
	}

	@Resource(name="examDao")
	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

	public Exam_temDao getExam_temDao() {
		return exam_temDao;
	}

	@Resource(name="exam_temDao")
	public void setExam_temDao(Exam_temDao exam_temDao) {
		this.exam_temDao = exam_temDao;
	}

	public Test_produceDao getTest_produceDao() {
		return test_produceDao;
	}

	@Resource(name="test_produceDao")
	public void setTest_produceDao(Test_produceDao test_produceDao) {
		this.test_produceDao = test_produceDao;
	}

	@Override
	public boolean add(Exam exam) {
		return examDao.add(exam);
	}

	@Override
	public boolean delete(long e_id) {
		return examDao.delete(e_id);
	}

	@Override
	public boolean update(Exam exam) {
		return examDao.update(exam);
	}

	@Override
	public List<Exam> getExamList() {
		return examDao.getExamList();
	}

	@Override
	public Exam getExamByE_id(long e_id) {
		return examDao.getExamByE_id(e_id);
	}

	@Override
	public List<Exam> getExamsByAuto(long[] e_kno_id, String e_type,
			long e_score, float[] e_diff,int length) {
		List<Long> list = new ArrayList<Long>();
		List<Exam> listExams = new ArrayList<Exam>();
		Exam exam = new Exam();
		for(int i = 0; i < length; ++i){
			exam = existExam(e_kno_id[i], e_type, e_score, e_diff[i], list);
			if(exam.getE_id() != -1){
				list.add(exam.getE_id());
				listExams.add(exam);
			}else {
				--i;
			}
		}
		return listExams;
	}

	private Exam existExam(long e_kno_id,String e_type,long e_score,float e_diff,List<Long> list){
		Exam exam = examDao.getExamByAuto(e_kno_id, e_type, e_score, e_diff);
		if(list.contains(exam.getE_id())){
			exam.setE_id(-1);
		}
		return exam;
	}

	@Override
	public boolean saveTest_produce(long c_id, String tp_title) {
		Test_produce test_produce = new Test_produce();
		test_produce.setC_id(c_id);
		test_produce.setTp_title(tp_title);
		return test_produceDao.add(test_produce);
	}

	@Override
	public boolean saveExam_tem(Exam_tem exam_tem) {
		return exam_temDao.add(exam_tem);
	}

	@Override
	public boolean saveObjectiveAnswer(String person_id, long e_title, long title_id,
			String a_answer) {
		boolean key = false;
		if(answerDao.saveAnswer(person_id, e_title, title_id, a_answer)){
			String r_answer = examDao.getAnswer(title_id);
			if(r_answer.length() == a_answer.length()){
				key = true;
				for(int j = 0; j < r_answer.length();++j){
					for(int m = j+1; m < r_answer.length(); ++m){
						if(r_answer.charAt(j) == r_answer.charAt(m)){
							key = false;
							break;
						}
					}
				}
				for(int i = 0; i < r_answer.length(); ++i){
					if(!a_answer.contains(String.valueOf(r_answer.charAt(i)))){
						key = false;
						break;
					}
				}
			}
		}
		return key;
	}

	@Override
	public boolean saveSubjectiveAnswer(String person_id, long e_title,
			long title_id, String a_answer) {
		return answerDao.saveAnswer(person_id, e_title, title_id, a_answer);
	}
	
	@Override
	public boolean updateDiff(long e_id) {
		List<Long> list = answerDao.getScores(e_id);
		Exam exam = examDao.getExamByE_id(e_id);
		float avg = 0; 
		for(Long tem : list)
			avg += tem;
		exam.setE_diff(avg/(float)list.size());
		return examDao.update(exam);
	}

	@Override
	public boolean saveExam_paper(String person_id, long tp_id) {
		return exam_paperDao.add(person_id,tp_id);
	}

	@Override
	public boolean deleteExam_paper(long ep_id) {
		return exam_paperDao.delete(ep_id);
	}

	@Override
	public boolean updateExam_paper(Exam_paper exam_paper) {
		return exam_paperDao.update(exam_paper);
	}

	@Override
	public List<Exam_paper> getExam_paperByPerson_id(String person_id) {
		return exam_paperDao.getExam_paperByPerson_id(person_id);
	}

	@Override
	public List<Exam_paper> getExam_paperByTp_id(long tp_id) {
		return exam_paperDao.getExam_paperByTp_id(tp_id);
	}

	@Override
	public float getExam_paperAvg(long tp_id) {
		List<Exam_paper> list = exam_paperDao.getExam_paperByTp_id(tp_id);
		float sum = 0;
		for(Exam_paper exam_paper : list) 
			sum += exam_paper.getEp_score();
		return sum/(float)list.size();
	}

	@Override
	public boolean addPerson_whole(Person_whole person_whole) {
		return person_wholeDao.add(person_whole);
	}

	@Override
	public boolean deletePerson_whole(long pw_id) {
		return person_wholeDao.delete(pw_id);
	}

	@Override
	public boolean updatePerson_whole(Person_whole person_whole) {
		return person_wholeDao.update(person_whole);
	}

	@Override
	public Person_whole getPerson_whole(long person_id, long train_id) {
		return person_wholeDao.getPerson_whole(person_id, train_id);
	}

	@Override
	public List<Person_whole> getPerson_wholesByPerson_id(long person_id) {
		return person_wholeDao.getPerson_wholesByPerson_id(person_id);
	}

	@Override
	public boolean addTest_produce(Test_produce test_produce) {
		return test_produceDao.add(test_produce);
	}

	@Override
	public boolean deleteTest_produce(long tp_id) {
		return test_produceDao.delete(tp_id);
	}

	@Override
	public boolean updateTest_produce(Test_produce test_produce) {
		return test_produceDao.update(test_produce);
	}

	@Override
	public Test_produce getTest_produce(long tp_id) {
		return test_produceDao.getTest_produce(tp_id);
	}

	@Override
	public List<Test_produce> getTest_produceList() {
		return test_produceDao.getTest_produceList();
	}

	@Override
	public List<Exam_tem> getExam_temList(long tp_id) {
		return exam_temDao.getExam_temList(tp_id);
	}

	@Override
	public Exam_tem getExam_tem(long tp_id, long e_title) {
		return exam_temDao.getExam_tem(tp_id, e_title);
	}

	@Override
	public Exam_paper getExam_paper(String person_id, long tp_id) {
		return exam_paperDao.getExam_paper(person_id, tp_id);
	}

	@Override
	public List<Exam> getExamByC_id(long e_kno_id) {
		return examDao.getExamByC_id(e_kno_id);
	}

	@Override
	public List<Answer> getAnswerList(String person_id, long tp_id) {
		return answerDao.getAnswerList(person_id, tp_id);
	}

	@Override
	public Exam_tem getExam_temBy(long tp_id, long e_id) {
		return exam_temDao.getExam_temBy(tp_id, e_id);
	}

	@Override
	public List<Answer> getAnswerListBy(long title_id, long tp_id) {
		return answerDao.getAnswerListBy(title_id, tp_id);
	}

	@Override
	public Long getMax(long tp_id) {
		return answerDao.getMax(tp_id);
	}

	@Override
	public void updateAnswer(Answer answer) {
		answerDao.update(answer);
		
	}
}
