package cn.edu.shu.controller;


import cn.edu.shu.domains.Resource;
import cn.edu.shu.domains.ResourceVo;
import cn.edu.shu.domains.ResponseResult;
import cn.edu.shu.service.ResourceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/findAllResourceBypage")
    public ResponseResult findAllResourceBypage(@RequestBody ResourceVo resourceVo) {
        PageInfo<Resource> pageInfo = resourceService.findAllResourceBypage(resourceVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "资源分页成功", pageInfo);
        return responseResult;
    }

}
