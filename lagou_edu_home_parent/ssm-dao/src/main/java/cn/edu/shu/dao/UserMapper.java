package cn.edu.shu.dao;

import cn.edu.shu.domains.*;

import java.util.List;

public interface UserMapper {

    public List<User> findAllUserByPage(UserVo userVo);


    public User login(User user);


    public List<Role> findRoleById(Integer id);





    //根据角色id查询所拥有的顶级菜单
    public List<Menu> findMenuByRoleId(List<Integer> ids);

    //    根据pid查询子菜单信息
    public List<Menu> findSubMenuByPid(Integer pid);

//    获取用户拥有的资源权限信息

    public List<Resource> findResourceByRoleId(List<Integer> ids);

}
