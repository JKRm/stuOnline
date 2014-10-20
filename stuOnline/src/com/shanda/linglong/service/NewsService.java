package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Enterprise_news;
import com.shanda.linglong.model.News_appendix;
import com.shanda.linglong.vo.NewsVo;

public interface NewsService {
	
	/**
	 * �������
	 * @param news ����ʵ�������
	 * @return boolean ��������Ƿ�ɹ�
	 * @author ɽ������JoeyK
	 */
	public boolean addNews(Enterprise_news news);
	
	/**
	 * ������µ�����
	 * @return Enterprise_news ����ʵ����
	 * @author ɽ������JoeyK
	 */
	public Enterprise_news getLatestNews();
	
	/**
	 * ������Ÿ���
	 * @param appendix ����ʵ�������
	 * @return boolean ����Ƿ�ɹ���־
	 */
	public boolean addNewsAppendix(News_appendix appendix);
	
	
	/**
	 * ��ȡ�����б�
	 * @return List<Enterprise_news> �����б�
	 * @author ɽ������JoeyK
	 */
	public List<Enterprise_news> getNews();
	
	/**
	 * �������ű�Ż�ȡ���ż��丽��
	 * @param nid ���ű��
	 * @return NewsVo ���ż�����Ӧ������ɵ�ֵ��
	 * @author ɽ������JoeyK
	 */
	public NewsVo getNews(long nid);
	
	/**
	 * ������������
	 * @param news ����ʵ�������
	 * @return boolean �����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean update(Enterprise_news news);
	
	/**
	 * ɾ����Ӧ�ĸ���
	 * @param appendix ����ʵ�������
	 * @return boolean ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delAppendix(News_appendix appendix);
	
	/**
	 * ɾ��һ�鸽��
	 * @param appendixs ���Ÿ����б�
	 * @author ɽ������JoeyK
	 */
	public void delAppendixs(List<News_appendix> appendixs);
	
	/**
	 * ɾ������
	 * @param news ���ŵ�ʵ�������
	 * @return boolean ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delete(Enterprise_news news);
	
	/**
	 * ���ݸ�����Ż�ȡ����
	 * @param aid �������
	 * @return News_appendix ����ʵ����
	 * @author ɽ������JoeyK
	 */
	public News_appendix getAppendix(long aid);
	
	public List<Enterprise_news> getNewsByIsd(String isd);
}
