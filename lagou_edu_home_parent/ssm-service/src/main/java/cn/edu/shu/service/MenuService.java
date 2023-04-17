package cn.edu.shu.service;

import cn.edu.shu.domains.Menu;

import java.util.List;

public interface MenuService {

    //    查询所有的父子菜单信息
    public List<Menu> findSubMenuListByPid(int pid);


    //    查询所有菜单信息
    public List<Menu> findAllMenu();

    public Menu findMenuInfoById(Integer id);


}
