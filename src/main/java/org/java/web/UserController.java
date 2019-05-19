package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 马果
 * @Date: 2019/5/18 22:22
 * @Description:
 */
@Controller
public class UserController {
    @RequestMapping("user/manager")
    public String userManager(){
        return "/user/userManager";
    }

    @RequestMapping("user/add")
    public String add(){
        return "/user/ok";
    }



    @RequestMapping("user/del")
    public String del(){
        return "/user/ok";
    }


    @RequestMapping("user/search")
    public String search(){
        return "/user/ok";
    }


    @RequestMapping("user/update")
    public String update(){
        return "/user/ok";
    }
}
