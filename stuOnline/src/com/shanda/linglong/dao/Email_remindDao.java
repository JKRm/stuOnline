package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Email_remind;

public interface Email_remindDao {
	
	/**
	 * 添加邮件发送信息
	 * @param er 邮件发送实体类对象
	 * @return 添加的邮件对应的编号email_id
	 * @author 山大威海JoeyK
	 */
	public long add(Email_remind er);
	
	/**
	 * 根据邮件编号删除邮件发送信息
	 * @param email_id 邮件编号
	 * @return 删除是否成标志
	 * @author 山大威海JoeyK
	 */
	public boolean delByEmailId(final long email_id);
	
	/**
	 * 获得全部的邮件发送信息
	 * @return 邮件发送列表
	 * @author 山大威海JoeyK
	 */
	public List<Email_remind> getList();
}
