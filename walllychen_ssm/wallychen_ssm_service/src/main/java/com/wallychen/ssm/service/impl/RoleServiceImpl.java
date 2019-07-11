package com.wallychen.ssm.service.impl;

import com.wallychen.ssm.dao.RoleDao;
import com.wallychen.ssm.domain.Role;
import com.wallychen.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/7/5
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception{
        for (String permissionId : permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Role> findRoleByUserId(String employeeId) throws Exception {
        return roleDao.findRoleByUserId(employeeId);
    }

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRoles(String employeeId) throws Exception {
        return roleDao.findOtherRoles(employeeId);
    }
}
