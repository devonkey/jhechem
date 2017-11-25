package top.jhechem.web.mail;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import top.jhechem.web.pojo.MailRequest;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * sender
 *
 * @author wuq
 */
public class SimpleMailSender {

    private static final Log LOGGER = LogFactory.getLog(SimpleMailSender.class);

    private final transient Properties props = System.getProperties();

    private transient MailAuthenticator authenticator;

    private transient Session session;

    /**
     * 初始化邮件发送器
     *
     * @param smtpHostName SMTP邮件服务器地址
     * @param username     发送邮件的用户名(地址)
     * @param password     发送邮件的密码
     */
    public SimpleMailSender(final String smtpHostName, final String username,
                            final String password) {
        init(username, password, smtpHostName);
    }

    /**
     * 初始化邮件发送器
     *
     * @param username 发送邮件的用户名(地址)，并以此解析SMTP服务器地址
     * @param password 发送邮件的密码
     */
    public SimpleMailSender(final String username, final String password) {
        //通过邮箱地址解析出smtp服务器，对大多数邮箱都管用
        final String smtpHostName = "smtp." + username.split("@")[1];
        init(username, password, smtpHostName);

    }

    /**
     * 初始化
     *
     * @param username     发送邮件的用户名(地址)
     * @param password     密码
     * @param smtpHostName SMTP主机地址
     */
    private void init(String username, String password, String smtpHostName) {
        // 初始化props
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtpHostName);
        // 验证
        authenticator = new MailAuthenticator(username, password);
        // 创建session
        session = Session.getInstance(props, authenticator);
        session.setDebug(true);
    }

    /**
     * 发送邮件
     *
     * @param recipient 收件人邮箱地址
     * @param subject   邮件主题
     * @param content   邮件内容
     * @throws MessagingException
     */
    public void send(String recipient, String subject, String content)
            throws MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipient));
        // 设置主题
        message.setSubject(subject);
        // 设置邮件内容
        message.setContent(content, "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }

    /**
     * 群发邮件
     *
     * @param recipients 收件人们
     * @param subject    主题
     * @param content    内容
     * @throws AddressException
     * @throws MessagingException
     */
    public void send(List<String> recipients, String subject, String content)
            throws AddressException, MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人们
        final int num = recipients.size();
        InternetAddress[] addresses = new InternetAddress[num];
        for (int i = 0; i < num; i++) {
            addresses[i] = new InternetAddress(recipients.get(i));
        }
        message.setRecipients(Message.RecipientType.TO, addresses);
        // 设置主题
        message.setSubject(subject);
        // 设置邮件内容
        message.setContent(content, "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }


    public void sendWithAttachment(MailRequest request) {

        try {
            File attachmentFile = null;
            String attachmentDesc = null;
            if (request.getAttachment() == null) {
                attachmentDesc = "\n附件名为空";
            } else {
                attachmentFile = new File(request.getAttachment());
                if (!attachmentFile.exists()) {
                    attachmentDesc = "\n附件 " + request.getAttachment() + " 为空";
                }
            }

            if (attachmentDesc != null) {
                request.setContent(request.getContent() + attachmentDesc);
                send(request.getRecipient(), request.getSubject(), request.getContent());
                return;
            }

            String fileName = request.getAttachment().substring(
                    request.getAttachment().lastIndexOf(File.separator) + 1);
            // 创建mime类型邮件
            final MimeMessage message = new MimeMessage(session);

            // 设置发信人
            message.setFrom(new InternetAddress(authenticator.getUsername()));

            // 邮件主题
            message.setSubject(request.getSubject());

            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 添加邮件正文
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(request.getContent(), "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);

            // 添加附件的内容
            BodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFile);
            attachmentBodyPart.setDataHandler(new DataHandler(source));

            //网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定

            //这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码

            //sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();

            //messageBodyPart.setFileName("=?GBK?B?" + enc.encode(attachment.getName().getBytes()) + "?=");

            //MimeUtility.encodeWord可以避免文件名乱码


            attachmentBodyPart.setFileName(MimeUtility.encodeWord(fileName));
            multipart.addBodyPart(attachmentBodyPart);

            // 将multipart对象放到message中
            message.setContent(multipart);
            // 设置收件人
            message.setRecipient(
                    MimeMessage.RecipientType.TO, new InternetAddress(request.getRecipient()));
            // 保存邮件
            message.saveChanges();

            // 发送
            Transport.send(message);

            LOGGER.info("send success!");
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void main(String[] args) {
//        SimpleMailSender sender = new SimpleMailSender("285434532@qq.com","w*q**332335");
        SimpleMailSender sender = new SimpleMailSender("jhechem_data@163.com","jhechem123");
//        SimpleMailSender sender = new SimpleMailSender("jhechem_data@163.com","^jhechemlI$");
        MailRequest request = new MailRequest("wrqtx@126.com", "234","345", "/Users/wuqiang/workspace/github/jhechem/web/src/main/java/top/jhechem/web/controller/MailController.java");
        sender.sendWithAttachment(request);
    }

}
