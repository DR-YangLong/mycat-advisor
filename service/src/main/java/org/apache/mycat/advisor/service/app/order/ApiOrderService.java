package org.apache.mycat.advisor.service.app.order;

import org.apache.mycat.advisor.persistence.model.TabOrder;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by cjl on 2016/4/21.
 */
public interface ApiOrderService {


	TabOrder newOrder(Map<String, String> orderMap) throws ParseException;
}
