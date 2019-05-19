package org.java.service;

import org.apache.ibatis.annotations.Param;
import org.java.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 马果
 * @Date: 2019/5/18 21:43
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Map login(String name){
        return userMapper.login(name);
    }

    public List<Map> loadMenus(int userId){
        return userMapper.loadMenus(userId);
    }

    public List<String> loadPermission(@Param("userId") int userId){
        return userMapper.loadPermission(userId);
    }
}
