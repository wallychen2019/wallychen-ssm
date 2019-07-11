package com.wallychen.ssm.service.impl;

import com.wallychen.ssm.dao.SysLogDao;
import com.wallychen.ssm.domain.SysLog;
import com.wallychen.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/7/4
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }
}
