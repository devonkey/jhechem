package top.jhechem.web.filter;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问时间记录
 *
 * @author lc
 */
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Log LOG = LogFactory
            .getLog(ExecuteTimeInterceptor.class);

    private Long show = 500L;

    private      Boolean enable       = false;
    private static final String  SLOW_LOG_KEY = "SLOW_LOG_KEY";


    public ExecuteTimeInterceptor(Long show, Boolean enable) {
        this.show = show;
        this.enable = enable;
        LOG.error("慢日志记录 {} ms,是否开启 {}", show, enable);
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(SLOW_LOG_KEY, System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        Long start = (Long) request.getAttribute(SLOW_LOG_KEY);

        long use = System.currentTimeMillis() - start;

        if (enable) {
            if(use > show){
                LOG.error("request {} use {} ms {}", request.getRequestURI(), use, use > show ? "[slow]" : "");

            }
        }
        super.afterCompletion(request, response, handler, ex);
    }

}
