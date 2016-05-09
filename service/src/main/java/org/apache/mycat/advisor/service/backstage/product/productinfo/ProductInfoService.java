package org.apache.mycat.advisor.service.backstage.product.productinfo;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.ProductInfo;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
public interface ProductInfoService extends BaseService<ProductInfo> {


    Page<Map> pageList(Map<String, Object> param);

    List<Map<String,Object>> getResult(Map<String, Object> param);

    List<ProductInfo> findAll();
}
