package org.apache.mycat.advisor.service.app.order.impl;

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
    public TabOrder newOrder(Map<String, String> orderMap, Long productId) throws ParseException {

        String type = orderMap.get("type");
        String beginDate = orderMap.get("beginDate");
        String endDate = orderMap.get("endDate");
        String sceneDay = orderMap.get("sceneDay");
        String onlineDay = orderMap.get("onlineDay");
        String advisor1 = orderMap.get("advisor1");
        String advisor2 = orderMap.get("advisor2");
        String advisor3 = orderMap.get("advisor3");
        String memo = orderMap.get("memo");

        //if (verify(orderMap))

        if (!verify(type, beginDate, endDate, sceneDay, advisor1, advisor2, advisor3,onlineDay)) {
            return null;
        }



        long createTime = System.currentTimeMillis();
        //创建一个新订单
        TabOrder order = newOrder(productId, createTime);
        //插入订单信息

        saveExtend(type, beginDate, endDate, sceneDay, advisor1, advisor2, advisor3, memo,order.getId(),onlineDay);


        return order;
    }

    private boolean verify( String type, String beginDate, String endDate, String sceneDay, String advisor1, String advisor2, String advisor3,String s) {
        if (StringUtils.isNotEmpty(type)) {
            return true;
        }
        if (StringUtils.isNotEmpty(beginDate)) {
            return true;
        }
        if (StringUtils.isNotEmpty(endDate)) {
            return true;
        }
        if (StringUtils.isNotEmpty(sceneDay)) {
            return true;
        }
        if (StringUtils.isNotEmpty(advisor1)) {
            return true;
        }
        if (StringUtils.isNotEmpty(advisor2)) {
            return true;
        }
        if (StringUtils.isNotEmpty(advisor3)) {
            return true;
        }
        if (StringUtils.isNotEmpty(s)) {
            return true;
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
