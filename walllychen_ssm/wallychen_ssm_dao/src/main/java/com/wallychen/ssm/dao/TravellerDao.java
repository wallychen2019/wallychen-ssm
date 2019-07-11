package com.wallychen.ssm.dao;

import com.wallychen.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @Description 游客持久层
 * @create 2019/6/25
 */
public interface TravellerDao {

    /**
     * @description 根据订单ID查询游客信息
     * @params [ordersId：订单ID]
     * @return java.util.List<com.wallychen.ssm.domain.Traveller>
     * @author ChenYZ
     * @date 2019/7/5 17:43
     */
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
