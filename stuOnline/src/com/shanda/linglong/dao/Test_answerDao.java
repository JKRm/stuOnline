/**
 * 调查问卷分析数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_answer;

public interface Test_answerDao {

	/**
	 * 添加调查问卷分析
	 * @param test_answer
	 * @return
	 * @author 山大威海hty
	 */
	public boolean add(Test_answer test_answer);
	
	/**
	 * 删除调查问卷分析
	 * @param ta_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean delete(long ta_id);
	
	/**
	 * 更新调查问卷分析
	 * @param test_answer
	 * @return
	 * @author 山大威海hty
	 */
	public boolean update(Test_answer test_answer);
	
	/**
	 * 查找某人某次培训的调查问卷分析
	 * @param person_id
	 * @param t_id
	 * @return
	 * @author 山大威海hty
	 */
	public Test_answer getTest_answer(String person_id,long t_id);
	
	/**
	 * 查找某人的所有调查问卷分析
	 * @param person_id
	 * @return
	 * @author 山大威海hty
	 */
	public List<Test_answer> getTest_answerByPerson_id(String person_id);
	
	/**
	 * 查找某次培训的所有人的调查问卷分析
	 * @param t_id
	 * @return
	 * @author 山大威海hty
	 */
	public List<Test_answer> getTest_answerByT_id(long t_id);
	
	//保存职工编号和测评表ID
	public void savept(Test_answer ta);
	
}
