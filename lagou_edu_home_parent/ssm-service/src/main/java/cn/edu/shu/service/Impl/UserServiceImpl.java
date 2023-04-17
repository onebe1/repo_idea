package cn.edu.shu.service.Impl;

import cn.edu.shu.dao.UserMapper;
import cn.edu.shu.domains.*;
import cn.edu.shu.service.UserService;
import cn.edu.shu.utils.Md5;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {

        //配置分页效果
        int currentPage = userVo.getCurrentPage();
        int pageSize = userVo.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userMapper.findAllUserByPage(userVo);

        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

    @Override
    public User login(User user) throws Exception {

        User user1 = userMapper.login(user);

        String password = user.getPassword();
        String password1 = user1.getPassword();
        if (user1 != null && Md5.verify(password, "zhitaoliu", password1)) {
            return user1;
        } else {
            return null;
        }


    }

    @Override
    public List<Role> findRoleById(Integer id) {
        List<Role> roleList = userMapper.findRoleById(id);
        return roleList;
    }

    @Override
    public List<Menu> findMenuByRoleId(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Menu> findSubMenuByPid(Integer pid) {
        return null;
    }

    @Override
    public List<Resource> findResourceByRoleId(List<Integer> ids) {
        return null;
    }

    @Override
    public ResponseResult getUserpermissions(Integer userId) {
        // 1.获取当前的请求头
        List<Role> roleList = userMapper.findRoleById(userId);


        //2.获取角色ID,保存到list集合中
        ArrayList<Integer> roleIds = new ArrayList<>();
        for (Role role : roleList) {
            int id =  role.getId();
            roleIds.add(id);
        }

        //3.根据角色id查询父菜单
        List<Menu> parentMenu = userMapper.findMenuByRoleId(roleIds);

        //4.查询封装父菜单关联的子菜单

        for (Menu menu : parentMenu) {
            List<Menu> subMenuList = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenuList);
        }

        //5.获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        //封装数据并返回

        Map<String, Object> map = new HashMap<>();

        map.put("menuList",parentMenu);

        map.put("resourceList",resourceList);

        return new ResponseResult(true,200,"获取用户权限信息成功",map);
    }

}
