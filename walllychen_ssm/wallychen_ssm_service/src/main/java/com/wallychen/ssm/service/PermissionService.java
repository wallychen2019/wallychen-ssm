package com.wallychen.ssm.service;

import com.wallychen.ssm.domain.Permission;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description
 * @create 2019/7/5
 */
public interface PermissionService {

    List<Permission> findPermissionByRoleId(String id) throws Exception;

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    List<Permission> findOtherPermission(String roleId) throws Exception;
}
