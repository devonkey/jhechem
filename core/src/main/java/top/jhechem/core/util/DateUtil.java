package top.jhechem.core.util;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static top.jhechem.core.constant.Const.DEFAULT_MOUTH_FORMAT;
import static top.jhechem.core.constant.Const.NUMBER_THOUSAND;

/**
 * 日期类工具
 * Created by wuqiang on 2017/8/26.
 */
public class DateUtil {

    private static final Log LOGGER = LogFactory.getLog(DateUtil.class);

    public static long getCurrentMonthStartSecond() {
        DateFormat format = new SimpleDateFormat(DEFAULT_MOUTH_FORMAT);
        try {
            return format.parse(format.format(new Date())).getTime() / NUMBER_THOUSAND;
        } catch (ParseException e) {
            LOGGER.error(e);
        }
        return 0;
    }

    public static long getCurrentSecond() {
        return System.currentTimeMillis() / NUMBER_THOUSAND;
    }
}
