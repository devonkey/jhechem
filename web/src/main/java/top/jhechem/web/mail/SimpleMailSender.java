package top.jhechem.web.mail;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import top.jhechem.web.pojo.MailRequest;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.File;
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
     * @param username 发送邮件的用户名(地址)，并以此解析SMTP服务器地址
     * @param password 发送邮件的密码
     */
    public SimpleMailSender(final String username, final String password,
                            final String host, final String port) {
        //通过邮箱地址解析出smtp服务器，对大多数邮箱都管用
        init(username, password, host, port);
    }


    /**
     * 初始化
     *
     * @param username     发送邮件的用户名(地址)
     * @param password     密码
     * @param smtpHostName SMTP主机地址
     */
    private void init(String username, String password, String smtpHostName, String port) {
        // 初始化props
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtpHostName);

        props.setProperty("mail.smtp.host", smtpHostName);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", port);
        props.setProperty("mail.smtp.socketFactory.port", port);
        props.setProperty("mail.smtp.auth", "true");
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

}
