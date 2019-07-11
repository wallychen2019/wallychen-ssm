package com.wallychen.ssm.dao;

import com.wallychen.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description 资源管理持久层
 * @create 2019/7/5
 */
public interface PermissionDao {

    /**
     * @description 根据角色ID，查询资源权限
     * @params [roleId:角色ID]
     * @return java.util.List<com.wallychen.ssm.domain.Permission>
     * @author ChenYZ
     * @date 2019/7/5 17:44
     */
    List<Permission> findPermissionByRoleId(String roleId) throws Exception;

    /**
     * @description 查询所有资源
     * @params [无]
     * @return java.util.List<com.wallychen.ssm.domain.Permission>
     * @author ChenYZ
     * @date 2019/7/5 17:44
     */
    List<Permission> findAll() throws Exception;

    /**
     * @description 添加资源
     * @params [permission: 资源对象]
     * @return void
     * @author ChenYZ
     * @date 2019/7/5 17:45
     */
    void save(Permission permission) throws Exception;

    /**
     * @description 根据角色ID，查询非授权的所有权限
     * @params [roleId]
     * @return java.util.List<com.wallychen.ssm.domain.Permission>
     * @author ChenYZ
     * @date 2019/7/8 10:13
     */
    List<Permission> findOtherPermission(String roleId) throws Exception;
}
