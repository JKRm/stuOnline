package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Email_remind_appendix;

public interface Email_remind_appendixDao {
	
	/**
	 * ����ʼ�����
	 * @param era �ʼ�����ʵ�������
	 * @return ����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean add(Email_remind_appendix era);
	
	/**
	 * ����email_idɾ������
	 * @param email_id �ʼ����
	 * @return ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean deleteByEmailId(final long email_id);
	
	/**
	 * ����email_id�����ʼ������б�
	 * @param email_id �ʼ����
	 * @return ɽ������JoeyK
	 */
	public List<Email_remind_appendix> getListByEmailId(final long email_id);
}
