/**
 * Exam类操作方法封装
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Exam;

public interface ExamDao {

	/**
	 * 上传试题库题目
	 * @param exam
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean add(Exam exam);
	
	/**
	 * 删除已上传的试题库题目
	 * @param e_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean delete(long e_id);
	
	/**
	 * 更新已上传的试题库题目
	 * @param exam
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean update(Exam exam);
	
	/**
	 * 列出已上传的试题库题目列表
	 * @param 
	 * @return List<Exam>
	 * @author 山大威海hty
	 */
	public List<Exam> getExamList();
	
	/**
	 * 显示已上传的试题库的单道题目
	 * @param e_id
	 * @return Exam
	 * @author 山大威海hty
	 */
	public Exam getExamByE_id(long e_id);
	
	/**
	 * 自动生成试题库
	 * @param e_kno_id
	 * @param e_type
	 * @param e_score
	 * @param e_diff
	 * @return List<Exam>
	 * @author 山大威海hty
	 */
	public Exam getExamByAuto(long e_kno_id,String e_type,long e_score,float e_diff);
	
	/**
	 * 获取试题答案
	 * @param e_id
	 * @return String
	 * @author 山大威海hty
	 */
	public String getAnswer(long e_id);
	
	public List<Exam> getExamByC_id(long e_kno_id);
	
}
