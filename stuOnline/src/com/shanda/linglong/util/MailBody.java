package com.shanda.linglong.util;

import java.util.List;

/**

 * 封装邮件内容和一个附件内容

 *

 * @author 李赵伟 Create: 2007-12-20

 */

public class MailBody {

    private String[] affix; // 附件地址

    private String[] affixName; // 附件名称

    private String subject; // 邮件标题

    private String content; // 邮件内容

    private boolean mimeContent; // MIME邮件内容

    private boolean affixFlag; // 确定该邮件是否包含附件

    private boolean contentFlag; // 确定该邮件是否包含正文

    public MailBody(String subject) {

       this(subject, null, false, null, null);

    }

    public MailBody(String subject, String content, boolean mimeContent) {

       this(subject, content, mimeContent, null, null);

    }

    public MailBody(String subject, String content, boolean mimeContent,

    		String[] affix, String[] affixName) {

       setSubject(subject);

       setContent(content);

       setMimeContent(mimeContent);

       setAffix(affix, affixName);

    }

    public String[] getAffix() {

       return affix;

    }

    /**

     * 设置附件及附件名称

     *

     * @param affix

     * @param affixName

     */

    public void setAffix(String[] affix, String[] affixName) {

       if (null != affix && 0 != affix.length) {

           this.affix = affix;

           if (null != affixName && 0 != affixName.length)

              setAffixName(affixName);

//           else
//
//              setAffixName("附件");

           setAffixFlag(true);

       }

    }

    /**

     * 判断邮件内容是否为MIME类型

     *

     * @return

     */

    public boolean isMimeContent() {

       return mimeContent;

    }

    public void setMimeContent(boolean mimeContent) {

       this.mimeContent = mimeContent;

    }

    public String[] getAffixName() {

       return affixName;

    }

    private void setAffixName(String[] affixName) {

       this.affixName = affixName;

    }

    public String getSubject() {

       return subject;

    }

    public void setSubject(String subject) {

       if (null != subject && 0 != subject.trim().length())

           this.subject = subject;

       else

           this.subject = "";

    }

    public String getContent() {

       return content;

    }

    public void setContent(String content) {

       if (null != content && 0 != content.trim().length()) {

           this.content = content;

           setContentFlag(true);

       }

    }

    public boolean isAffixFlag() {

       return affixFlag;

    }

    public void setAffixFlag(boolean affixFlag) {

       this.affixFlag = affixFlag;

    }

    public boolean isContentFlag() {

       return contentFlag;

    }

    public void setContentFlag(boolean contentFlag) {

       this.contentFlag = contentFlag;

    }

}