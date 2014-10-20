package com.shanda.linglong.util;

import java.io.IOException;

import java.io.InputStream;

import java.util.Properties;

import javax.mail.MessagingException;


/**

 * 封装和邮件相关的帐户信息

 *

 * <pre>

 * 属性文件：

 * host=

 * username=

 * password=

 * from=

 * </pre>

 *

 * @author 李赵伟 Create: 2007-12-20

 */

public class User {

    private String host; // smtp服务器

    private String username; // 用户名

    private String password; // 密码

    private String from; // 发件人地址

    private static final String KEY_HOST = "host";

    private static final String KEY_USERNAME = "username";

    private static final String KEY_PASSWORD = "password";

    private static final String KEY_FROM = "from";

    public User(String host, String username, String password)

           throws MessagingException {

       this(host, username, password, null);

    }

    public User(String host, String username, String password, String from)

           throws MessagingException {

       set(host, username, password, from);

    }

    private void set(String host, String username, String password, String from)

           throws MessagingException {

       if (!check(host, username, password))

           throw new MessagingException("请输入正确的参数！");

 

       setHost(host);

       setUsername(username);

       setPassword(password);

       setFrom(from);

    }

    /**

     * 使用属性文件配置邮件相关的帐户信息

     *

     * @param propertiesFileName

     *            属性文件

     * @throws IOException

     * @throws MessagingException

     */

    public User(String propertiesFileName) throws IOException,

           MessagingException {

       InputStream is = getClass().getResourceAsStream(propertiesFileName);

       readProperties(is);

    }

    /**

     * 使用属性文件配置邮件相关的帐户信息

     *

     * @param propertiesStream

     *            属性文件

     * @throws IOException

     * @throws MessagingException

     */

    public User(InputStream propertiesStream) throws IOException,

           MessagingException {

       readProperties(propertiesStream);

    }

    private void readProperties(InputStream is) throws IOException,

           MessagingException {

       Properties p = new Properties();

       try {

           p.load(is);

       } finally {

           if (null != is)

              is.close();

       }

//       String host = Stringutils.toGBKString(p.getProperty(KEY_HOST),
//
//              Stringutils.ISO8859_1);
//
//       String username = Stringutils.toGBKString(p.getProperty(KEY_USERNAME),
//
//              Stringutils.ISO8859_1);
//
//       String password = Stringutils.toGBKString(p.getProperty(KEY_PASSWORD),
//
//              Stringutils.ISO8859_1);
//
//       String from = Stringutils.toGBKString(p.getProperty(KEY_FROM),
//
//              Stringutils.ISO8859_1);

       set(host, username, password, from);

    }

    private boolean check(String host, String username, String password) {

       if (null != host && 0 != host.trim().length() && null != username

              && 0 != username.trim().length() && null != password

              && 0 != password.trim().length())

           return true;

       else

           return false;

    }

    public String getHost() {

       return host;

    }

    public void setHost(String host) {

       this.host = host;

    }

    public String getUsername() {

       return username;

    }

    public void setUsername(String username) {

       this.username = username;

    }

    public String getPassword() {

       return password;

    }

    public void setPassword(String password) {

       this.password = password;

    }

    public String getFrom() {

       return from;

    }

    public void setFrom(String from) {

//       if (null != from && 0 != from.trim().length())

           this.from = from;

//       else {

//           String a[] = this.host.split("//.");

//           this.from = this.username + "@" + a[1] + "." + a[2];

//       }

    }

}