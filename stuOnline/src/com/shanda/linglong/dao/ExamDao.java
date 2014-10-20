/**
 * Exam�����������װ
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Exam;

public interface ExamDao {

	/**
	 * �ϴ��������Ŀ
	 * @param exam
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean add(Exam exam);
	
	/**
	 * ɾ�����ϴ����������Ŀ
	 * @param e_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean delete(long e_id);
	
	/**
	 * �������ϴ����������Ŀ
	 * @param exam
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean update(Exam exam);
	
	/**
	 * �г����ϴ����������Ŀ�б�
	 * @param 
	 * @return List<Exam>
	 * @author ɽ������hty
	 */
	public List<Exam> getExamList();
	
	/**
	 * ��ʾ���ϴ��������ĵ�����Ŀ
	 * @param e_id
	 * @return Exam
	 * @author ɽ������hty
	 */
	public Exam getExamByE_id(long e_id);
	
	/**
	 * �Զ����������
	 * @param e_kno_id
	 * @param e_type
	 * @param e_score
	 * @param e_diff
	 * @return List<Exam>
	 * @author ɽ������hty
	 */
	public Exam getExamByAuto(long e_kno_id,String e_type,long e_score,float e_diff);
	
	/**
	 * ��ȡ�����
	 * @param e_id
	 * @return String
	 * @author ɽ������hty
	 */
	public String getAnswer(long e_id);
	
	public List<Exam> getExamByC_id(long e_kno_id);
	
}
