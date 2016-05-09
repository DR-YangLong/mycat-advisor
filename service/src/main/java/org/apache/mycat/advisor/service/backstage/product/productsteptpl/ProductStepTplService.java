package org.apache.mycat.advisor.service.backstage.product.productsteptpl;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.ProductStepTpl;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
public interface ProductStepTplService extends BaseService<ProductStepTpl> {


    Page<Map> pageList(Map<String, Object> param);

}
