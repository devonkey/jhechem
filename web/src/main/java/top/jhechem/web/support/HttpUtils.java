package top.jhechem.web.support;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.function.Function;

public class HttpUtils {

    private static Function<HttpUriRequest, String> excutor = (HttpUriRequest request) -> {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = client.execute(request);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                return EntityUtils.toString(responseEntity, Charset.defaultCharset());
            } else {
                throw new RuntimeException(request.getURI().getPath() + " 请求失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("http 请求异常", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (Exception e) {
                throw new RuntimeException("http 请求异常", e);
            }
        }
    };


    /**
     * post请求（用于请求json格式的参数）
     */
    public static String doPost(String url, String json) {

        StringEntity entity = new StringEntity(json, Charset.defaultCharset());

        // 创建httpPost
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setEntity(entity);
        return excutor.apply(httpPost);

    }

    public static String get(String url) {
        return excutor.apply(new HttpGet(url));
    }
}
