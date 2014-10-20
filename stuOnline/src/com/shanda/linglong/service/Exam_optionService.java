/**
 * �������ɲ���
 */

package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Exam_option;

public interface Exam_optionService {
	/**
	 * �ϴ��������Ŀѡ��
	 * @param Exam_option exam_option
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean add(Exam_option exam_option);
	
	/**
	 * ɾ�����ϴ����������Ŀѡ��
	 * @param long eo_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean delete(long eo_id);
	
	/**
	 * �������ϴ����������Ŀѡ��
	 * @param Exam_option exam_option
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean update(Exam_option exam_option);
	
	/**
	 * ��ʾ���ϴ��������ĵ�����Ŀ������ѡ��
	 * @param long e_id
	 * @return Exam_option
	 * @author ɽ������hty
	 */
	public List<Exam_option> getExamByE_id(long e_id);
	
}
