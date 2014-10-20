package com.shanda.linglong.service;

import java.util.List;
import java.util.Set;

import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Train_detail;

public interface CourseService {
	/**
	 * 查找某一节点的所有子知识点id
	 * @param c_id 课程编号
	 * @return Set<Course>  课程集
	 * @author 山大威海hty
	 */
	public Set<Course> getCourseId(long c_id);
	/**
	 * 根据课程introduction属性获取课程列表
	 * @param introduction introduction属性
	 * @return List<Course>
	 * @author 山大威海JoeyK
	 */
	public List<Course> getCourseByIntorduction(String introduction);
	public List<Course> getCourseIntroductionAndpid(String Introductions,long c_pid);
	public boolean delCourse(long cid);
	public long addCourse(Course course);
	public Course getCourseById(long c_id);
	public boolean updateCourse(Course course);
	public List<Course> getChildren(long cid);
	public boolean add2pp(Person_progress pp);
	public boolean saveTrainDetail(Train_detail td);
	public List<Course> getCouresListByC_name(String c_name);
	
	public List<Course> getKno(String c_introduction);
	
	public List<Course> getExam_produceList();
	
	public Train_detail getTrainById(long cid);
	public boolean delTrainDetail(Train_detail td);
	public List<Person_progress> getAllList(String person_id);
	public boolean updateTrainDetail(Train_detail td);
	public boolean delPP(Person_progress pp);
	public boolean updatePP(Person_progress pp);
	public List<Person_progress> getByTrain_id(long train_id);
	public boolean delPerson_progress(String personid,long cid);
	
}
