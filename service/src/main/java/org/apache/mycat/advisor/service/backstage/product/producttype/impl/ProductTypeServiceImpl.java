package org.apache.mycat.advisor.service.backstage.product.producttype.impl;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.ProductTypeMapper;
import org.apache.mycat.advisor.persistence.model.ProductType;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.product.producttype.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
@Service
public class ProductTypeServiceImpl extends BaseServiceImpl<ProductType> implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;


    @Override
    protected MyMapper<ProductType> myMapper() {
        return productTypeMapper;
    }


    public Page<ProductType> page(Map<String, Object> param) {
        return super.page(param);
    }

    @Override
    public List<ProductType> findAll() {
        return productTypeMapper.selectAll();
    }

    @Override
    public Page<Map> pageList(Map<String, Object> param) {
        pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        List<Map<String, Object>> maps = productTypeMapper.selectByNameAndCode(str);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(maps);
        return twoPage(pageInfo);
    }
}
