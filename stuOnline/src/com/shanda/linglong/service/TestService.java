/**
 * 调查问卷
 */

package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Test;
import com.shanda.linglong.model.Test_answer;
import com.shanda.linglong.model.Test_question;
import com.shanda.linglong.model.Test_tem;

public interface TestService {

	/**
	 * 添加调查问卷
	 * @param test
	 * @return
	 * @author 山大威海hty
	 */
	public boolean add(Test test);
	
	/**
	 * 删除调查问卷
	 * @param t_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean delete(long t_id);
	
	/**
	 * 更新调查问卷
	 * @param test
	 * @return
	 * @author 山大威海hty
	 */
	public boolean update(Test test);
	
	/**
	 * 获取所有调查问卷
	 * @return
	 * @author 山大威海hty
	 */
	public List<Test> getTestList();
	
	/**
	 * 获取某一个调查问卷
	 * @param t_id
	 * @return
	 * @author 山大威海hty
	 */
	public Test getTestByT_id(long t_id);
	
	/**
	 * 添加题干
	 * @param test_question
	 * @return
	 * @author 山大威海hty
	 */
	public boolean addTest_question(Test_question test_question);
	
	/**
	 * 删除题干
	 * @param tq_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean deleteTest_question(long tq_id);
	
	/**
	 * 更新题干
	 * @param test_question
	 * @return
	 * @author 山大威海hty
	 */
	public boolean updateTest_question(Test_question test_question);
	
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
	
	/**
	 * 添加调查问卷分析
	 * @param test_answer
	 * @return
	 * @author 山大威海hty
	 */
	public boolean addTest_answer(Test_answer test_answer);
	
	/**
	 * 删除调查问卷分析
	 * @param ta_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean deleteTest_answer(long ta_id);
	
	/**
	 * 更新调查问卷分析
	 * @param test_answer
	 * @return
	 * @author 山大威海hty
	 */
	public boolean updateTest_answer(Test_answer test_answer);
	
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
	
	/**
	 * 添加答案
	 * @param test_tem
	 * @return
	 * @author 山大威海hty
	 */
	public boolean addTest_tem(Test_tem test_tem);
	
	/**
	 * 更新答案
	 * @param test_tem
	 * @return
	 * @author 山大威海hty
	 */
	public boolean updateTest_tem(Test_tem test_tem);
	
	/**
	 * 查找答案
	 * @param tt_id
	 * @return
	 * @author 山大威海hty
	 */
	public Test_tem getTest_tem(long tt_id);
	
	/**
	 * 获取某人某张调查问卷的总得分
	 * @param person_id
	 * @param t_id
	 * @return
	 */
	public float getTotalScore(String person_id,long t_id);
	
	public List<Test_tem> getTest_temList(String person_id,long t_id);
}
