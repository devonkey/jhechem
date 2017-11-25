package top.jhechem.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 封装请求类
 * Created by wuqiang on 2017/11/25.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailRequest {
    private String recipient;
    private String subject;
    private String content;
    private String attachment;
}
