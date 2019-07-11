package com.wallychen.ssm.service;

import com.wallychen.ssm.domain.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description
 * @create 2019/7/5
 */
public interface EmployeeService extends UserDetailsService {

    List<Employee> findAll() throws Exception;

    void save(Employee userInfo) throws Exception;

    Employee findById(String employeeId) throws Exception;

    void addRoleToUser(String employeeId, String[] ids);
}
