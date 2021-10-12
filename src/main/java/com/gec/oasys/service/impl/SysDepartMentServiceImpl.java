package com.gec.oasys.service.impl;

import com.gec.oasys.dao.SysDepartMentMapper;
import com.gec.oasys.pojo.SysDepartMent;
import com.gec.oasys.service.SysDepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysDepartMentServiceImpl implements SysDepartMentService {

    @Autowired
    private SysDepartMentMapper sysDepartMentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysDepartMentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysDepartMent record) {
        return sysDepartMentMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDepartMent record) {
        return sysDepartMentMapper.insertSelective(record);
    }

    @Override
    public SysDepartMent selectByPrimaryKey(Integer id) {
        return sysDepartMentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDepartMent record) {
        return sysDepartMentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysDepartMent record) {
        return sysDepartMentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysDepartMent> query(SysDepartMent record) {
        return sysDepartMentMapper.query(record);
    }


    @Override
    public List<SysDepartMent> treeSelectDataJson(int pid) {

        List<SysDepartMent> sysDepartMentList=sysDepartMentMapper.querySysDepartMentByPid(pid);

        diguiTree(sysDepartMentList);

        return sysDepartMentList;
    }

    /*
    * 不递归调用获取子节点数据，将子节点数据赋值给children属性
    * */
    public void diguiTree(List<SysDepartMent> sysDepartMentList)
    {
        for (SysDepartMent sysDepartMent : sysDepartMentList) {
            Integer id=sysDepartMent.getId();
            //获取子节点对象
            List<SysDepartMent> childSysDepartMentList=sysDepartMentMapper.querySysDepartMentByPid(id);

            if(childSysDepartMentList!=null && childSysDepartMentList.size()>0)
            {
                sysDepartMent.setChildren(childSysDepartMentList);

                //递归调用获取子节点
                diguiTree(childSysDepartMentList);
            }
        }
    }

    @Override
    @Transactional
    public int deleteBatch(String[] ids) {

        int result=0;

        for (String id : ids) {

            int flag=sysDepartMentMapper.deleteByPrimaryKey(Integer.parseInt(id));

            if(flag<=0)
            {
                result=1;
            }

        }

        return result;
    }
}
