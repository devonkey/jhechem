package top.jhechem.web.converter;

import cn.idongjia.common.context.DongjiaContext;
import cn.idongjia.log.LoggerName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

/**
 * Created by renxianlong on 16/11/1.
 */
public class CustomerMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    private Logger interfaceLogger = LoggerFactory.getLogger(LoggerName.INTERFACE);

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        StringBuilder logRecMsg = new StringBuilder().append("Handle request end, response ");
        logRecMsg.append(object);
        interfaceLogger.info(logRecMsg.toString(), DongjiaContext.getUniqueID());
        super.writeInternal(object, outputMessage);
    }
}
