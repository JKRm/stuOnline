/**
 * 对Course表的数据库操作
 */

package com.shanda.linglong.dao;

import java.util.List;
import java.util.Set;

import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Train_detail;

public interface CourseDao {

	/**
	 * 查找某一节点的所有子知识点id
	 * @param c_id 课程编号
	 * @return Set<Course>  课程集
	 * @author 山大威海hty
	 */
	public Set<Course> getCourseId(long c_id);
	
	/**
	 * 获得相同introduction的课程的集合
	 * @param Introductions
	 * @return List<Course> 课程列表
	 * @author 山大威海JoeyK
	 */
	public List<Course> getCourseIntroduction(String Introductions);
	
	public List<Course> getCourseIntroductionAndpid(String Introductions,long c_pid);
	
	public boolean delCourse(long cid);
	
	public long addCourse(Course course);
	
	public Course getCourseById(long c_id);
	
	public boolean updateCourse(Course course);
	
	public List<Course> getChildren(long cid);
	
	public boolean saveTrainDetail(Train_detail td);
	
	public List<Course> getCouresListByC_name(String c_name);
	
	public List<Course> getKno(String c_introduction);
	
	public List<Course> getExam_produceList();
	
	public boolean updateTrainDetail(Train_detail td);
	
	public List<Train_detail> getTrainById(long cid);
	
	public boolean delTrainDetail(Train_detail td);
	
	public List<Person_progress> getAllList(String person_id);
}
