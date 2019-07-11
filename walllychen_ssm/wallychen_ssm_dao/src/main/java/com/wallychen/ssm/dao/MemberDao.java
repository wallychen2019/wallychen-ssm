package com.wallychen.ssm.dao;

import com.wallychen.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author ChenYZ
 * @version 1.0.0
 * @Description 会员持久层
 * @create 2019/6/25
 */
public interface MemberDao {

    /**
     * @description 根据ID，查看旅客信息
     * @params [id]
     * @return com.wallychen.ssm.domain.Member
     * @author ChenYZ
     * @date 2019/7/5 17:46
     */
    Member findById(String id) throws Exception;

}
