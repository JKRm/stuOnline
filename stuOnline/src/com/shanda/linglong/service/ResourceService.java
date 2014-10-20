package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.vo.QueryResult;

public interface ResourceService {
	
	/**
	 * ��ӿγ�����
	 * @param cs �γ�����ʵ�������
	 * @return boolean �����Ƿ�ɹ���ӱ�־
	 * @author ɽ������JoeyK
	 */
	public boolean addResource(Course_resource cs);
	
	/**
	 * ��ȡȫ���γ������б�
	 * @return List<Course_resource> �γ������б�
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
