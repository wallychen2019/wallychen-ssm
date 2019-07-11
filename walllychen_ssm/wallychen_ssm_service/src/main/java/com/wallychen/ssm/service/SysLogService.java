package com.wallychen.ssm.service;

import com.wallychen.ssm.domain.SysLog;

import java.util.List;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @description
 * @create 2019/7/4
 */
public interface SysLogService {

    public List<SysLog> findAll() throws Exception;

    public void save(SysLog log) throws Exception;
}
