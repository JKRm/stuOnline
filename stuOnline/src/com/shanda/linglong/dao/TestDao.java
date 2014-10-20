/**
 * ְҵ���������ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test;

public interface TestDao {

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
	
}
