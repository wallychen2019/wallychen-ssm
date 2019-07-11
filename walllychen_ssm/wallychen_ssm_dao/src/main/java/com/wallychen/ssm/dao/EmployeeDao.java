package com.wallychen.ssm.dao;

import com.wallychen.ssm.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description 员工持久层
 * @create 2019/7/5
 */
public interface EmployeeDao {

    /**
     * @description 根据员工名称查询员工详细信息
     * @params [username:员工名称]
     * @return com.wallychen.ssm.domain.Employee
     * @author ChenYZ
     * @date 2019/7/5 17:46
     */
    Employee findByUsername(String username) throws Exception;

    /**
     * @description 查询所有员工
     * @params [无]
     * @return java.util.List<com.wallychen.ssm.domain.Employee>
     * @author ChenYZ
     * @date 2019/7/5 17:47
     */
    List<Employee> findAll() throws Exception;

    /**
     * @description 添加员工
     * @params [employee : 员工对象]
     * @return void
     * @author ChenYZ
     * @date 2019/7/5 17:47
     */
    void save(Employee employee) throws Exception;

    /**
     * @description 根据员工ID，查询员工详细信息
     * @params [employeeId ：员工ID]
     * @return com.wallychen.ssm.domain.Employee
     * @author ChenYZ
     * @date 2019/7/5 17:48
     */
    Employee findById(String employeeId) throws Exception;

    /**
     * @description 添加用户与角色的关联关系
     * @params [employeeId, roleId]
     * @return void
     * @author ChenYZ
     * @date 2019/7/8 9:47
     */
    void addRoleToUser(@Param("employeeId") String employeeId, @Param("roleId") String roleId);
}
