package org.apache.mycat.advisor.service.backstage.product.productinfo.impl;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.ProductInfoMapper;
import org.apache.mycat.advisor.persistence.model.ProductInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.product.productinfo.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
@Service
public class ProductInfoServiceImpl extends BaseServiceImpl<ProductInfo> implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;


    @Override
    protected MyMapper<ProductInfo> myMapper() {
        return productInfoMapper;
    }


    @Override
    public Page<Map> pageList(Map<String, Object> param) {
        pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        List<Map<String, Object>> maps = productInfoMapper.selectByNameAndCode(str);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(maps);
        return twoPage(pageInfo);
    }

    @Override
    public List<Map<String, Object>> getResult(Map<String, Object> param) {
        if(param!=null){
            List<Map<String, Object>> maps = productInfoMapper.selectByParam(param);
            return maps;
        }
        return null;
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoMapper.selectAll();
    }
}
