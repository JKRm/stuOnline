/**
 * ѧԱ��ѵ����������ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Person_whole;

public interface Person_wholeDao {

	/**
	 * ���ѧԱ��ѵ�������
	 * @param person_whole
	 * @return
	 * @author ɽ������hty
	 */
	public boolean add(Person_whole person_whole);
	
	/**
	 * ɾ��ѧԱ��ѵ�������
	 * @param pw_id
	 * @return
	 * @author ɽ������hty
	 */
	public boolean delete(long pw_id);
	
	/**
	 * ����ѧԱ��ѵ�������
	 * @param person_whole
	 * @return
	 * @author ɽ������hty
	 */
	public boolean update(Person_whole person_whole);
	
	/**
	 * ͨ��ѧԱ��ź���ѵ��ţ���ȡĳ��ѧԱ��ĳ����ѵ���������
	 * @param person_id
	 * @param train_id
	 * @return
	 * @author ɽ������hty
	 */
	public Person_whole getPerson_whole(long person_id, long train_id);
	
	/**
	 * ͨ��ѧԱ��ţ���ȡĳ��ѧԱ��������ѵ���������
	 * @param person_id
	 * @return
	 * @author ɽ������hty
	 */
	public List<Person_whole> getPerson_wholesByPerson_id(long person_id);

}
