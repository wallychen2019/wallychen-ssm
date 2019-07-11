package com.wallychen.ssm.service;

import com.wallychen.ssm.domain.Role;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description
 * @create 2019/7/5
 */
public interface RoleService {

    List<Role> findRoleByUserId(String employeeId) throws Exception;

    List<Role> findAll() throws Exception;

    void save(Role role);

    List<Role> findOtherRoles(String employeeId) throws Exception;

    Role findById(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
