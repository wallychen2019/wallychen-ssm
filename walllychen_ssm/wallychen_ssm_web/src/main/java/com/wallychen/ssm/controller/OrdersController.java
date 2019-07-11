package com.wallychen.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.wallychen.ssm.domain.Orders;
import com.wallychen.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description 订单控制层
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/6/25
 */
@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * @description 分页查询
     * @params [page, pageSize]
     * @return org.springframework.web.servlet.ModelAndView
     * @author ChenYZ
     * @date 2019/6/25 16:45
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "5") Integer pageSize) throws Exception{
        List<Orders> orders = ordersService.findAllPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(orders);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }


    /**
     * @description 根据ID，查看订单详细信息并返回订单详细页面
     * @params [id : 订单ID]
     * @return org.springframework.web.servlet.ModelAndView
     * @author ChenYZ
     * @date 2019/7/5 17:50
     */
    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception{
        Orders orders = ordersService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders",orders);
        return mv;
    }

}
