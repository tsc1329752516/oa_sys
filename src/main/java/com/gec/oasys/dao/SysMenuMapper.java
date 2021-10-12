package com.gec.oasys.dao;

import com.gec.oasys.pojo.SysMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}