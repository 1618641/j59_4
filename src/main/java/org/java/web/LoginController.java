package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 马果
 * @Date: 2019/5/17 10:04
 * @Description:
 * 这个控制器类，只有两种情况下，会进入
 *
 *  1、用户如果没有登录，会通过该控制器类，跳转到对应的登录页面
 *  2、用户登录失败时，会进入（用户名不存在，或者 密码错误）
 *
 *
 * @@@@@@@@@@@如果用户名与密码是正常，将不会进入该类
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(HttpServletRequest req) throws Exception{

        //只有当没有登录时或者是登录失败，才会进入该类,如果是因为登录失败进入的，request中，会存储一个数据:shiroLoginFailure
        //shiroLoginFailure:它实际是登录失败以后返回的错误消息

        String errName =(String) req.getAttribute("shiroLoginFailure");

        if(errName!=null){
            if(errName.equals("org.apache.shiro.authc.UnknownAccountException")){
                throw new Exception("用户名不存在");
            }
            if(errName.equals("org.apache.shiro.authc.IncorrectCredentialsException")){
                throw new Exception("密码错误");
            }
        }
        //去到登录界面
        return "/login";
    }

}
