package com.shanda.linglong.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.CourseDao;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Person_progress;
import com.shanda.linglong.model.Train_detail;

@Component("courseDao")
public class CourseDaoImpl implements CourseDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Set<Course> getCourseId(long c_id) {
		Course set = hibernateTemplate.get(Course.class, c_id);
		Set<Course> setCourse = new HashSet<Course>();
		if (set.getC_name().equals("培训")) {
			for (Course curriculum : set.getChildren()) {
				for (Course unit : curriculum.getChildren()) {
					for (Course bar : unit.getChildren()) {
						for (Course point : bar.getChildren()) {
							setCourse.add(point);
						}
					}
				}
			}
		} else if (set.getC_name().equals("课程")) {
			for (Course unit : set.getChildren()) {
				for (Course bar : unit.getChildren()) {
					for (Course point : bar.getChildren()) {
						setCourse.add(point);
					}
				}
			}
		} else {
			for (Course bar : set.getChildren()) {
				for (Course point : bar.getChildren()) {
					setCourse.add(point);
				}
			}
		}
		return setCourse;
	}

	@Override
	public List<Course> getCourseIntroduction(String Introduction) {
		// TODO Auto-generated method stub
		return (List<Course>) hibernateTemplate.find(
				"from Course course where course.c_introduction = ?",
				Introduction);
	}

	@Override
	public List<Course> getCourseIntroductionAndpid(String Introductions,
			long c_pid) {
		// TODO Auto-generated method stub
		return (List<Course>) hibernateTemplate
				.find("from Course course where course.c_introduction = ? and c_pid = ?",
						Introductions,c_pid);
	}

	@Override
	public boolean delCourse(long cid) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(hibernateTemplate.get(Course.class, cid));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public long addCourse(Course course) {
		this.hibernateTemplate.save(course);
		return course.getC_id();
		
	}

	@Override
	public Course getCourseById(long c_id) {
		return (Course) hibernateTemplate.find(
				"from Course course where course.c_id = ?", c_id).get(0);
	}

	@Override
	public boolean updateCourse(Course course) {
		try {
			hibernateTemplate.update(course);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Course> getChildren(long cid) {
		return hibernateTemplate
		.find("from Course course where course.parent.c_id = ? ",cid);
}

	@Override
	public boolean saveTrainDetail(Train_detail td) {
		try {
			this.hibernateTemplate.save(td);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Course> getCouresListByC_name(String c_name) {
		return hibernateTemplate.find("from Course course where course.c_name = ?",c_name);
	}

	@Override
	public List<Course> getKno(String c_introduction) {
		return hibernateTemplate.find("from Course course where course.c_introduction = ?",c_introduction);
	}

	@Override
	public List<Course> getExam_produceList() {
		return hibernateTemplate.find("from Course course where course.c_introduction in ('培训','课程','单元')");
	}
	
	
	@Override
	public List<Train_detail> getTrainById(long cid) {
		return (List<Train_detail>) hibernateTemplate.find(
				"from Train_detail td where td.c_id = ?",
				cid);
	}

	@Override
	public boolean delTrainDetail(Train_detail td) {
		try {
			hibernateTemplate.delete(td);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Person_progress> getAllList(String person_id) {
		return hibernateTemplate
		.find("from Person_progress pp where pp.person_id = ?",person_id);
	}

	@Override
	public boolean updateTrainDetail(Train_detail td) {
		try {
			hibernateTemplate.update(td);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
