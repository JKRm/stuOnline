package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Email_remind;

public interface Email_remindDao {
	
	/**
	 * ����ʼ�������Ϣ
	 * @param er �ʼ�����ʵ�������
	 * @return ��ӵ��ʼ���Ӧ�ı��email_id
	 * @author ɽ������JoeyK
	 */
	public long add(Email_remind er);
	
	/**
	 * �����ʼ����ɾ���ʼ�������Ϣ
	 * @param email_id �ʼ����
	 * @return ɾ���Ƿ�ɱ�־
	 * @author ɽ������JoeyK
	 */
	public boolean delByEmailId(final long email_id);
	
	/**
	 * ���ȫ�����ʼ�������Ϣ
	 * @return �ʼ������б�
	 * @author ɽ������JoeyK
	 */
	public List<Email_remind> getList();
}
