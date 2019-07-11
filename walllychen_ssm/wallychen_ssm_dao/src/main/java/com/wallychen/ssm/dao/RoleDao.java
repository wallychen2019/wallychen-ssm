package com.wallychen.ssm.dao;

import com.wallychen.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description 角色管理持久层
 * @create 2019/7/5
 */
public interface RoleDao {

    /**
     * @description 根据员工ID，查询角色信息
     * @params [employeeId]
     * @return java.util.List<com.wallychen.ssm.domain.Role>
     * @author ChenYZ
     * @date 2019/7/5 17:48
     */
    List<Role> findRoleByUserId(String employeeId) throws Exception;

    /**
     * @description 查询所有角色
     * @params [无]
     * @return java.util.List<com.wallychen.ssm.domain.Role>
     * @author ChenYZ
     * @date 2019/7/5 17:49
     */
    List<Role> findAll() throws Exception;

    /**
     * @description 添加角色
     * @params [role ：角色对象]
     * @return void
     * @author ChenYZ
     * @date 2019/7/5 17:49
     */
    void save(Role role);

    /**
     * @description 查询非本身的所有角色
     * @params [employeeId]
     * @return java.util.List<com.wallychen.ssm.domain.Role>
     * @author ChenYZ
     * @date 2019/7/8 9:28
     */
    List<Role> findOtherRoles(String employeeId);

    /**
     * @description 根据ID，查询角色信息
     * @params [roleId:角色ID]
     * @return com.wallychen.ssm.domain.Role
     * @author ChenYZ
     * @date 2019/7/8 10:08
     */
    Role findById(String roleId) throws Exception;

    /**
     * @description 绑定角色与权限关联关系
     * @params [roleId, permissionId]
     * @return void
     * @author ChenYZ
     * @date 2019/7/8 10:25
     */
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
}
