package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.vo.QueryResult;

public interface ResourceService {
	
	/**
	 * 添加课程资料
	 * @param cs 课程资料实体类对象
	 * @return boolean 资料是否成功添加标志
	 * @author 山大威海JoeyK
	 */
	public boolean addResource(Course_resource cs);
	
	/**
	 * 获取全部课程资料列表
	 * @return List<Course_resource> 课程资料列表
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
