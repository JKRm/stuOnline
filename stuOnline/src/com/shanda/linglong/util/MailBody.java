package com.shanda.linglong.util;

import java.util.List;

/**

 * ��װ�ʼ����ݺ�һ����������

 *

 * @author ����ΰ Create: 2007-12-20

 */

public class MailBody {

    private String[] affix; // ������ַ

    private String[] affixName; // ��������

    private String subject; // �ʼ�����

    private String content; // �ʼ�����

    private boolean mimeContent; // MIME�ʼ�����

    private boolean affixFlag; // ȷ�����ʼ��Ƿ��������

    private boolean contentFlag; // ȷ�����ʼ��Ƿ��������

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

     * ���ø�������������

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
//              setAffixName("����");

           setAffixFlag(true);

       }

    }

    /**

     * �ж��ʼ������Ƿ�ΪMIME����

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