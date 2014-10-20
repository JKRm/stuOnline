/**
 * 试题暂存表数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Exam_tem;

public interface Exam_temDao {

	/**
	 * 存储试题
	 * @param exam_tem
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean add(Exam_tem exam_tem);
	
	public List<Exam_tem> getExam_temList(long tp_id);
	
	public Exam_tem getExam_tem(long tp_id, long e_title);

	public Exam_tem getExam_temBy(long tp_id, long e_id);
}
