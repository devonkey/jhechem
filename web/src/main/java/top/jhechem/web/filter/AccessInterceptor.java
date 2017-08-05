package top.jhechem.web.filter;

import cn.idongjia.common.context.DongjiaContext;
import cn.idongjia.log.LoggerName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.sun.deploy.util.ArrayUtil.arrayToString;
import static org.springframework.util.StringUtils.isEmpty;

public class AccessInterceptor extends HandlerInterceptorAdapter {

    private Logger interfaceLogger = LoggerFactory.getLogger(LoggerName.INTERFACE);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Map<String, String> paramMap = convertMap(request.getParameterMap());
        String path = request.getPathInfo();
        // 添加日志记录请求
        addInterfaceLog(request, paramMap, handler);

        return true;
    }

    //处理接口到达日志
    private void addInterfaceLog(HttpServletRequest request, Map<String, String> paramMap,
                                 Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        StringBuilder logRecMsg = new StringBuilder().append("Receive ")
                .append(method.getDeclaringClass().getSimpleName())
                .append(".").append(method.getName()).append(" request from ");
        logRecMsg.append(request.getRequestURI()).append(", params: ");
        paramMap.forEach((k, v) -> logRecMsg.append(k).append(":").append(v));
        interfaceLogger.info(logRecMsg.toString(), DongjiaContext.getUniqueID());
    }

    private static HashMap<String, String> convertMap(final Map<String, String[]> inputMap) {
        HashMap<String, String> outMap = new HashMap<>();

        if (isEmpty(inputMap)) {
            return outMap;
        }

        inputMap.forEach((k, v) -> outMap.put(k, arrayToString(v)));

        return outMap;
    }
}