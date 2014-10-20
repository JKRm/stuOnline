package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Course_resource;

public interface ResourceDao {
	
	/**
	 * 添加相应的课程资料
	 * @param cr
	 * @return boolean 是否成功添加标志
	 * @author 山大威海JoeyK
	 */
	public boolean add(Course_resource cr);
	
	/**
	 * 获取全部课程资料的列表
	 * @return List<Course_resource>
	 * @author 山大威海JoeyK
	 */
	public List<Course_resource> getList();
	
	/**
	 * 根据课程资料编号获取课程资料
	 * @param cr_id 课程资料编号
	 * @return 课程资料对象
	 * @author 山大威海JoeyK
	 */
	public Course_resource getResource(long cr_id);
	
	/**
	 * 删除课程资料
	 * @param cr_id 课程资料编号
	 * @return 山大威海JoeyK
	 */
	public boolean delResource(final long cr_id);
	
	public List<Course_resource> getListBycid(long knowledge_id);
}
