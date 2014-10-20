/**
 * �������ɱ�����ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_produce;

public interface Test_produceDao {

	/**
	 * �������ɱ���Ӳ���
	 * @param test_produce
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean add(Test_produce test_produce);
	
	/**
	 * �������ɱ���Ӳ���
	 * @param tp_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean delete(long tp_id);
	
	/**
	 * �������ɱ���Ӳ���
	 * @param test_produce
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean update(Test_produce test_produce);
	
	/**
	 * �������ɱ���Ӳ���
	 * @param tp_id
	 * @return Test_produce
	 * @author ɽ������hty
	 */
	public Test_produce getTest_produce(long tp_id);

	public List<Test_produce> getTest_produceList();
	
	//��ȡȫ����¼
	public List<Test_produce> getAll();
}
