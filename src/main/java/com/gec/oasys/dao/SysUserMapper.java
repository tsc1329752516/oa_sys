package com.gec.oasys.dao;

import com.gec.oasys.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}