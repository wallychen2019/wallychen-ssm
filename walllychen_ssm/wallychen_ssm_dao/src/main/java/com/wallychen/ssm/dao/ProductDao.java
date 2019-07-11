package com.wallychen.ssm.dao;

import com.wallychen.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @Description 产品管理持久层
 * @create 2019/6/21
 */
public interface ProductDao {

    /**
     * @description 查询所有产品
     * @params [无]
     * @return java.util.List<com.wallychen.ssm.domain.Product>
     * @author ChenYZ
     * @date 2019/7/5 17:49
     */
    List<Product> findAll() throws Exception;

    /**
     * @description 添加产品
     * @params [product ： 产品对象]
     * @return void
     * @author ChenYZ
     * @date 2019/7/5 17:50
     */
    void save(Product product);

    /**
     * @description 根据产品ID，查询产品详细信息
     * @params [id ：无]
     * @return com.wallychen.ssm.domain.Product
     * @author ChenYZ
     * @date 2019/7/5 17:50
     */
    Product findById(String id) throws Exception;
}
