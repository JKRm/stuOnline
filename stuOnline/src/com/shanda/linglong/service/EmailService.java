package com.shanda.linglong.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shanda.linglong.model.Email_remind;
import com.shanda.linglong.model.Email_remind_appendix;
import com.shanda.linglong.model.Email_send;

@Component("emailService")
public interface EmailService {
	
	/**
	 * ����ʼ�����
	 * @param era �ʼ�����ʵ�������
	 * @return ����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean addAppendixs(Email_remind_appendix era);
	
	/**
	 * �����ʼ����ɾ���ʼ�����
	 * @param email_id �ʼ����
	 * @return ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delAppendixByEmailId(long email_id);
	
	/**
	 * ����Ҽ�����
	 * @param er �ʼ�����ʵ�������
	 * @return �ʼ����
	 * @author ɽ������JoeyK
	 */
	public long addEmail(Email_remind er);
	
	/**
	 * �����ʼ����ɾ���ʼ�����
	 * @param email_id �ʼ����
	 * @return ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delEmail(long email_id);
	
	/**
	 * ����ʼ��ռ���
	 * @param es �ʼ��ռ���ʵ�������
	 * @return ����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean addSend(Email_send es);
	
	/**
	 * �����ʼ����ɾ���ʼ��ռ���
	 * @param email_id �ʼ���� 
	 * @return ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delSendByEmailId(long email_id);
	
	/**
	 * ��ȡ�ʼ������б�
	 * @return �ʼ������б�
	 * @author ɽ������JoeyK
	 */
	public List<Email_remind> getList();
	
	/**
	 * �����ʼ���Ż�ȡ�ʼ������б�
	 * @param email_id �ʼ����
	 * @return �ʼ������б�
	 * @author ɽ������JoeyK
	 */
	public List<Email_remind_appendix> getLsitByEmailId(long email_id);
	
	/**
	 * �����ʼ���Ż�ȡ�ʼ��ռ����б�
	 * @param email_id �ʼ����
	 * @return �ʼ��ռ����б�
	 * @author ɽ������JoeyK
	 */
	public List<Email_send> getListByEID(long email_id);

}
