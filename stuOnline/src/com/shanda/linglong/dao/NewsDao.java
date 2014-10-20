package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Enterprise_news;

public interface NewsDao {
	
	/**
	 * ��ȡ���µ�����
	 * @return Enterprise_news ����ʵ����
	 * @author ɽ������JoeyK
	 */
	public Enterprise_news getLatestNews();
	
	/**
	 * �������
	 * @param news ����ʵ����
	 * @return boolean ����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean add(Enterprise_news news);
	
	/**
	 * ��������
	 * @param news ����������Ϣ������ʵ����
	 * @return boolean �����Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean update(Enterprise_news news);
	
	/**
	 * ��ȡ�����б�
	 * @return List<Enterprise_news>�����б�
	 * @author ɽ������JoeyK
	 */
	public List<Enterprise_news> getNews();
	
	/**
	 * �������ű�Ż�ȡ��Ӧ����
	 * @param nid
	 * @return Enterprise_news
	 * @author ɽ������JoeyK
	 */
	public Enterprise_news getNews(long nid);
	
	/**
	 * ɾ����Ӧ����
	 * @param news ����ʵ����
	 * @return boolean ɾ���Ƿ�ɹ���־
	 * @author ɽ������JoeyK
	 */
	public boolean delete(Enterprise_news news);
	
	public List<Enterprise_news> getNewsByIsd(String isd);
}
