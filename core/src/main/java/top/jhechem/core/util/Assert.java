package top.jhechem.core.util;

import top.jhechem.core.ApiException;
import top.jhechem.core.Response;

/**
 * 断言
 * Created by wuqiang on 2017/7/31.
 */
public class Assert {

    public static void assertNotNull(Object o, Response response) {
        if (o == null) {
            throw new ApiException(response);
        }
    }

    public static void assertTrue(boolean res, Response response) {
        assertFalse(!res, response);
    }

    public static void assertFalse(boolean res, Response response) {
        if (res) {
            throw new ApiException(response);
        }
    }

    public static void assertNull(Object o, Response response) {
        if (o != null) {
            throw new ApiException(response);
        }
    }

}
