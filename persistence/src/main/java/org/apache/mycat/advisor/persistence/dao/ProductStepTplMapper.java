package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.ProductStepTpl;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
public interface ProductStepTplMapper extends MyMapper<ProductStepTpl> {

    List<Map<String,Object>> selectByNameAndCode(String name);

}
