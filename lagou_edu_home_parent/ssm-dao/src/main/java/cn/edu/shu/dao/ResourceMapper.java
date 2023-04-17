package cn.edu.shu.dao;

import cn.edu.shu.domains.Resource;
import cn.edu.shu.domains.ResourceVo;

import java.util.List;

public interface ResourceMapper {


    public List<Resource> findAllResourceBypage(ResourceVo resourceVo);
}
