/**
 * �����ʾ���Ŀѡ�����ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_option;

public interface Test_optionDao {

	/**
	 * �����Ŀѡ��
	 * @param test_option
	 * @return
	 * @author ɽ������hty
	 */
	public boolean add(Test_option test_option);
	
	/**
	 * ɾ����Ŀѡ��
	 * @param toption_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean delete(long toption_id);
	
	/**
	 * ������Ŀѡ��
	 * @param test_option
	 * @return
	 * @author ɽ������hty
	 */
	public boolean update(Test_option test_option);
	
	/**
	 * ����ĳһ��ѡ��
	 * @param toption_id
	 * @return
	 * @author ɽ������hty
	 */
	public Test_option getTest_option(long toption_id);
	
	/**
	 * ����ĳ�������Ŀѡ��
	 * @param t_id
	 * @param to_id
	 * @return
	 * @author ɽ������hty
	 */
	public List<Test_option> getTest_options(long tq_id);
	
}
