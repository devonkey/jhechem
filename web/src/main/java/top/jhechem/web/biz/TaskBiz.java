package top.jhechem.web.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import top.jhechem.web.support.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import static top.jhechem.web.constant.Const.REDIS_HOLIDAY_PREFIX;

@Component
public class TaskBiz {

    private static String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private static String baseUrl = "http://www.easybots.cn/api/holiday.php";
    private static Logger logger = LoggerFactory.getLogger(TaskBiz.class);

    @Autowired
    @Qualifier("loginJedisPool")
    private JedisPool pool;

    public List<String> initHolidayInfo(int year) {
        List<String> holidays = new ArrayList<>();
        for (String month : months) {
            String m = year + month;
            String result = HttpUtils.get(baseUrl + "?m=" + m);
            holidays.add(result);
            logger.info("初始化{}年{}月的假日信息为{}", year, month, result);
            try (Jedis jedis = pool.getResource()) {
                jedis.set(REDIS_HOLIDAY_PREFIX + m, result);
            }
        }
        return holidays;
    }
}
