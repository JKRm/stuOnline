package com.shanda.linglong.dao;

import java.util.List;

import com.shanda.linglong.model.Email_remind_appendix;

public interface Email_remind_appendixDao {
	
	/**
	 * 添加邮件附件
	 * @param era 邮件附件实体类对象
	 * @return 添加是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean add(Email_remind_appendix era);
	
	/**
	 * 根据email_id删除附件
	 * @param email_id 邮件编号
	 * @return 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean deleteByEmailId(final long email_id);
	
	/**
	 * 根据email_id返回邮件附件列表
	 * @param email_id 邮件编号
	 * @return 山大威海JoeyK
	 */
	public List<Email_remind_appendix> getListByEmailId(final long email_id);
}
