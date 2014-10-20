/**
 * �����ʾ�������ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_answer;

public interface Test_answerDao {

	/**
	 * ��ӵ����ʾ����
	 * @param test_answer
	 * @return
	 * @author ɽ������hty
	 */
	public boolean add(Test_answer test_answer);
	
	/**
	 * ɾ�������ʾ����
	 * @param ta_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean delete(long ta_id);
	
	/**
	 * ���µ����ʾ����
	 * @param test_answer
	 * @return
	 * @author ɽ������hty
	 */
	public boolean update(Test_answer test_answer);
	
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
	
	//����ְ����źͲ�����ID
	public void savept(Test_answer ta);
	
}
