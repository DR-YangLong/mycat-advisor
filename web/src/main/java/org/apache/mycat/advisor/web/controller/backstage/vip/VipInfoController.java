package org.apache.mycat.advisor.web.controller.backstage.vip;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabVip;
import org.apache.mycat.advisor.service.backstage.vip.vipinfo.VipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
@RestController
@RequestMapping("/vip/info/")
public class VipInfoController extends BaseController {
    @Autowired
    VipInfoService vipInfoService;


    @RequestMapping("list")

    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page page = vipInfoService.pageList(param);
        return sucess(page);
    }

    @RequestMapping("save")
    public ResultMap save(TabVip info) {
        if (vipInfoService.saveOrUpdate(info)) {
            return success();
        } else {
            return failure("保存操作失败!");
        }
    }

    @RequestMapping("init")
    public ResultMap init() {
        return success();
    }

    @RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id,@RequestParam Map<String,Object> param) {
        TabVip vip = vipInfoService.get(id);
        Map<String, Object> data = object2map(vip);
        data.putAll(param);

        return success(data);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (vipInfoService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }


}
