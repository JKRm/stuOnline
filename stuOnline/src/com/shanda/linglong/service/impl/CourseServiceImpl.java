package com.shanda.linglong.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.CourseDao;
import com.shanda.linglong.dao.ProgressDao;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Train_detail;
import com.shanda.linglong.service.CourseService;

@Component("courseService")
public class CourseServiceImpl implements CourseService{
	
	private CourseDao courseDao;
	
	private ProgressDao progressDao;

	@Resource(name="courseDao")
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}
	
	@Resource(name="progressDao")
	public void setProgressDao(ProgressDao progressDao) {
		this.progressDao = progressDao;
	}

	public ProgressDao getProgressDao() {
		return progressDao;
	}

	@Override
	public List<Course> getCourseByIntorduction(String introduction) {
		
		return courseDao.getCourseIntroduction(introduction);
	}

	@Override
	public List<Course> getCourseIntroductionAndpid(String Introductions,
			long c_pid) {
		// TODO Auto-generated method stub
		return courseDao.getCourseIntroductionAndpid(Introductions, c_pid);
	}

	@Override
	public boolean delCourse(long cid) {
		// TODO Auto-generated method stub
		return courseDao.delCourse(cid);
	}

	@Override
	public long addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.addCourse(course);
	}

	@Override
	public Course getCourseById(long c_id) {
		// TODO Auto-generated method stub
		return courseDao.getCourseById(c_id);
	}

	@Override
	public boolean updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.updateCourse(course);
	}

	@Override
	public List<Course> getChildren(long cid) {
		// TODO Auto-generated method stub
		return courseDao.getChildren(cid);
	}

	@Override
	public boolean add2pp(Person_progress pp) {
		// TODO Auto-generated method stub
		return progressDao.save(pp);
	}

	@Override
	public boolean saveTrainDetail(Train_detail td) {
		// TODO Auto-generated method stub
		return courseDao.saveTrainDetail(td);
	}

	@Override
	public List<Course> getCouresListByC_name(String c_name) {
		return courseDao.getCouresListByC_name(c_name);
	}

	@Override
	public List<Course> getKno(String c_introduction) {
		return courseDao.getKno(c_introduction);
	}

	@Override
	public List<Course> getExam_produceList() {
		return courseDao.getExam_produceList();
	}

	@Override
	public Set<Course> getCourseId(long c_id) {
		return courseDao.getCourseId(c_id);
	}
	
	@Override
	public Train_detail getTrainById(long cid) {
		// TODO Auto-generated method stub
		if(courseDao.getTrainById(cid).size()==0){
			return null;
		}
		else{
			return courseDao.getTrainById(cid).get(0);
		}
		
	}

	@Override
	public boolean delTrainDetail(Train_detail td) {
		// TODO Auto-generated method stub
		return courseDao.delTrainDetail(td);
	}

	@Override
	public List<Person_progress> getAllList(String person_id) {
		// TODO Auto-generated method stub
		return courseDao.getAllList(person_id);
	}

	@Override
	public boolean updateTrainDetail(Train_detail td) {
		// TODO Auto-generated method stub
		return courseDao.updateTrainDetail(td);
	}

	@Override
	public boolean delPP(Person_progress pp) {
		// TODO Auto-generated method stub
		return progressDao.del(pp);
	}

	@Override
	public boolean updatePP(Person_progress pp) {
		// TODO Auto-generated method stub
		return progressDao.update(pp);
	}
	@Override
	public List<Person_progress> getByTrain_id(long train_id) {
		// TODO Auto-generated method stub
		return progressDao.find(train_id);
	}

	@Override
	public boolean delPerson_progress(String personid, long cid) {
		// TODO Auto-generated method stub
		return progressDao.delBy_Pid_Cid(personid, cid);
	}

}
