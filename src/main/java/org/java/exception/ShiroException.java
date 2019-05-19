package org.java.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 马果
 * @Date: 2019/5/18 21:15
 * @Description:
 */
@Component
public class ShiroException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("###############################");
        String msg = ex.getMessage();

        ModelAndView mv = new ModelAndView("err");

        mv.addObject("msg",msg );

        return mv;
    }
}
