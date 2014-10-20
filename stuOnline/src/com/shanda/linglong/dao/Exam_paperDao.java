/**
 * �Ծ�����ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Exam_paper;

public interface Exam_paperDao {

	/**
	 * ѡ���Ծ��Ӧ�Ĵ�����Ա
	 * @param person_id
	 * @param tp_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean add(String person_id,long tp_id);
	
	/**
	 * ɾ�����Ϸ����Ծ������
	 * @param ep_id
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean delete(long ep_id);
	
	/**
	 * ȷ���Ծ�����˺����ز���
	 * @param exam_paper
	 * @return boolean
	 * @author ɽ������hty
	 */
	public boolean update(Exam_paper exam_paper);
	
	/**
	 * Ѱ��ĳ�˵����п���
	 * @param person_id
	 * @return List<Exam_paper>
	 * @author ɽ������hty
	 */
	public List<Exam_paper> getExam_paperByPerson_id(String person_id);
	
	/**
	 * ĳ�����Ե�������Ա
	 * @param tp_id
	 * @return List<Exam_paper>
	 * @author ɽ������hty
	 */
	public List<Exam_paper> getExam_paperByTp_id(long tp_id);
	
	public Exam_paper getExam_paper(String person_id,long tp_id);
	
	public void save_ep(Exam_paper exam_paper);
	
}
