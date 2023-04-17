package cn.edu.shu.controller;


import cn.edu.shu.domains.ResponseResult;
import cn.edu.shu.domains.Role;
import cn.edu.shu.domains.User;
import cn.edu.shu.domains.UserVo;
import cn.edu.shu.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController

@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo) {

        PageInfo pageInfo = userService.findAllUserByPage(userVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "分页成功", pageInfo);
        return responseResult;
    }

    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {

        User user1 = userService.login(user);

        if (user1 != null) {
            //保存用户id 及access_token到session
            HttpSession session = request.getSession();

            String s = UUID.randomUUID().toString();
            session.setAttribute("access_token", s);
            session.setAttribute("user_id", user1.getId());

            //将查询出来的信息响应给前台

            Map<String, Object> map = new HashMap<>();

            map.put("access_token", s);
            map.put("user_id", user1.getId());

            return new ResponseResult(true, 200, "登录成功", map);
        } else {
            return new ResponseResult(true, 200, "用户名或密码错误", null);

        }
    }

    @RequestMapping("/findUserRoleById")
    public ResponseResult findRoleById(Integer userId) {
        List<Role> roleList = userService.findRoleById(userId);
        ResponseResult responseResult = new ResponseResult(true, 200, "根据id查询该用户所具备的角色信息成功", roleList);

        return responseResult;
    }

    //获取用户权限，进行菜单动态展示
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermission(HttpServletRequest req) {

        String header_token = req.getHeader("Authorization");


        HttpSession session = req.getSession();

        String session_token = (String) session.getAttribute("access_token");

        //3.判断token是否一致

        if (header_token.equals(session_token)) {

            Integer user_id = (Integer) session.getAttribute("user_id");

            ResponseResult userpermissions = userService.getUserpermissions(user_id);
            return userpermissions;
        } else {
            return new ResponseResult(false, 400, "获取用户权限失败", null);
        }

    }
}
