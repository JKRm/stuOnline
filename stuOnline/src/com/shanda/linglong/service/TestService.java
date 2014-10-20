/**
 * �����ʾ�
 */

package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Test;
import com.shanda.linglong.model.Test_answer;
import com.shanda.linglong.model.Test_question;
import com.shanda.linglong.model.Test_tem;

public interface TestService {

	/**
	 * ��ӵ����ʾ�
	 * @param test
	 * @return
	 * @author ɽ������hty
	 */
	public boolean add(Test test);
	
	/**
	 * ɾ�������ʾ�
	 * @param t_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean delete(long t_id);
	
	/**
	 * ���µ����ʾ�
	 * @param test
	 * @return
	 * @author ɽ������hty
	 */
	public boolean update(Test test);
	
	/**
	 * ��ȡ���е����ʾ�
	 * @return
	 * @author ɽ������hty
	 */
	public List<Test> getTestList();
	
	/**
	 * ��ȡĳһ�������ʾ�
	 * @param t_id
	 * @return
	 * @author ɽ������hty
	 */
	public Test getTestByT_id(long t_id);
	
	/**
	 * ������
	 * @param test_question
	 * @return
	 * @author ɽ������hty
	 */
	public boolean addTest_question(Test_question test_question);
	
	/**
	 * ɾ�����
	 * @param tq_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean deleteTest_question(long tq_id);
	
	/**
	 * �������
	 * @param test_question
	 * @return
	 * @author ɽ������hty
	 */
	public boolean updateTest_question(Test_question test_question);
	
	/**
	 * ��ȡĳһ���
	 * @param tq_number
	 * @param t_id
	 * @return
	 * @author ɽ������hty
	 */
	public Test_question getTest_question(int offset,long t_id);
	
	/**
	 * ��ȡĳ���ʾ���������
	 * @param t_id
	 * @return
	 * @author ɽ������hty
	 */
	public List<Test_question> getTest_questions(long t_id);
	
	/**
	 * ��ӵ����ʾ����
	 * @param test_answer
	 * @return
	 * @author ɽ������hty
	 */
	public boolean addTest_answer(Test_answer test_answer);
	
	/**
	 * ɾ�������ʾ����
	 * @param ta_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean deleteTest_answer(long ta_id);
	
	/**
	 * ���µ����ʾ����
	 * @param test_answer
	 * @return
	 * @author ɽ������hty
	 */
	public boolean updateTest_answer(Test_answer test_answer);
	
	/**
	 * ����ĳ��ĳ����ѵ�ĵ����ʾ����
	 * @param person_id
	 * @param t_id
	 * @return
	 * @author ɽ������hty
	 */
	public Test_answer getTest_answer(String person_id,long t_id);
	
	/**
	 * ����ĳ�˵����е����ʾ����
	 * @param person_id
	 * @return
	 * @author ɽ������hty
	 */
	public List<Test_answer> getTest_answerByPerson_id(String person_id);
	
	/**
	 * ����ĳ����ѵ�������˵ĵ����ʾ����
	 * @param t_id
	 * @return
	 * @author ɽ������hty
	 */
	public List<Test_answer> getTest_answerByT_id(long t_id);
	
	/**
	 * ��Ӵ�
	 * @param test_tem
	 * @return
	 * @author ɽ������hty
	 */
	public boolean addTest_tem(Test_tem test_tem);
	
	/**
	 * ���´�
	 * @param test_tem
	 * @return
	 * @author ɽ������hty
	 */
	public boolean updateTest_tem(Test_tem test_tem);
	
	/**
	 * ���Ҵ�
	 * @param tt_id
	 * @return
	 * @author ɽ������hty
	 */
	public Test_tem getTest_tem(long tt_id);
	
	/**
	 * ��ȡĳ��ĳ�ŵ����ʾ���ܵ÷�
	 * @param person_id
	 * @param t_id
	 * @return
	 */
	public float getTotalScore(String person_id,long t_id);
	
	public List<Test_tem> getTest_temList(String person_id,long t_id);
}
