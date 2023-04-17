package cn.edu.shu.service.Impl;

import cn.edu.shu.dao.MenuMapper;
import cn.edu.shu.domains.Menu;
import cn.edu.shu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        List<Menu> menuList = menuMapper.findSubMenuListByPid(pid);
        return menuList;
    }

    @Override
    public List<Menu> findAllMenu() {
        List<Menu> allMenu = menuMapper.findAllMenu();
        return  allMenu;
    }

    @Override
    public Menu findMenuInfoById(Integer id) {
        Menu menu = menuMapper.findMenuInfoById(id);
        return menu;
    }


}
