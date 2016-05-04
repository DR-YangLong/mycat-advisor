package org.apache.mycat.advisor.service.backstage.om.info;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.Map;

public interface OrderInfoService extends BaseService<TabOrder> {


    Page pageUnapproved(Map<String, Object> param);

    Page pageMyApproved(Map<String, Object> param);
}
