/**
 * 测评题干表数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_question;

public interface Test_questionDao {

	/**
	 * 添加题干
	 * @param test_question
	 * @return
	 * @author 山大威海hty
	 */
	public boolean add(Test_question test_question);
	
	/**
	 * 删除题干
	 * @param tq_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean delete(long tq_id);
	
	/**
	 * 更新题干
	 * @param test_question
	 * @return
	 * @author 山大威海hty
	 */
	public boolean update(Test_question test_question);
	
	/**
	 * 获取某一题干
	 * @param tq_number
	 * @param t_id
	 * @return
	 * @author 山大威海hty
	 */
	public Test_question getTest_question(int offset,long t_id);
	
	/**
	 * 获取某张问卷的所有题干
	 * @param t_id
	 * @return
	 * @author 山大威海hty
	 */
	public List<Test_question> getTest_questions(long t_id);
	
}
