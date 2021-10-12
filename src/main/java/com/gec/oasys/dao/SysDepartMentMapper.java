package com.gec.oasys.dao;

import com.gec.oasys.pojo.SysDepartMent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDepartMentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDepartMent record);

    int insertSelective(SysDepartMent record);

    SysDepartMent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDepartMent record);

    int updateByPrimaryKey(SysDepartMent record);

    List<SysDepartMent> query(SysDepartMent record);

    //获取子机构组织的数据
    List<SysDepartMent> querySysDepartMentByPid(Integer id);
}