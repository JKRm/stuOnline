package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.Test_temDao;
import com.shanda.linglong.model.Test_option;
import com.shanda.linglong.model.Test_tem;

@Component("test_temDao")
public class Test_temDaoImpl implements Test_temDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean add(Test_tem test_tem) {
		try {
			List<Test_tem> tt = hibernateTemplate
					.find("from Test_tem tem where tem.person_id = ? and tem.t_id = ? and tem.tq_id = ?",
							test_tem.getPerson_id(), test_tem.getT_id(),
							test_tem.getTq_id());
			if(tt.size() == 0){
				hibernateTemplate.save(test_tem);
			}
			else{
				tt.get(0).setToption_id(test_tem.getToption_id());
				hibernateTemplate.update(tt.get(0));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Test_tem test_tem) {
		try {
			hibernateTemplate.update(test_tem);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Test_tem getTest_tem(long tt_id) {
		return (Test_tem) hibernateTemplate.find(
				"from Test_tem test_tem where test_tem.tt_id = ?", tt_id)
				.get(0);
	}

	@Override
	public float getTotalScore(String person_id, long t_id) {
		List<Test_tem> list = hibernateTemplate
				.find("from Test_tem test_tem where test_tem.person_id = ? and test_tem.t_id = ?",
						person_id, t_id);
		float sum = 0;
		for (Test_tem test_tem : list) {
			long toption_id = test_tem.getToption_id();
			Test_option test_option = (Test_option) hibernateTemplate
					.find("from Test_option test_option where test_option.toption_id = ?",
							toption_id).get(0);
			sum += test_option.getTo_score();
		}
		return sum / (float) list.size();
	}

	@Override
	public List<Test_tem> getTest_temList(String person_id, long t_id) {
		return hibernateTemplate
				.find("from Test_tem test_tem where test_tem.person_id = ? and test_tem.t_id = ?",
						person_id, t_id);
	}

}
