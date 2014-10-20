package com.shanda.linglong.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.ResourceDao;
import com.shanda.linglong.model.Course;
import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.model.Enterprise_news;

@Component("resourceDao")
public class ResourceDaoImpl implements ResourceDao{
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

	@Override
	public boolean add(Course_resource cr) {
		try {
			hibernateTemplate.save(cr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Course_resource> getList() {
		return hibernateTemplate
		.find("from Course_resource cr)");
	}

	@Override
	public Course_resource getResource(long cr_id) {
		// TODO Auto-generated method stub
		return (Course_resource) hibernateTemplate
		.find("from Course_resource resource where resource.cr_id = ?", cr_id).get(0);
	}

	@Override
	public boolean delResource(final long cr_id) {
		this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session
						.createQuery(
								"delete from Course_resource as course_resource where course_resource.cr_id = ?")
						.setParameter(0, cr_id).executeUpdate();
			}

		});
		return true;
	}

	@Override
	public List<Course_resource> getListBycid(long knowledge_id) {
		return (List<Course_resource>) hibernateTemplate.find(
				"from Course_resource cr where cr.knowledge_id = ?",
				knowledge_id);
	}
	
	

}
