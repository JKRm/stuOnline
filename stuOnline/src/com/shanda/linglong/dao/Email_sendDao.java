package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Email_send;

public interface Email_sendDao {
	
	/**
	 * ����ʼ��ռ�����Ϣ
	 * @param es �ʼ��ռ�����Ϣʵ����
	 * @return ��Ϣ����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean add(Email_send es);
	
	/**
	 * �����ʼ����ɾ���ʼ��ռ�����Ϣ
	 * @param email_id �ʼ����
	 * @return ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delByEmailId(final long email_id);
	
	/**
	 * �����ʼ���Ż�ȡ�ʼ��ռ����б�
	 * @param email_id �ʼ����
	 * @return �ʼ��ռ����б�
	 * @author ɽ������JoeyK
	 */
	public List<Email_send> getListByEmailId(final long email_id);
}
