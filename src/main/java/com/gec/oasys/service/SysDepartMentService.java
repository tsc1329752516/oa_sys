package com.gec.oasys.service;

import com.gec.oasys.pojo.SysDepartMent;

import java.util.List;

public interface SysDepartMentService {

    int deleteByPrimaryKey(Integer id);

    int insert(SysDepartMent record);

    int insertSelective(SysDepartMent record);

    SysDepartMent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDepartMent record);

    int updateByPrimaryKey(SysDepartMent record);

    List<SysDepartMent> query(SysDepartMent record);

    List<SysDepartMent> treeSelectDataJson(int pid);

    public int deleteBatch(String[] ids);
}
