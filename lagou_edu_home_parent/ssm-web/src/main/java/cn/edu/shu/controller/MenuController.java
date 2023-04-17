package cn.edu.shu.controller;


import cn.edu.shu.domains.Menu;
import cn.edu.shu.domains.ResponseResult;
import cn.edu.shu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
        List<Menu> allMenu = menuService.findAllMenu();
        ResponseResult responseResult = new ResponseResult(true, 200, "查询菜单成功", allMenu);

        return responseResult;
    }

    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id) {
        Menu menu = menuService.findMenuInfoById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "回显菜单信息成功", menu);
        return responseResult;
    }



}
