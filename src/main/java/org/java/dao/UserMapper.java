package org.java.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 马果
 * @Date: 2019/5/18 21:37
 * @Description:
 */
public interface UserMapper {

    public Map login(@Param("name") String name);

    public List<Map> loadMenus(@Param("userId") int userId);

    //加载 当前用户拥有的访问权限
    public List<String> loadPermission(@Param("userId") int userId);
}
