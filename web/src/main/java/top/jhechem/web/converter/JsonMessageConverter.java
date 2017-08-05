/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.jhechem.web.converter;

import cn.idongjia.common.context.DongjiaContext;
import cn.idongjia.log.LoggerName;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Implementation of {@link org.springframework.http.converter.HttpMessageConverter HttpMessageConverter} that
 * can read and write JSON using <a href="http://jackson.codehaus.org/">Jackson 2.x's</a> {@link ObjectMapper}.
 * <p>
 * <p>This converter can be used to bind to typed beans, or untyped {@link java.util.HashMap HashMap} instances.
 * <p>
 * <p>By default, this converter supports {@code application/json} and {@code application/*+json}.
 * This can be overridden by setting the {@link #setSupportedMediaTypes supportedMediaTypes} property.
 * <p>
 * <p>The default constructor uses the default configuration provided by {@link Jackson2ObjectMapperBuilder}.
 * <p>
 * <p>Compatible with Jackson 2.1 and higher.
 *
 * @author Arjen Poutsma
 * @author Keith Donald
 * @author Rossen Stoyanchev
 * @author Juergen Hoeller
 * @author Sebastien Deleuze
 * @since 3.1.2
 */
public class JsonMessageConverter extends AbstractJsonMessageConverter {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    // Check for Jackson 2.3's overloaded canDeserialize/canSerialize variants with cause reference
    private static final boolean jackson23Available = ClassUtils.hasMethod(ObjectMapper.class,
            "canDeserialize", JavaType.class, AtomicReference.class);

    private Logger interfaceLogger = LoggerFactory.getLogger(LoggerName.INTERFACE);
    private String jsonPrefix;


    /**
     * Construct a new {@link JsonMessageConverter} using default configuration
     * provided by {@link Jackson2ObjectMapperBuilder}.
     */
    public JsonMessageConverter() {
        this(Jackson2ObjectMapperBuilder.json().build());
    }

    /**
     * Construct a new {@link JsonMessageConverter} with a custom {@link ObjectMapper}.
     * You can use {@link Jackson2ObjectMapperBuilder} to build it easily.
     *
     * @see Jackson2ObjectMapperBuilder#json()
     */
    public JsonMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper, new MediaType("application", "json", DEFAULT_CHARSET), new MediaType("application", "*+json", DEFAULT_CHARSET));
    }

    /**
     * Specify a custom prefix to use for this view's JSON output.
     * Default is none.
     *
     * @see #setPrefixJson
     */
    public void setJsonPrefix(String jsonPrefix) {
        this.jsonPrefix = jsonPrefix;
    }

    /**
     * Indicate whether the JSON output by this view should be prefixed with "{} &&". Default is false.
     * <p>Prefixing the JSON string in this manner is used to help prevent JSON Hijacking.
     * The prefix renders the string syntactically invalid as a script so that it cannot be hijacked.
     * This prefix does not affect the evaluation of JSON, but if JSON validation is performed on the
     * string, the prefix would need to be ignored.
     *
     * @see #setJsonPrefix
     */
    public void setPrefixJson(boolean prefixJson) {
        this.jsonPrefix = (prefixJson ? "{} && " : null);
    }


    @Override
    protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
        if (this.jsonPrefix != null) {
            generator.writeRaw(this.jsonPrefix);
        }
        String jsonpFunction = (object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
        if (jsonpFunction != null) {
            generator.writeRaw(jsonpFunction + "(");
        }
    }

    @Override
    protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
        String jsonpFunction = (object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
        if (jsonpFunction != null) {
            generator.writeRaw(");");
        }
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
        StringBuilder logRecMsg = new StringBuilder().append("Handle request end, response ");
        logRecMsg.append(object);
        interfaceLogger.info(logRecMsg.toString(), DongjiaContext.getUniqueID());
        super.writeInternal(object, outputMessage);
    }

    @Override
    public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
        if (!jackson23Available || !logger.isWarnEnabled()) {
            return (this.objectMapper.canSerialize(clazz) && canWrite(mediaType));
        }
        AtomicReference<Throwable> causeRef = new AtomicReference<Throwable>();
        if (this.objectMapper.canSerialize(clazz, causeRef) && canWrite(mediaType)) {
            return true;
        }
        logger.error("not excepted.");
        return false;
    }

    @Override
    public void write(Object t, Type type, MediaType contentType, HttpOutputMessage
            outputMessage) throws IOException, HttpMessageNotWritableException {
        final HttpHeaders headers = outputMessage.getHeaders();
        if (headers.getContentType() == null) {
            MediaType contentTypeToUse = contentType;
            if (contentType == null || contentType.isWildcardType() || contentType.isWildcardSubtype()) {
                contentTypeToUse = getDefaultContentType(t);
            }
            if (contentTypeToUse != null) {
                headers.setContentType(contentTypeToUse);
            }
        }
        if (headers.getContentLength() == -1) {
            Long contentLength = getContentLength(t, headers.getContentType());
            if (contentLength != null) {
                headers.setContentLength(contentLength);
            }
        }

        if (outputMessage instanceof StreamingHttpOutputMessage) {
            StreamingHttpOutputMessage streamingOutputMessage =
                    (StreamingHttpOutputMessage) outputMessage;
            streamingOutputMessage.setBody(new StreamingHttpOutputMessage.Body() {
                @Override
                public void writeTo(final OutputStream outputStream) throws IOException {
                    writeInternal(t, new HttpOutputMessage() {
                        @Override
                        public OutputStream getBody() throws IOException {
                            return outputStream;
                        }

                        @Override
                        public HttpHeaders getHeaders() {
                            return headers;
                        }
                    });
                }
            });
        } else {
            writeInternal(t, outputMessage);
            outputMessage.getBody().flush();
        }
    }
}
