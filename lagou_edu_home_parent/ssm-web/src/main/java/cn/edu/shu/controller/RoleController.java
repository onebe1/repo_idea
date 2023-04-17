package cn.edu.shu.controller;

import cn.edu.shu.domains.Menu;
import cn.edu.shu.domains.ResponseResult;
import cn.edu.shu.domains.Role;
import cn.edu.shu.domains.RoleVo;
import cn.edu.shu.service.MenuService;
import cn.edu.shu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")

public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestParam String name) {
        List<Role> allRole = roleService.findAllRole(name);
        ResponseResult responseResult = new ResponseResult(true, 200, "角色列表查询和条件查询", allRole);
        return responseResult;
    }

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid() {
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);


        //响应数据

        Map<String, Object> map = new HashMap<>();

        map.put("parentMenuList", menuList);
        ResponseResult responseResult = new ResponseResult(true, 200, "查找所有菜单成功", map);

        return responseResult;
    }

    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId) {
        List<Integer> list = roleService.findMenuByRoleId(roleId);
        ResponseResult responseResult = new ResponseResult(true, 200, "查找所有菜单成功", list);

        return responseResult;
    }

    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleVo roleVo) {


        roleService.RoleContextMenu(roleVo);


        ResponseResult responseResult = new ResponseResult(true, 200, "为角色分配菜单成功", null);


        return responseResult;
    }
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer roleId) {
        roleService.deleteRole(roleId);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除用户成功", null);

        return responseResult;
    }



}
