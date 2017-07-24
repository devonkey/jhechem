package top.jhechem.web;


import cn.idongjia.exception.ApiException;
import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {

    private static final Log LOGGER = LogFactory.getLog(BaseController.class);

    @ExceptionHandler
    @ResponseBody
    public Response handleClientError(Exception e) {
        if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            return new Response(exception.getCode(), exception.getMsg());
        } else {
            LOGGER.error("未知异常!", e);
            return new Response(Response.FAIL_CODE, Response.FAIL_MSG);
        }
    }

}
