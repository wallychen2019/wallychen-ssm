package com.wallychen.ssm.service;

import com.wallychen.ssm.domain.Product;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @Description
 * @create 2019/6/21
 */
public interface ProductService {


    List<Product> findAll() throws Exception;

    void save(Product product);
}
