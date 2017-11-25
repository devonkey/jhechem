package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.web.BaseController;
import top.jhechem.web.mail.SimpleMailSender;
import top.jhechem.web.pojo.MailRequest;

import javax.annotation.Resource;

/**
 * 邮件服务
 * Created by wuqiang on 2017/11/25.
 */
@Controller
@RequestMapping("mail")
@ResponseBody
public class MailController extends BaseController {

    @Resource
    private SimpleMailSender sender;

    @RequestMapping(value = "send", method = RequestMethod.PUT)
    public Response send(@RequestBody MailRequest request) {
        sender.sendWithAttachment(request);
        return Response.ok();
    }
}
