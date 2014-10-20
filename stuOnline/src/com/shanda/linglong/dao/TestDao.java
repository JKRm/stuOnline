/**
 * 职业测评表数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test;

public interface TestDao {

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
	
}
