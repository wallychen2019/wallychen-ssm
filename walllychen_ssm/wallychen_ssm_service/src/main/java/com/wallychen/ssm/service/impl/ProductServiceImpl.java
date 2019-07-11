package com.wallychen.ssm.service.impl;

import com.wallychen.ssm.dao.ProductDao;
import com.wallychen.ssm.domain.Product;
import com.wallychen.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/6/21
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

}
