package top.jhechem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.web.biz.TaskBiz;

import javax.ws.rs.QueryParam;

@Controller
@RequestMapping("task")
@ResponseBody
public class TaskController {

    @Autowired
    private TaskBiz taskBiz;

    @RequestMapping("holiday")
    public Response setHoliday(@QueryParam("date") String date,
                               @QueryParam("flag") boolean isHoliday) {
        taskBiz.putDateHoliday(date, isHoliday);
        return Response.ok();
    }

    @RequestMapping("work_time")
    public Response setWorkTime(@QueryParam("start") String start,
                                @QueryParam("end") String end) {
        taskBiz.putWorkDayTime(start, end);
        return Response.ok();
    }
}
