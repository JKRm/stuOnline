/**
 * �������Ŀ����
 */

package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Answer;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Exam_paper;
import com.shanda.linglong.model.Exam_tem;
import com.shanda.linglong.model.Person_whole;
import com.shanda.linglong.model.Test_produce;

public interface ExamService {

	/**
	 * �ϴ��������Ŀ
	 * 
	 * @param Exam
	 *            exam
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean add(Exam exam);

	/**
	 * ɾ�����ϴ����������Ŀ
	 * 
	 * @param long e_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean delete(long e_id);

	/**
	 * �������ϴ����������Ŀ
	 * 
	 * @param Exam
	 *            exam
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean update(Exam exam);

	/**
	 * �г����ϴ����������Ŀ�б�
	 * 
	 * @param
	 * @return List<Exam>
	 * @author ɽ������hty
	 */
	public List<Exam> getExamList();

	/**
	 * ��ʾ���ϴ��������ĵ�����Ŀ
	 * 
	 * @param long e_id
	 * @return Exam
	 * @author ɽ������hty
	 */
	public Exam getExamByE_id(long e_id);

	/**
	 * �Զ�����ĳ����Ŀ
	 * 
	 * @param e_kno_id
	 * @param e_type
	 * @param e_score
	 * @param e_diff
	 * @param length
	 * @return List<Exam>
	 * @author ɽ������hty
	 */
	public List<Exam> getExamsByAuto(long[] e_kno_id, String e_type,
			long e_score, float[] e_diff, int length);

	/**
	 * �������ɱ�洢
	 * 
	 * @param c_id
	 * @param tp_title
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean saveTest_produce(long c_id, String tp_title);

	/**
	 * �����ݴ��洢
	 * 
	 * @param e_id
	 * @param e_title
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean saveExam_tem(Exam_tem exam_tem);

	/**
	 * �洢�͹���𰸲���¼����
	 * @param person_id
	 * @param e_title
	 * @param title_id
	 * @param a_answer
	 * @return
	 * @author ɽ������hty
	 */
	public boolean saveObjectiveAnswer(String person_id, long e_title, long title_id,
			String a_answer);
	
	/**
	 * �洢������𰸲���¼����
	 * @param person_id
	 * @param e_title
	 * @param title_id
	 * @param a_answer
	 * @return
	 * @author ɽ������hty
	 */
	public boolean saveSubjectiveAnswer(String person_id, long e_title, long title_id,
			String a_answer);

	/**
	 * �����Ѷȸ���
	 * @param e_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean updateDiff(long e_id);
	
	/**
	 * ѡ���Ծ��Ӧ�Ĵ�����Ա
	 * @param person_id
	 * @param tp_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean saveExam_paper(String person_id,long tp_id);
	
	/**
	 * ɾ�����Ϸ����Ծ������
	 * @param ep_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean deleteExam_paper(long ep_id);
	
	/**
	 * ȷ���Ծ�����˺����ز���
	 * @param exam_paper
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean updateExam_paper(Exam_paper exam_paper);
	
	/**
	 * Ѱ��ĳ�˵����п���
	 * @param person_id
	 * @return List<Exam_paper>
	 * @author ɽ������hty
	 */
	public List<Exam_paper> getExam_paperByPerson_id(String person_id);
	
	/**
	 * ĳ�����Ե�������Ա
	 * @param tp_id
	 * @return List<Exam_paper>
	 * @author ɽ������hty
	 */
	public List<Exam_paper> getExam_paperByTp_id(long tp_id);

	/**
	 * ���ĳ�ο��Ե�ƽ������
	 * @param tp_id
	 * @return float
	 * @author ɽ������hty
	 */
	public float getExam_paperAvg(long tp_id);
	
	/**
	 * ���ѧԱ��ѵ�������
	 * @param person_whole
	 * @return
	 * @author ɽ������hty
	 */
	public boolean addPerson_whole(Person_whole person_whole);
	
	/**
	 * ɾ��ѧԱ��ѵ�������
	 * @param pw_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean deletePerson_whole(long pw_id);
	
	/**
	 * ����ѧԱ��ѵ�������
	 * @param person_whole
	 * @return
	 * @author ɽ������hty
	 */
	public boolean updatePerson_whole(Person_whole person_whole);
	
	/**
	 * ͨ��ѧԱ��ź���ѵ��ţ���ȡĳ��ѧԱ��ĳ����ѵ���������
	 * @param person_id
	 * @param train_id
	 * @return
	 * @author ɽ������hty
	 */
	public Person_whole getPerson_whole(long person_id, long train_id);
	
	/**
	 * ͨ��ѧԱ��ţ���ȡĳ��ѧԱ��������ѵ���������
	 * @param person_id
	 * @return
	 * @author ɽ������hty
	 */
	public List<Person_whole> getPerson_wholesByPerson_id(long person_id);
	
	/**
	 * �������ɱ���Ӳ���
	 * @param test_produce
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean addTest_produce(Test_produce test_produce);
	
	/**
	 * �������ɱ���Ӳ���
	 * @param tp_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean deleteTest_produce(long tp_id);
	
	/**
	 * �������ɱ���Ӳ���
	 * @param test_produce
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean updateTest_produce(Test_produce test_produce);
	
	/**
	 * �������ɱ���Ӳ���
	 * @param tp_id
	 * @return Test_produce
	 * @author ɽ������hty
	 */
	public Test_produce getTest_produce(long tp_id);
	
	public List<Test_produce> getTest_produceList();
	
	public List<Exam_tem> getExam_temList(long tp_id);
	
	public Exam_tem getExam_tem(long tp_id, long e_title);
	
	public Exam_paper getExam_paper(String person_id,long tp_id);
	
	public List<Exam> getExamByC_id(long e_kno_id);
	
	public List<Answer> getAnswerList(String person_id,long tp_id);
	
	public Exam_tem getExam_temBy(long tp_id, long e_id);
	
	public List<Answer> getAnswerListBy(long title_id,long tp_id);
	
	public Long getMax(long tp_id);
	
	public void updateAnswer(Answer answer);
}
