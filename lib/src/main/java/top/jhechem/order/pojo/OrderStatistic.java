package top.jhechem.order.pojo;

import lombok.Getter;
import lombok.Setter;
import top.jhechem.core.base.Base;

/**
 * 订单统计
 * Created by wuqiang on 2017/8/24.
 */
@Setter
@Getter
public class OrderStatistic extends Base{

    public OrderStatistic() {
    }

    public OrderStatistic(String grain) {
        this.grain = grain;
        this.lirun = 0;
    }

    private String grain;   //粒度（默认每天）
    private Integer lirun;  //利润和

}
