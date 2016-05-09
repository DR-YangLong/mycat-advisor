package org.apache.mycat.advisor.web.controller.backstage.um;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabPostInfo;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.service.backstage.um.userinfo.UserInfoService;
import org.apache.mycat.advisor.service.backstage.um.usertype.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
@RestController
@RequestMapping("/um/userInfo/")
public class UserInfoController extends BaseController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserTypeService userTypeService;


    @RequestMapping("list")

    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page<Map> page = userInfoService.pageList(param);
        return sucess(page);
    }

    @RequestMapping("findByName")
    public List<Map<String,Object>> findByName(String query) {
        List<Map<String, Object>> list = userInfoService.findListMapByUserName(query);
        return list;
    }

    @RequestMapping("save")
    public ResultMap save(TabUserInfo info) {
        if (userInfoService.save(info)) {
            return success();
        } else {
            return failure("保存操作失败!");
        }
    }
    @RequestMapping("test")
    public ResultMap test(List<TabPostInfo> posts) {


        return success(posts);
    }

    @RequestMapping("init")
    public ResultMap init() {
        Map<String, Object> data = new HashMap<>();
        data.put("userTypes", userTypeService.all());
        return success(data);
    }

    @RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id) {
        TabUserInfo info = userInfoService.get(id);
        Map<String, Object> data = object2map(info);
        data.put("userTypes", userTypeService.all());

        return success(data);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (userInfoService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }

    @RequestMapping("getUserByName")
    public List<Map<String,Object>> getUserByName(String query){
        List<TabUserInfo> userList = userInfoService.getAllByUsername(query);
        List<Map<String,Object>> users = new ArrayList<>();
        for(TabUserInfo userInfo : userList){
            Map<String,Object> temp = new HashMap<>();
            temp.put("id", userInfo.getId());
            temp.put("name", userInfo.getUsername());
            users.add(temp);
        }

        return users;
    }


}
