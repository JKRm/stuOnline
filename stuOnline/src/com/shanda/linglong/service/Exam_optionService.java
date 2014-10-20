/**
 * 试题库题干操作
 */

package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Exam_option;

public interface Exam_optionService {
	/**
	 * 上传试题库题目选项
	 * @param Exam_option exam_option
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean add(Exam_option exam_option);
	
	/**
	 * 删除已上传的试题库题目选项
	 * @param long eo_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean delete(long eo_id);
	
	/**
	 * 更新已上传的试题库题目选项
	 * @param Exam_option exam_option
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean update(Exam_option exam_option);
	
	/**
	 * 显示已上传的试题库的单道题目的所有选项
	 * @param long e_id
	 * @return Exam_option
	 * @author 山大威海hty
	 */
	public List<Exam_option> getExamByE_id(long e_id);
	
}
