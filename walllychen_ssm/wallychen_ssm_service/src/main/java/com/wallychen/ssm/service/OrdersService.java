package com.wallychen.ssm.service;

import com.wallychen.ssm.domain.Orders;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @Description
 * @create 2019/6/25
 */
public interface OrdersService {

    List<Orders> findAll() throws Exception;

    List<Orders> findAllPage(int page, int pageSize) throws Exception;

    Orders findById(String id) throws Exception;
}
