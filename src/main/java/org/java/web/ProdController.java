package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 马果
 * @Date: 2019/5/18 22:24
 * @Description:
 */
@Controller
public class ProdController {

    @RequestMapping("prod/manager")
    public String prodManager(){
        return "/prod/prodManager";
    }
}
