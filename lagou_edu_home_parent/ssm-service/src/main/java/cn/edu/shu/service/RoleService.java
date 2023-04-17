package cn.edu.shu.service;

import cn.edu.shu.domains.Menu;
import cn.edu.shu.domains.Role;
import cn.edu.shu.domains.RoleVo;

import java.util.List;

public interface RoleService {
    public List<Role> findAllRole(String name);

    //根据角色ID查询关联菜单ID
    public List<Integer> findMenuByRoleId(Integer roleId);

    public void RoleContextMenu(RoleVo roleVo);

    //删除用户
    public void deleteRole(Integer roleId);


}
