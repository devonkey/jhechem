package top.jhechem.web.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 验证
 * Created by wuqiang on 2017/11/25.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailAuthenticator extends Authenticator {

    private String username;
    private String password;

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

}
