package com.shanda.linglong.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shanda.linglong.model.Email_remind;
import com.shanda.linglong.model.Email_remind_appendix;
import com.shanda.linglong.model.Email_send;

@Component("emailService")
public interface EmailService {
	
	/**
	 * 添加邮件附件
	 * @param era 邮件附件实体类对象
	 * @return 添加是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean addAppendixs(Email_remind_appendix era);
	
	/**
	 * 根据邮件编号删除邮件附件
	 * @param email_id 邮件编号
	 * @return 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delAppendixByEmailId(long email_id);
	
	/**
	 * 添加右键发送
	 * @param er 邮件发送实体类对象
	 * @return 邮件编号
	 * @author 山大威海JoeyK
	 */
	public long addEmail(Email_remind er);
	
	/**
	 * 根据邮件编号删除邮件发送
	 * @param email_id 邮件编号
	 * @return 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delEmail(long email_id);
	
	/**
	 * 添加邮件收件人
	 * @param es 邮件收件人实体类对象
	 * @return 添加是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean addSend(Email_send es);
	
	/**
	 * 根据邮件编号删除邮件收件人
	 * @param email_id 邮件编号 
	 * @return 删除是否成功标志
	 * @author 山大威海JoeyK
	 */
	public boolean delSendByEmailId(long email_id);
	
	/**
	 * 获取邮件发送列表
	 * @return 邮件发送列表
	 * @author 山大威海JoeyK
	 */
	public List<Email_remind> getList();
	
	/**
	 * 根据邮件编号获取邮件附件列表
	 * @param email_id 邮件编号
	 * @return 邮件附件列表
	 * @author 山大威海JoeyK
	 */
	public List<Email_remind_appendix> getLsitByEmailId(long email_id);
	
	/**
	 * 根据邮件编号获取邮件收件人列表
	 * @param email_id 邮件编号
	 * @return 邮件收件人列表
	 * @author 山大威海JoeyK
	 */
	public List<Email_send> getListByEID(long email_id);

}
