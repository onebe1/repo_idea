package cn.edu.shu.dao;

import cn.edu.shu.domains.Menu;

import java.util.List;

public interface MenuMapper {


    //    查询所有的父子菜单信息
    public List<Menu> findSubMenuListByPid(int pid);

    //    查询所有菜单信息
    public List<Menu> findAllMenu();

    //查询菜单信息(回显)
    public Menu findMenuInfoById(Integer id);

}
