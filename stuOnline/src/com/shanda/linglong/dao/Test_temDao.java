/**
 * �����ʾ���ݴ����ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_tem;

public interface Test_temDao {

	/**
	 * ��Ӵ�
	 * @param test_tem
	 * @return
	 * @author ɽ������hty
	 */
	public boolean add(Test_tem test_tem);
	
	/**
	 * ���´�
	 * @param test_tem
	 * @return
	 * @author ɽ������hty
	 */
	public boolean update(Test_tem test_tem);
	
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
