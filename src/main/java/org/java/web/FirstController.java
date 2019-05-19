package org.java.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class FirstController {

	@RequestMapping("/first")
	public String first(HttpSession ses){

        Subject subject = SecurityUtils.getSubject();
        Map user = (Map) subject.getPrincipal();
        String username = (String) user.get("username");
        List<Map> list = (List<Map>) user.get("menus");

        for(Map m:list){
            System.out.println(m);
        }

        ses.setAttribute("username",username );
        ses.setAttribute("list",list );


		return "main";
	}
}
