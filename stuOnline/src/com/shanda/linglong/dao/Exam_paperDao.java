/**
 * 试卷表数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Exam_paper;

public interface Exam_paperDao {

	/**
	 * 选择试卷对应的答题人员
	 * @param person_id
	 * @param tp_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean add(String person_id,long tp_id);
	
	/**
	 * 删除不合法的试卷答题人
	 * @param ep_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean delete(long ep_id);
	
	/**
	 * 确定试卷答题人后的相关操作
	 * @param exam_paper
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean update(Exam_paper exam_paper);
	
	/**
	 * 寻找某人的所有考试
	 * @param person_id
	 * @return List<Exam_paper>
	 * @author 山大威海hty
	 */
	public List<Exam_paper> getExam_paperByPerson_id(String person_id);
	
	/**
	 * 某个考试的所有人员
	 * @param tp_id
	 * @return List<Exam_paper>
	 * @author 山大威海hty
	 */
	public List<Exam_paper> getExam_paperByTp_id(long tp_id);
	
	public Exam_paper getExam_paper(String person_id,long tp_id);
	
	public void save_ep(Exam_paper exam_paper);
	
}
