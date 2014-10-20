package com.shanda.linglong.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shanda.linglong.dao.PermissionDao;
import com.shanda.linglong.model.Permission;

@Component("PermissionDao")
public class PermissionDaoImpl implements PermissionDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shanda.linglong.dao.PermissionDao#savePermission(com.shanda.linglong
	 * .model.Permission)
	 * 
	 * ����һ����¼������
	 */
	@Override
	public void savePermission(Permission permission) {
		// TODO Auto-generated method stub

		hibernateTemplate.save(permission);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shanda.linglong.dao.PermissionDao#deletePermission(java.lang.String)
	 * 
	 * ɾ��ָ�����ֶ�Ӧ�ļ�¼
	 */
	@Override
	public void deletePermission(Permission permission) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(permission);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shanda.linglong.dao.PermissionDao#updatePermission(java.lang.String)
	 * 
	 * �޸�ָ��Ȩ�޵�����
	 */
	@Override
	public void updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(permission);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shanda.linglong.dao.PermissionDao#findPermission(java.lang.String)
	 * 
	 * ���������ҵ�ָ����ʵ��
	 */
	@Override
	public Permission findPermission(String p_name) {
		// TODO Auto-generated method stub

		List<Permission> list = hibernateTemplate.find(
				"from Permission p where p.p_name=?", p_name);
		if (list.size() == 1)
			return list.get(0);
		else {
			System.out.print("0");
			return null;
		}
	}

	@Override
	public List<Permission> findPermissions() {
		// TODO Auto-generated method stub
		List<Permission> list = hibernateTemplate.find("from Permission");
		if (list.size() > 0)
			return list;
		else {
			System.out.print("ERROR");
			return null;
		}
	}

}
