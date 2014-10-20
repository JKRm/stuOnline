package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Email_send;

public interface Email_sendDao {
	
	/**
	 * 添加邮件收件人信息
	 * @param es 邮件收件人信息实体类
	 * @return 信息添加是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean add(Email_send es);
	
	/**
	 * 根据邮件编号删除邮件收件人信息
	 * @param email_id 邮件编号
	 * @return 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delByEmailId(final long email_id);
	
	/**
	 * 根据邮件编号获取邮件收件人列表
	 * @param email_id 邮件编号
	 * @return 邮件收件人列表
	 * @author 山东威海JoeyK
	 */
	public List<Email_send> getListByEmailId(final long email_id);
}
