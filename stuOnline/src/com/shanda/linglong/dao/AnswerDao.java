/**
 * ����𰸱����ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Answer;

public interface AnswerDao {

	/**
	 * ����ѧԱ�����¼
	 * @param person_id
	 * @param e_title
	 * @param title_id
	 * @param a_answer
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean saveAnswer(String person_id,long tp_id,long title_id,String a_answer);
	
	/**
	 * ��ȡ���е÷�
	 * @param title_id
	 * @return List<Long>
	 * @author ɽ������hty
	 */
	public List<Long> getScores(long title_id);
	
	//������Ա��źͲ������ɱ���
	public void save_pt(Answer a);
	
	public List<Answer> getAnswerList(String person_id,long tp_id);

	public List<Answer> getAnswerListBy(long title_id,long tp_id);
	
	public Long getMax(long tp_id);
	
	public void update(Answer answer);
}
