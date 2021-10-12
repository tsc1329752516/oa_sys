package com.gec.oasys.controller;

import com.gec.oasys.pojo.SysDepartMent;
import com.gec.oasys.service.SysDepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class SysDepartMentController {

    @Autowired
    private SysDepartMentService sysDepartMentService;

    /*
     * 转发到部门列表（layui定义的表格组件）
     * */
    @RequestMapping("/toSysDepartMentList")
    public String toSysDepartMentList()
    {
        return "sys/dept/deptlist";
    }

    /*
    * 实现能够提供layui表格数据接口
    * sysDepartMent参数：存储查询条件的数据
    * */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(SysDepartMent sysDepartMent)
    {
        Map<String,Object> mapData=new HashMap<>();

        List<SysDepartMent> sysDepartMentList=sysDepartMentService.query(sysDepartMent);

        mapData.put("code",0);
        mapData.put("msg","");
        mapData.put("data",sysDepartMentList);

        return mapData;
    }

    @RequestMapping("/toAddSysDepartMent")
    public String toAddSysDepartMent()
    {
        return "sys/dept/deptadd";
    }

    @RequestMapping("/treeSelectDataJson")
    @ResponseBody
    public List<SysDepartMent> treeSelectDataJson(SysDepartMent sysDepartMent)
    {
        List<SysDepartMent> sysDepartMentList=sysDepartMentService.treeSelectDataJson(sysDepartMent.getId());

        return sysDepartMentList;
    }


    @RequestMapping("/saveSysDepartMent")
    @ResponseBody
    public String saveSysDepartMent(SysDepartMent sysDepartMent)
    {
        String ajaxReturnData="1";
        int flag=sysDepartMentService.insertSelective(sysDepartMent);

        if(flag>0)
        {
            ajaxReturnData="0";
        }


        return ajaxReturnData;
    }


    @RequestMapping("/deleteBatch")
    @ResponseBody
    public String deleteBatch(String ids)
    {

        int result=sysDepartMentService.deleteBatch(ids.split(","));

        if(result==0)
        {
            return "0";
        }else {
            return "1";

        }

    }

}
