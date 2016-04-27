package org.apache.mycat.advisor.service.backstage.um.userinfo.impl;

import org.apache.mycat.advisor.common.lang.StringSeriesTools;
import org.apache.mycat.advisor.common.security.shiro.authentication.ShiroRealm;
import org.apache.mycat.advisor.persistence.dao.SysUsersRolesMapper;
import org.apache.mycat.advisor.persistence.dao.TabUserInfoMapper;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.um.userinfo.RealmServiceWrapper;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * package: org.apache.mycat.advisor.service.backstage.um.userinfo.impl <br/>
 * functional describe:realm底层服务，主要为realm提供用户认证相关信息：用户角色列表，<br/>
 * 用户资源权限列表，用户账号，密码，id
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/4/26 19:54
 */
@Service("realmService")
public class RealmServiceImpl extends BaseServiceImpl<TabUserInfo> implements RealmServiceWrapper {
    @Autowired
    private TabUserInfoMapper tabUserInfoMapper;
    @Autowired
    private SysUsersRolesMapper sysUsersRolesMapper;

    @Override
    public Object getUniqueIdentity(String userName) {
        Long id = null;
        TabUserInfo userInfo = tabUserInfoMapper.selectUserByAccount(userName);
        if (userInfo != null) {
            id = userInfo.getId();
        }
        return id;
    }

    @Override
    public Object getUserPassword(String userName) {
        String password = null;
        TabUserInfo userInfo = tabUserInfoMapper.selectUserByAccount(userName);
        if (userInfo != null && !StringSeriesTools.isNullOrEmpty(userInfo.getPassword())) {
            password = userInfo.getPassword();
        }
        return password;
    }

    @Override
    public Map<String, Object> getUserUniqueIdentityAndPassword(String userName) {
        HashMap<String, Object> identity = new HashMap<>(2);
        TabUserInfo userInfo = tabUserInfoMapper.selectUserByAccount(userName);
        if (userInfo != null) {
            identity.put(ShiroRealm.getIdentity_in_map_key(), userInfo.getId());
            identity.put(ShiroRealm.getPassword_in_map_key(), userInfo.getPassword());
        }
        return identity;
    }

    @Override
    public Collection<String> getPermissions(Object uniqueIdentity) {
        return null;
    }

    @Override
    public Collection<String> getRoles(Object uniqueIdentity) {
        List<String> roles = null;
        if (uniqueIdentity != null && uniqueIdentity instanceof Long) {
            roles = sysUsersRolesMapper.selectUserRoles((Long) uniqueIdentity);
        }
        return roles;
    }

    @Override
    public Map<String, Collection<String>> getUserRolesAndPerms(Object uniqueIdentity) {
        Map<String, Collection<String>> authCollection = new HashMap<>(2);
        Collection<String> roles = this.getRoles(uniqueIdentity);
        if (!CollectionUtils.isEmpty(authCollection)) {
            authCollection.put(ShiroRealm.getRoles_in_map_key(), roles);
        }
        return authCollection;
    }

    @Override
    protected MyMapper<TabUserInfo> myMapper() {
        return tabUserInfoMapper;
    }
}
