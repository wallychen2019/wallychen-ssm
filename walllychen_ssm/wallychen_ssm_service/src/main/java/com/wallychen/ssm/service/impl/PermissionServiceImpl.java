package com.wallychen.ssm.service.impl;

import com.wallychen.ssm.dao.PermissionDao;
import com.wallychen.ssm.domain.Permission;
import com.wallychen.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/7/5
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findPermissionByRoleId(String id) throws Exception {
        return permissionDao.findPermissionByRoleId(id);
    }

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return permissionDao.findOtherPermission(roleId);
    }
}
