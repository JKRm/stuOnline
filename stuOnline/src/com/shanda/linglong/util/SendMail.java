package com.shanda.linglong.util;

import java.util.Arrays;

import java.util.Date;

import java.util.Properties;

import javax.activation.DataHandler;

import javax.activation.DataSource;

import javax.activation.FileDataSource;

import javax.mail.Address;

import javax.mail.Authenticator;

import javax.mail.BodyPart;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.Multipart;

import javax.mail.NoSuchProviderException;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.AddressException;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;


/**

 * �ʼ����ͳ���

 * @author ����ΰ Create: 2007-12-19

 */

public class SendMail {

    private Session session;        //�Ự

    private Transport transport;    //�����ʼ�

    private User user;                 //�ʼ���ص��ʻ���Ϣ

    private MailAddress mailAddress;   //�ռ��˵�ַ

    private MailBody mailBody;         //�ʼ�����

    private final String MAIL_SMTP_HOST = "mail.smtp.host";

    private final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    public SendMail(User user) {

       this.user = user;

       init();

    }

    /**

     * ��ʼ��<code> Session, Transport </code>

     */

    private void init() {

       Authenticator auth = new Authenticator() {

           protected PasswordAuthentication getPasswordAuthentication() {

              return new PasswordAuthentication(user.getUsername(), user

                     .getPassword());

           }

       };

       Properties props = new Properties();

       // ���÷����ʼ����ʼ������������ԣ�����ʹ�����׵�smtp��������

       props.put(MAIL_SMTP_HOST, user.getHost());

       // ��Ҫ������Ȩ��Ҳ�����л����������У�飬��������ͨ����֤��һ��Ҫ����һ����

       props.put(MAIL_SMTP_AUTH, "true");

       // �øո����úõ�props���󹹽�һ��session

       session = Session.getDefaultInstance(props, auth);

       try {

           // �����ʼ�

           transport = session.getTransport("smtp");

           // ���ӷ�����������

           transport.connect(user.getHost(), user.getUsername(), user

                  .getPassword());

       } catch (NoSuchProviderException e) {

           e.printStackTrace();

       } catch (MessagingException e) {

           e.printStackTrace();

       }
       
       System.out.println("�� " + user.getHost() + " �ɹ������Ự");

    }

    /**

     * �����ռ��˵�ַ

     *

     * @param mailAddress

     */

    public void setAddress(MailAddress mailAddress) {

       this.mailAddress = mailAddress;

    }

    /**

     * �����ʼ�����

     *

     * @param mailBody

     */

    public void setMailBody(MailBody mailBody) {

       this.mailBody = mailBody;

    }

    /**

     * �����ʼ�������

     *

     * @return

     * @throws AddressException

     * @throws MessagingException

     */

    private Message createMessage() throws AddressException, MessagingException {

       // ��sessionΪ����������Ϣ����

       MimeMessage message = new MimeMessage(session);

       // ���ط����˵�ַ

       message.setFrom(new InternetAddress(user.getFrom()));

       message.setSentDate(new Date());

       // �����ռ��˵�ַ

       message.addRecipients(Message.RecipientType.TO, getAddress(mailAddress

              .getTo()));

       if (mailAddress.isHasCC())

           message.addRecipients(Message.RecipientType.CC,

                  getAddress(mailAddress.getCc()));

       // ���ر���

       message.setSubject(mailBody.getSubject());

       if (mailBody.isContentFlag() || mailBody.isAffixFlag()) {

           // ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���

           Multipart multipart = new MimeMultipart();

           if (mailBody.isContentFlag()) {

              // �����ʼ����ı�����

              MimeBodyPart contentPart = new MimeBodyPart();

              if (mailBody.isMimeContent())

                  contentPart.setContent(mailBody.getContent(),

                         "text/html;charset=GBK");

              else

                  contentPart.setText(mailBody.getContent());

              multipart.addBodyPart(contentPart);

           }
           

           if (mailBody.isAffixFlag()) {

              // ��Ӹ���
        	   
        	  for(int i=0;i<mailBody.getAffix().length;i++){

              BodyPart affixBody = new MimeBodyPart();

              DataSource source = new FileDataSource(mailBody.getAffix()[i]);

              // ��Ӹ���������

              affixBody.setDataHandler(new DataHandler(source));

              // ��Ӹ����ı����������Ҫ��ͨ�������Base64�����ת�����Ա�֤���

              // ���ĸ����������ڷ���ʱ����������

              sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();

              String fileName = "=?GBK?B?"

                     + enc.encode(mailBody.getAffixName()[i].getBytes()) + "?=";

              affixBody.setFileName(fileName);

              multipart.addBodyPart(affixBody);
              
           }

           }

           // ��multipart����ŵ�message��

           message.setContent(multipart);

       }

       // �����ʼ�

       message.saveChanges();

       return message;

    }

    /**

     * �����ʼ����������ʼ����ġ���1��������

     *

     * @param debug

     *            ��������

     */

    public void send(boolean debug) {

       // ������������ڷ����ʼ��Ĺ�������console����ʾ������Ϣ��������ʹ

       // �ã�������ڿ���̨��console)�Ͽ��������ʼ��Ĺ��̣�

       session.setDebug(debug);

       try {

           Message message = createMessage();

           transport.sendMessage(message, message.getAllRecipients());

       } catch (AddressException e) {

           e.printStackTrace();

       } catch (MessagingException e) {

           e.printStackTrace();

       }
     

       System.out.println("/n----------------------------------------------------------");

       System.out.println("- �ʼ��ɹ����ͣ�");

       System.out.println("- TO : " + Arrays.toString(mailAddress.getTo()));

       if (mailAddress.isHasCC())

    	   System.out.println("- CC : " + Arrays.toString(mailAddress.getCc()));

       System.out.println("----------------------------------------------------------/n");

    }

    /**

     * �ر���Դ

     *

     * @throws MessagingException

     */

    public void close() throws MessagingException {

       if (null != transport)

           transport.close();

    }

    public Address[] getAddress(String[] address) throws AddressException {

       Address[] addrs = new InternetAddress[address.length];

       for (int i = 0; i < address.length; i++)

           addrs[i] = new InternetAddress(address[i]);

       return addrs;

    }

    /**

     * ����

     */

    public static void main(String[] args) {

       String host = "smtp.163.com";

       String username = "linglonget";

       String password = "linglong";

       String from = "linglonget@163.com";

       String[] to = {"sacco123@126.com"};

       // String cc = null;

       String subject = "����";

       String content = "<a href=http://www.baidu.com>baidu</a>";

       boolean mimeContent = true;

       String[] affix = {"c:/cloud.ppt","c:/һ.doc"};

       String[] affixName = {"cloud.ppt","һ.doc"};

       boolean debug = false;

       // String userFile = "user.properties";

       // String addressFile = "mailaddress.properties";

       SendMail mail = null;

       try {

           try {

              User user = new User(host, username, password, from);

              MailAddress mailAddress = new MailAddress(to);

              // User user = new User(userFile);

              // MailAddress mailAddress = new MailAddress(SendMail.class

              // .getResourceAsStream(addressFile));

              MailBody mailBody = new MailBody(subject, content, mimeContent,

                     affix, affixName);

              mail = new SendMail(user);

              // for (int i = 0; i < 5; i++) {

              // ���÷����˵�ַ���ռ��˵�ַ���ʼ�����

              mail.setAddress(mailAddress);

              // ����Ҫ���͸�����λ�úͱ���

              mail.setMailBody(mailBody);

              // ����smtp�������Լ�������ʺź�����

              mail.send(debug);

              // try {

              // Thread.sleep(1 * 1000);

              // } catch (InterruptedException e) {

              // e.printStackTrace();

              // }

              // mailBody = new MailBody(subject + "_" + (i + 1), content);

              // }

           } finally {

              if (null != mail)

                  mail.close();

           }

       } catch (AddressException e) {

           e.printStackTrace();

       } catch (MessagingException e) {

           e.printStackTrace();

           // } catch (IOException e) {

           // e.printStackTrace();

       }

    }

}