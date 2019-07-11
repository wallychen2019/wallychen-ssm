package com.wallychen.ssm.dao;

import com.wallychen.ssm.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description 订单持久层
 * @create 2019/6/25
 */
public interface OrdersDao {


    /**
     * @description 查询所有订单
     * @params [无]
     * @return java.util.List<com.wallychen.ssm.domain.Orders>
     * @author ChenYZ
     * @date 2019/7/5 17:45
     */
    List<Orders> findAll() throws Exception;

    /**
     * @description 根据ID，查询订单信息
     * @params [id：订单ID]
     * @return com.wallychen.ssm.domain.Orders
     * @author ChenYZ
     * @date 2019/7/5 17:46
     */
    Orders findById(String id) throws Exception;
}
