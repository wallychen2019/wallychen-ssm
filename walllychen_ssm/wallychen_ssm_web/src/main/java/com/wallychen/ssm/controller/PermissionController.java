package com.wallychen.ssm.controller;

import com.wallychen.ssm.domain.Permission;
import com.wallychen.ssm.service.PermissionService;
import com.wallychen.ssm.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/7/5
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private IdWorker idWorker;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        List<Permission> permissionList = permissionService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permission.setId(String.valueOf(idWorker.nextId()));
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

}
