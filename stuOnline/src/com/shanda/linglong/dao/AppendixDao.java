package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.News_appendix;

public interface AppendixDao {
	
	/**
	 * ������Ÿ���
	 * @param appendix ����ʵ����
	 * @return boolean ����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean add(News_appendix appendix);
	
	/**
	 * �����ͬ���ű�ŵĸ����б�
	 * @param nid ���ű��
	 * @return List<News_appendix> ���Ÿ����б�
	 * @author ɽ������JoeyK
	 */
	public List<News_appendix> getAppendixs(long nid);
	
	/**
	 * ɾ������
	 * @param appendix ����ʵ����
	 * @return boolean ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delAppendix(News_appendix appendix);
	
	/**
	 * ���ݸ�����Ż�ȡ����
	 * @param aid �������
	 * @return News_appendix ����ʵ����
	 * @author ɽ������JoeyK
	 */
	public News_appendix getAppendix(long aid);
}
