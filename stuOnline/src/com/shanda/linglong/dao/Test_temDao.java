/**
 * 调查问卷答案暂存数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_tem;

public interface Test_temDao {

	/**
	 * 添加答案
	 * @param test_tem
	 * @return
	 * @author 山大威海hty
	 */
	public boolean add(Test_tem test_tem);
	
	/**
	 * 更新答案
	 * @param test_tem
	 * @return
	 * @author 山大威海hty
	 */
	public boolean update(Test_tem test_tem);
	
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
