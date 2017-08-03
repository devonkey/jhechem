package top.jhechem.core.base;

import cn.idongjia.util.Utils;
import lombok.Setter;
import top.jhechem.core.constant.Query;

@Setter
@SuppressWarnings("unused")
public class BaseSearch extends Base {

    private Integer page;
    private Integer limit;
    private String orderBy;
    private Long start;
    private Long end;

    public void setDefaultOrderBy(String orderBy) {
        if (this.orderBy == null) {
            setOrderBy(orderBy);
        }
    }

    /**
     * 转换模糊查询字符串,如果是以'%'开头或者'%'结尾的不用转换
     *
     * @param str 要模糊查询的字符串
     * @return 模糊匹配规则
     */
    public static String likeStr(String str) {
        if (Utils.isEmpty(str)) {
            return null;
        }
        if (str.matches("(^%.+)|(.+%$)")) {
            return str;
        }
        return "%" + str + "%";
    }

    public Integer getPage() {
        return page == null ? Query.DEFAULT_PAGE : page;
    }

    public Integer getLimit() {
        return limit == null ? Query.DEFAULT_LIMIT : limit;
    }

    public String getOrderBy() {
        return orderBy == null ? Query.DEFAULT_ORDERBY : orderBy;
    }

    public Long getStart() {
        return start;
    }

    public Long getEnd() {
        return end;
    }
}

