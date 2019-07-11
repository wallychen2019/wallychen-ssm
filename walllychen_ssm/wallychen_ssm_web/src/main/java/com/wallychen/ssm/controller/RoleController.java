package com.wallychen.ssm.controller;

import com.wallychen.ssm.domain.Permission;
import com.wallychen.ssm.domain.Role;
import com.wallychen.ssm.service.PermissionService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private IdWorker idWorker;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        List<Role> roleList = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        role.setId(String.valueOf(idWorker.nextId()));
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserByIdAndAllPermission.do")
    public ModelAndView findUserByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role",role);
        List<Permission> permissionList = permissionService.findOtherPermission(roleId);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,
                                      @RequestParam(name = "ids",required = true) String[] permissionIds) throws Exception{
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }

}
