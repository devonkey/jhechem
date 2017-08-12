package top.jhechem.web;


import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.ApiException;
import top.jhechem.core.Response;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.service.FunctionAuthService;
import top.jhechem.web.shiro.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Set;

public abstract class BaseController {

    private static final Log LOGGER = LogFactory.getLog(BaseController.class);

    @Resource
    private FunctionAuthService functionAuthService;

    @ExceptionHandler
    @ResponseBody
    public Response handleClientError(Exception e) {
        if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            return new Response(exception.getCode(), exception.getMsg());
        } else {
            LOGGER.error("未知异常!", e);
            return ExceptionResponse.response("系统错误！");
        }
    }

    protected Integer getAdminId() {
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        return admin == null ? null : admin.getId();
    }

    protected Set<Integer> getRanges() {
        return functionAuthService.getRanges(
                AntPathMatcher.getMatchedAuthPath(), getAdminId());
    }

    protected Set<Integer> getRanges(int adminId) {
        return functionAuthService.getRanges(
                AntPathMatcher.getMatchedAuthPath(), adminId);
    }
}
