package top.jhechem.web.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import top.jhechem.core.util.Utils;
import top.jhechem.web.support.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static top.jhechem.web.constant.Const.REDIS_HOLIDAY_PREFIX;
import static top.jhechem.web.constant.Const.REDIS_WORKDAY_BETWEEN;

@Component
public class TaskBiz {

    private static Logger logger = LoggerFactory.getLogger(TaskBiz.class);

    @Autowired
    @Qualifier("loginJedisPool")
    private JedisPool pool;


    /**
     * 添加特殊假日标记
     *
     * @param date      like 20190720
     * @param isHoliday true 节日， false 工作日
     */
    public void putDateHoliday(String date, boolean isHoliday) {
        String value = isHoliday ? "1" : "0";
        try (Jedis jedis = pool.getResource()) {
            String s = jedis.set(REDIS_HOLIDAY_PREFIX + date, value);
            logger.info("set {} result is {}", date, s);
        }
    }

    /**
     * 添加 工作日开放时间
     *
     * @param start like 0800
     * @param end   like 2000
     */
    public void putWorkDayTime(String start, String end) {
        try (Jedis jedis = pool.getResource()) {
            jedis.del(REDIS_WORKDAY_BETWEEN);
            Long s = jedis.lpush(REDIS_WORKDAY_BETWEEN, start, end);
            logger.info("set {} start:{} end:{} result is {}.",
                    REDIS_WORKDAY_BETWEEN, start, end, s);
        }
    }

    public boolean redisAvailable() {
        final DateFormat holidayFormat = new SimpleDateFormat("yyyyMMdd");

        final Date now = new Date();
        String date = holidayFormat.format(now);
        String dateTag;
        try (Jedis jedis = pool.getResource()) {
            dateTag = jedis.get(REDIS_HOLIDAY_PREFIX + date);
        }

        boolean weekend = DateUtils.isWeekend();
        if (Utils.isEmpty(dateTag)) {
            if (weekend) { //未标记，周末
                return false;
            }
        } else {
            if (Boolean.valueOf(dateTag)) { //标记为假期
                return false;
            }
        }

        //date满足，对照时间
        final DateFormat timeFormat = new SimpleDateFormat("HHmm");
        String time = timeFormat.format(now);
        List<String> timeList;
        try (Jedis jedis = pool.getResource()) {
            timeList = jedis.lrange(REDIS_WORKDAY_BETWEEN, 0, -1);
        }

        if (timeList.size() != 2) {
            logger.error("时间 {} 设置错误", timeList);
            return false;
        }

        return time.compareTo(timeList.get(1)) >= 1 && time.compareTo(timeList.get(0)) <= 1;

    }

}
