/**
 * 试题答案表数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Answer;

public interface AnswerDao {

	/**
	 * 保存学员答题记录
	 * @param person_id
	 * @param e_title
	 * @param title_id
	 * @param a_answer
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean saveAnswer(String person_id,long tp_id,long title_id,String a_answer);
	
	/**
	 * 获取所有得分
	 * @param title_id
	 * @return List<Long>
	 * @author 山大威海hty
	 */
	public List<Long> getScores(long title_id);
	
	//保存人员编号和测试生成表编号
	public void save_pt(Answer a);
	
	public List<Answer> getAnswerList(String person_id,long tp_id);

	public List<Answer> getAnswerListBy(long title_id,long tp_id);
	
	public Long getMax(long tp_id);
	
	public void update(Answer answer);
}
