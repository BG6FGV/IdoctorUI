package com.xx.controller;

import com.xx.entity.Yuyue;
import com.xx.service.IYuyueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value = "/yuyue", tags = "用户预约挂号接口")
@RestController
@RequestMapping("/yuyue")
@CrossOrigin
public class YuyueController {

    @Autowired
    private IYuyueService yuyueService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @ApiOperation(value = "添加预约到队列", notes = "添加预约到队列")
    @PostMapping("/add")
    public int addYuyue(Yuyue yuyue) {
        yuyue.setCreateTime(sdf.format(new Date()));
        return yuyueService.add(yuyue);
    }

    @ApiOperation(value = "多条件查询预约记录", notes = "多条件查询预约记录")
    @PostMapping("/getByIf")
    public List<Yuyue> getByIf(Yuyue yuyue) {
        return yuyueService.getByIf(yuyue);
    }

    @ApiOperation(value = "取消预约", notes = "取消预约")
    @PostMapping("/cancel")
    public int cancelYuyue(Yuyue yuyue) {
        return yuyueService.cancelYuyue(yuyue);
    }

    @ApiOperation(value = "删除预约记录", notes = "删除预约记录")
    @GetMapping("/delete")
    public int delete(int id) {
        return yuyueService.delete(id);
    }
}
