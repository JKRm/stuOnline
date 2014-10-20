/**
 * 学员培训总体情况数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Person_whole;

public interface Person_wholeDao {

	/**
	 * 添加学员培训总体情况
	 * @param person_whole
	 * @return
	 * @author 山大威海hty
	 */
	public boolean add(Person_whole person_whole);
	
	/**
	 * 删除学员培训总体情况
	 * @param pw_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean delete(long pw_id);
	
	/**
	 * 更新学员培训总体情况
	 * @param person_whole
	 * @return
	 * @author 山大威海hty
	 */
	public boolean update(Person_whole person_whole);
	
	/**
	 * 通过学员编号和培训编号，获取某个学员的某次培训的总体情况
	 * @param person_id
	 * @param train_id
	 * @return
	 * @author 山大威海hty
	 */
	public Person_whole getPerson_whole(long person_id, long train_id);
	
	/**
	 * 通过学员编号，获取某个学员的所有培训的总体情况
	 * @param person_id
	 * @return
	 * @author 山大威海hty
	 */
	public List<Person_whole> getPerson_wholesByPerson_id(long person_id);

}
