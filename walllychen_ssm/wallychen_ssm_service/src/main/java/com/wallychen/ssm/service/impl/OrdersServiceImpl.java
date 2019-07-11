package com.wallychen.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.wallychen.ssm.dao.OrdersDao;
import com.wallychen.ssm.domain.Orders;
import com.wallychen.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/6/25
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findAllPage(int page,int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception{
        return ordersDao.findById(id);
    }


}
