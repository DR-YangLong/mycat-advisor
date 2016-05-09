package org.apache.mycat.advisor.service.app.order.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.persistence.dao.TabOrderExtendMapper;
import org.apache.mycat.advisor.persistence.dao.TabOrderMapper;
import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.persistence.model.TabOrderExtend;
import org.apache.mycat.advisor.service.app.order.ApiOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by cjl on 2016/4/25.
 */
@Service
public class ApiOrderServiceImpl implements ApiOrderService {

    @Autowired
    TabOrderMapper orderMapper;
    @Autowired
    TabOrderExtendMapper extendMapper;


    @Override
    public TabOrder newOrder(Map<String, String> orderMap) throws ParseException {

        String type = orderMap.get("type");
        TabOrder order = null;
        if ("0".equals(type)) {
            order = createSingleOrder(orderMap, type);
        } else if ("1".equals(type)) {
            order = createCustomOrder(orderMap, type);
        }





        return order;
    }

    private TabOrder createCustomOrder(Map<String, String> orderMap, String type) {
        String beginDate = orderMap.get("beginDate");
        String endDate = orderMap.get("endDate");
        String sceneDay = orderMap.get("sceneDay");
        String onlineDay = orderMap.get("onlineDay");
        String skill = orderMap.get("skill");
        String services = orderMap.get("services");
        //skill.language  skill.platform  skill.db  skill.other  services
        if (!verify(type, beginDate, endDate, sceneDay, skill, services,onlineDay)) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(skill);
        String language = jsonObject.getJSONArray("language").toJSONString();
        String platform = jsonObject.getJSONArray("platform").toJSONString();
        String db = jsonObject.getJSONArray("db").toJSONString();
        String other = jsonObject.getJSONArray("other").toJSONString();

        long createTime = System.currentTimeMillis();
        //创建一个新订单
        TabOrder order = newOrder(2L, createTime);
        //插入订单信息

        saveExtend(type, beginDate, endDate, sceneDay, language, platform, db, other,services,order.getId(),onlineDay);
        return order;
    }

    private void saveExtend(String type, String beginDate, String endDate, String sceneDay, String language, String platform, String db, String other, String services, Long id, String onlineDay) {
        TabOrderExtend extend = new TabOrderExtend();
        extend.setServices(services);
        extend.setSkillLanguage(language);
        extend.setSkillDb(db);
        extend.setSkillOther(other);
        extend.setSkillPlatform(platform);
        extend.setBeginDate(beginDate);
        extend.setEndDate(endDate);
        extend.setOnlineDay(new Integer(onlineDay));
        extend.setSceneDay(new Integer(sceneDay));
        extend.setType(new Integer(type));
        extend.setOrderId(id);

        extendMapper.insert(extend);

    }

    private TabOrder createSingleOrder(Map<String, String> orderMap, String type) throws ParseException {
        String beginDate = orderMap.get("beginDate");
        String endDate = orderMap.get("endDate");
        String sceneDay = orderMap.get("sceneDay");
        String onlineDay = orderMap.get("onlineDay");
        String advisor1 = orderMap.get("advisor1");
        String advisor2 = orderMap.get("advisor2");
        String advisor3 = orderMap.get("advisor3");
        String memo = orderMap.get("memo");


        if (!verify(type, beginDate, endDate, sceneDay, advisor1, advisor2, advisor3,onlineDay)) {
            return null;
        }


        long createTime = System.currentTimeMillis();
        //创建一个新订单
        TabOrder order = newOrder(1L, createTime);
        //插入订单信息

        saveExtend(type, beginDate, endDate, sceneDay, advisor1, advisor2, advisor3, memo,order.getId(),onlineDay);
        return order;
    }

    private boolean verify(String ... strs) {
        for (String str:strs){
            if (StringUtils.isNotEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    private void saveExtend(String type, String beginDate, String endDate, String sceneDay, String advisor1, String advisor2, String advisor3, String memo, Long orderId, String onlineDay) throws ParseException {
        TabOrderExtend extend = new TabOrderExtend();
        extend.setAdvisor1(new Long(advisor1));
        extend.setAdvisor2(new Long(advisor2));
        extend.setAdvisor3(new Long(advisor3));
        extend.setBeginDate(beginDate);
        extend.setEndDate(endDate);
        extend.setOnlineDay(new Integer(onlineDay));
        extend.setSceneDay(new Integer(sceneDay));
        extend.setType(new Integer(type));
        extend.setMemo(memo);
        extend.setOrderId(orderId);

        extendMapper.insert(extend);
    }

    private TabOrder newOrder(Long productId, long createTime) {
        TabOrder order = new TabOrder();
        order.setOrderStep(1);
        order.setStatus(0);
        order.setOrderNumber(getUUID());
        order.setProductId(productId);
        order.setCreateTime(createTime);
        order.setUpdateTime(createTime);
        order.setType(5L);
        orderMapper.insert(order);
        List<TabOrder> list = orderMapper.select(order);
        return list.get(0);
    }




    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static void main(String args[]) {
        System.out.println(System.currentTimeMillis());

    }


}
