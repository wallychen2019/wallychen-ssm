package com.wallychen.ssm.service.impl;

import com.wallychen.ssm.dao.EmployeeDao;
import com.wallychen.ssm.domain.Employee;
import com.wallychen.ssm.domain.Role;
import com.wallychen.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/7/5
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Employee> findAll() throws Exception {
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee employee) throws Exception {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employeeDao.save(employee);
    }

    @Override
    public Employee findById(String employeeId) throws Exception {
        return employeeDao.findById(employeeId);
    }

    @Override
    public void addRoleToUser(String employeeId, String[] roleIds) {
        for (String roleId : roleIds){
            employeeDao.addRoleToUser(employeeId,roleId);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = null;
        try {
            employee = employeeDao.findByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        User user = new User(employee.getUsername(),employee.getPassword(),employee.getStatus() == 0 ? false : true, true, true, true, getAuthority(employee.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles){
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
