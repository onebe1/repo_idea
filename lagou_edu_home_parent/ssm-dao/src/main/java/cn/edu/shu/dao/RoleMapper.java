package cn.edu.shu.dao;

import cn.edu.shu.domains.Menu;
import cn.edu.shu.domains.Role;
import cn.edu.shu.domains.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    public List<Role> findAllRole(String name);


    public List<Integer> findMenuByRoleId(Integer roleId);

    //根据roleid清空中间表的关联关系
    public void deleteRoleContextMenu(Integer roleId);

    //    为角色分配菜单信息
    public void RoleContextMenu(Role_menu_relation role_menu_relation);


    public void deleteRole(Integer roleId);


}
