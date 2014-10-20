/**
 * ��Course������ݿ����
 */

package com.shanda.linglong.dao;

import java.util.List;
import java.util.Set;

import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Train_detail;

public interface CourseDao {

	/**
	 * ����ĳһ�ڵ��������֪ʶ��id
	 * @param c_id �γ̱��
	 * @return Set<Course>  �γ̼�
	 * @author ɽ������hty
	 */
	public Set<Course> getCourseId(long c_id);
	
	/**
	 * �����ͬintroduction�Ŀγ̵ļ���
	 * @param Introductions
	 * @return List<Course> �γ��б�
	 * @author ɽ������JoeyK
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
