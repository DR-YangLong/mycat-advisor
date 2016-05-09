package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.ProductInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
public interface ProductInfoMapper extends MyMapper<ProductInfo> {

    List<Map<String,Object>> selectByNameAndCode(String name);

    List<Map<String,Object>> selectByParam(Map<String, Object> param);


}
