package com.shanda.linglong.service;

import java.util.List;
import java.util.Set;

import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Train_detail;

public interface CourseService {
	/**
	 * ����ĳһ�ڵ��������֪ʶ��id
	 * @param c_id �γ̱��
	 * @return Set<Course>  �γ̼�
	 * @author ɽ������hty
	 */
	public Set<Course> getCourseId(long c_id);
	/**
	 * ���ݿγ�introduction���Ի�ȡ�γ��б�
	 * @param introduction introduction����
	 * @return List<Course>
	 * @author ɽ������JoeyK
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
