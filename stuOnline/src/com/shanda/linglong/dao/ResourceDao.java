package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Course_resource;

public interface ResourceDao {
	
	/**
	 * �����Ӧ�Ŀγ�����
	 * @param cr
	 * @return boolean �Ƿ�ɹ���ӱ�־
	 * @author ɽ������JoeyK
	 */
	public boolean add(Course_resource cr);
	
	/**
	 * ��ȡȫ���γ����ϵ��б�
	 * @return List<Course_resource>
	 * @author ɽ������JoeyK
	 */
	public List<Course_resource> getList();
	
	/**
	 * ���ݿγ����ϱ�Ż�ȡ�γ�����
	 * @param cr_id �γ����ϱ��
	 * @return �γ����϶���
	 * @author ɽ������JoeyK
	 */
	public Course_resource getResource(long cr_id);
	
	/**
	 * ɾ���γ�����
	 * @param cr_id �γ����ϱ��
	 * @return ɽ������JoeyK
	 */
	public boolean delResource(final long cr_id);
	
	public List<Course_resource> getListBycid(long knowledge_id);
}
