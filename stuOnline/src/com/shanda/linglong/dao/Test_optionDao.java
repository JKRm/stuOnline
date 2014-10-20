/**
 * 调查问卷题目选项数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_option;

public interface Test_optionDao {

	/**
	 * 添加题目选项
	 * @param test_option
	 * @return
	 * @author 山大威海hty
	 */
	public boolean add(Test_option test_option);
	
	/**
	 * 删除题目选项
	 * @param toption_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean delete(long toption_id);
	
	/**
	 * 更新题目选项
	 * @param test_option
	 * @return
	 * @author 山大威海hty
	 */
	public boolean update(Test_option test_option);
	
	/**
	 * 查找某一个选项
	 * @param toption_id
	 * @return
	 * @author 山大威海hty
	 */
	public Test_option getTest_option(long toption_id);
	
	/**
	 * 查找某道题的题目选项
	 * @param t_id
	 * @param to_id
	 * @return
	 * @author 山大威海hty
	 */
	public List<Test_option> getTest_options(long tq_id);
	
}
