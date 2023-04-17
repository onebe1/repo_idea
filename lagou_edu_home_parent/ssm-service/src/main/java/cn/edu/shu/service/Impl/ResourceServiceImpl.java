package cn.edu.shu.service.Impl;

import cn.edu.shu.dao.ResourceMapper;
import cn.edu.shu.domains.Resource;
import cn.edu.shu.domains.ResourceVo;
import cn.edu.shu.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResourceBypage(ResourceVo resourceVo) {


        Integer currentPage = resourceVo.getCurrentPage();
        Integer pageSize = resourceVo.getPageSize();

        PageHelper.startPage(currentPage,pageSize);
        List<Resource> allResourceBypage = resourceMapper.findAllResourceBypage(resourceVo);

        PageInfo<Resource> pageInfo = new PageInfo<>(allResourceBypage);
        return pageInfo;
    }
}
