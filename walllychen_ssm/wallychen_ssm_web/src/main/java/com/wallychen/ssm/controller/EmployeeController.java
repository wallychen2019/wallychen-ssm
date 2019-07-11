package com.wallychen.ssm.controller;

import com.wallychen.ssm.domain.Employee;
import com.wallychen.ssm.domain.Role;
import com.wallychen.ssm.service.EmployeeService;
import com.wallychen.ssm.service.RoleService;
import com.wallychen.ssm.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/7/5
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private IdWorker idWorker;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        List<Employee> employees = employeeService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("employeeList", employees);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Employee employee) throws Exception{
        employee.setId(idWorker.nextId()+"");
        employeeService.save(employee);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception{
        Employee employee = employeeService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", employee);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String employeeId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Employee employee = employeeService.findById(employeeId);
        List<Role> roles = roleService.findOtherRoles(employeeId);
        mv.addObject("employee",employee);
        mv.addObject("roles",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String employeeId,String[] ids) throws Exception{
        employeeService.addRoleToUser(employeeId,ids);
        return "redirect:findAll.do";
    }

}
