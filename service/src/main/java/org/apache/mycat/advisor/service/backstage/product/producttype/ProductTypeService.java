package org.apache.mycat.advisor.service.backstage.product.producttype;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.ProductType;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
public interface ProductTypeService extends BaseService<ProductType> {

    List<ProductType> findAll();

    Page<Map> pageList(Map<String, Object> param);
}
