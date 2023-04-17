package cn.edu.shu.service.Impl;

import cn.edu.shu.dao.RoleMapper;
import cn.edu.shu.domains.Menu;
import cn.edu.shu.domains.Role;
import cn.edu.shu.domains.RoleVo;
import cn.edu.shu.domains.Role_menu_relation;
import cn.edu.shu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(String name) {
        List<Role> allRole = roleMapper.findAllRole(name);
        return allRole;
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        List<Integer> allMenu = roleMapper.findMenuByRoleId(roleId);
        return allMenu;
    }

    @Override
    public void RoleContextMenu(RoleVo roleVo) {

        // 首先是清空
        int roleId = roleVo.getRoleId();
        roleMapper.deleteRoleContextMenu(roleId);

        //其次是插入
        Role_menu_relation role_menu_relation = new Role_menu_relation();
        Date date = new Date();
        role_menu_relation.setRoleId(roleId);
        role_menu_relation.setCreatedTime(date);
        role_menu_relation.setUpdatedTime(date);
        List<Integer> menuIdList = roleVo.getMenuIdList();
        role_menu_relation.setCreatedBy("system");
        role_menu_relation.setUpdatedby("system");
        for (Integer integer : menuIdList) {
            role_menu_relation.setMenuId(integer);
            roleMapper.RoleContextMenu(role_menu_relation);
        }
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleMapper.deleteRole(roleId);
    }




}
