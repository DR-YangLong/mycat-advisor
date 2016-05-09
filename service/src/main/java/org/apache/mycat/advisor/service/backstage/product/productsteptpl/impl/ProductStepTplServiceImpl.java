package org.apache.mycat.advisor.service.backstage.product.productsteptpl.impl;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.ProductStepTplMapper;
import org.apache.mycat.advisor.persistence.model.ProductStepTpl;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.product.productsteptpl.ProductStepTplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cloudsher on 2016/4/27.
 */
@Service
public class ProductStepTplServiceImpl extends BaseServiceImpl<ProductStepTpl> implements ProductStepTplService {

    @Autowired
    private ProductStepTplMapper productStepTplMapper;

    @Override
    protected MyMapper myMapper() {
        return productStepTplMapper;
    }


    @Override
    public Page<Map> pageList(Map<String, Object> param) {
        pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        List<Map<String, Object>> list = productStepTplMapper.selectByNameAndCode(str);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        return twoPage(pageInfo);
    }
}
