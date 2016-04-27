package org.apache.mycat.advisor.persistence.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.mycat.advisor.persistence.model.SysUsersRoles;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;

/**
 * Created by cjl on 2016/3/20.
 */
public interface SysUsersRolesMapper extends MyMapper<SysUsersRoles> {
    List<String> selectUserRoles(@Param("userId") Long userId);
}
