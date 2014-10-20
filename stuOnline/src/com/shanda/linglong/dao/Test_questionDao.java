/**
 * ������ɱ����ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_question;

public interface Test_questionDao {

	/**
	 * ������
	 * @param test_question
	 * @return
	 * @author ɽ������hty
	 */
	public boolean add(Test_question test_question);
	
	/**
	 * ɾ�����
	 * @param tq_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean delete(long tq_id);
	
	/**
	 * �������
	 * @param test_question
	 * @return
	 * @author ɽ������hty
	 */
	public boolean update(Test_question test_question);
	
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
	
}
