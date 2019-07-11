package com.wallychen.ssm.controller;

import com.wallychen.ssm.domain.Product;
import com.wallychen.ssm.service.ProductService;
import com.wallychen.ssm.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description 产品控制层
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/6/21
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private IdWorker idWorker;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm"),true));
    }

    @RequestMapping("findAll.do")
    @RolesAllowed({"ADMIN","USER"})
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(Product product) throws Exception{
        product.setId(idWorker.nextId()+"");
        productService.save(product);
        return "redirect:findAll.do";
    }

}