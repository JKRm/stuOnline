/**
 * 测试生成表的数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Test_produce;

public interface Test_produceDao {

	/**
	 * 测试生成表添加操作
	 * @param test_produce
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean add(Test_produce test_produce);
	
	/**
	 * 测试生成表添加操作
	 * @param tp_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean delete(long tp_id);
	
	/**
	 * 测试生成表添加操作
	 * @param test_produce
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean update(Test_produce test_produce);
	
	/**
	 * 测试生成表添加操作
	 * @param tp_id
	 * @return Test_produce
	 * @author 山大威海hty
	 */
	public Test_produce getTest_produce(long tp_id);

	public List<Test_produce> getTest_produceList();
	
	//获取全部记录
	public List<Test_produce> getAll();
}
