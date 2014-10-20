package com.shanda.linglong.util;

import java.io.IOException;

import java.io.InputStream;

import java.util.Properties;

import javax.mail.internet.AddressException;

/**

 * ��װ�ռ��˵�ַ

 *

 * <pre>

 * �����ļ���

 * to=

 * cc=

 *

 * �ʼ���ַʹ�á�,���ָ�

 * </pre>

 *

 * @author ����ΰ Create: 2007-12-20

 */

public class MailAddress {

    private String[] to; // �ռ��˵�ַ

    private String[] cc; // �����˵�ַ

    private boolean hasCC; // ��Ǹ��ʼ��Ƿ����CC

    private static final String KEY_TO = "to";

    private static final String KEY_CC = "cc";

    public MailAddress(String to) throws AddressException {

       this(new String[] { to }, null);

    }

    public MailAddress(String to[]) throws AddressException {

       this(to, null);

    }

    public MailAddress(String to, String cc) throws AddressException {

       this(new String[] { to }, new String[] { cc });

    }

    public MailAddress(String[] to, String[] cc) throws AddressException {

       set(to, cc);

    }

    private void set(String[] to, String[] cc) throws AddressException {

       if (!check(to))

           throw new AddressException("û���ռ��˵�ַ��");

      

       setTo(to);

       setCc(cc);

    }

    /**

     * ʹ�������ļ������ռ��˵�ַ

     *

     * @param propertiesFile

     * @throws IOException

     * @throws AddressException

     */

    public MailAddress(InputStream propertiesFile) throws IOException,

           AddressException {

       readProperties(propertiesFile);

    }

    private void readProperties(InputStream is) throws IOException,

           AddressException {

       Properties p = new Properties();

       try {

           p.load(is);

       } finally {

           if (null != is)

              is.close();

       }
       

//       String to = Stringutils.toGBKString(p.getProperty(KEY_TO),
//
//              Stringutils.ISO8859_1);
//
//       String cc = Stringutils.toGBKString(p.getProperty(KEY_CC),
//
//              Stringutils.ISO8859_1);
       
       String cc = p.getProperty(KEY_CC);
       
       String to = p.getProperty(KEY_TO);

       if (null != cc && 0 != cc.trim().length())

           set(to.split(","), cc.split(","));

       else

           set(to.split(","), null);

    }

    private boolean check(String[] to) {

       if (null == to || 0 == to.length)

           return false;

      

       String s;

       for (int i = 0; i < to.length; i++) {

           s = to[i];

           if (null == s || 0 == s.trim().length())

              return false;

       }

       return true;

    }

    public String[] getTo() {

       return to;

    }

    public void setTo(String[] to) {

       this.to = to;

    }

    public String[] getCc() {

       return cc;

    }

    public void setCc(String[] cc) {

       if (null != cc && 0 != cc.length) {

           this.cc = cc;

           setHasCC(true);

       }

    }

    public boolean isHasCC() {

       return hasCC;

    }

    private void setHasCC(boolean hasCC) {

       this.hasCC = hasCC;

    }

}