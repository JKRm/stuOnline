package com.shanda.linglong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.OrgnizationDao;
import com.shanda.linglong.model.Orgnization;
import com.shanda.linglong.service.OrgnizationService;

@Component("OrgnizationService")
public class OrgnizationServiceImpl implements OrgnizationService{

	
	private OrgnizationDao od;
	public OrgnizationDao getOd() {
		return od;
	}
	@Resource(name="OrgnizationDao")
	public void setOd(OrgnizationDao od) {
		this.od = od;
	}
	@Override
	public List<Orgnization> getAll() {
		// TODO Auto-generated method stub
		return od.findAll();
	}

}
