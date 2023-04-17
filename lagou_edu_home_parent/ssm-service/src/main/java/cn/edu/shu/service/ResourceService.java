package cn.edu.shu.service;

import cn.edu.shu.domains.Resource;
import cn.edu.shu.domains.ResourceVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ResourceService {

    public PageInfo<Resource> findAllResourceBypage(ResourceVo resourceVo);
}
