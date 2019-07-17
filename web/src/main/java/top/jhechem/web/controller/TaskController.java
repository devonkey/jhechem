package top.jhechem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.web.biz.TaskBiz;

import java.util.List;

@Controller
@RequestMapping("task")
@ResponseBody
public class TaskController {

    @Autowired
    private TaskBiz taskBiz;

    @RequestMapping("holidays/{year:\\d+}")
    public List<String> initHolidayInfo(@PathVariable("year") int year) {
        return taskBiz.initHolidayInfo(year);
    }
}
