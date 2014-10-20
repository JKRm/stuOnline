package com.shanda.linglong.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.RecordDao;
import com.shanda.linglong.dao.ResourceDao;
import com.shanda.linglong.model.Course_resource;
import com.shanda.linglong.model.Record_discuss;
import com.shanda.linglong.service.ResourceService;
import com.shanda.linglong.vo.QueryResult;

@Component("resourceService")
public class ResourceServiceImpl implements ResourceService{
	
	private ResourceDao rd;
	
	@Resource(name="resourceDao")
	public void setRd(ResourceDao rd) {
		this.rd = rd;
	}

	public ResourceDao getRd() {
		return rd;
	}

	@Override
	public boolean addResource(Course_resource cs) {
		return rd.add(cs);
		
	}

	@Override
	public List<Course_resource> getList() {
		// TODO Auto-generated method stub
		return rd.getList();
	}

	@Override
	public Course_resource getResource(long cr_id) {
		// TODO Auto-generated method stub
		return rd.getResource(cr_id);
	}

	@Override
	public boolean delResource(long cr_id) {
		// TODO Auto-generated method stub
		return rd.delResource(cr_id);
	}

	@Override
	public List<Course_resource> getListBycid(long knowledge_id) {
		// TODO Auto-generated method stub
		return rd.getListBycid(knowledge_id);
	}
	

}
