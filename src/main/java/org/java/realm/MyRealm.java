package org.java.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author: 马果
 * @Date: 2019/5/17 10:00
 * @Description:
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("##############正在进行权限认证");
        Map map = (Map) principals.getPrimaryPrincipal();

        int userId = (int) map.get("id");

        List<String> perms = userService.loadPermission(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(perms);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("==========正在进行认证操作=============");

        //取得用户凭证（用户名 ）
        String username = token.getPrincipal().toString();

        Map user = userService.login(username);

        //根据用户名到数据库中，判断，用户名是否存在
        if(user==null){
            return null;//用户名不存在，会抛出异常UnknownAccountException
        }
        //用户存在，得到该用户的正确密码
        String pwd = (String) user.get("PASSWORD");

        Integer userId = (Integer) user.get("id");
        //菜单
        List<Map> list = userService.loadMenus(userId);

       //密码：111，盐:aaa  //eabd8ce9404507aa8c22714d3f5eada9
        String salt="accp";

        user.put("menus",list );

        //返回一个AuthenticationInfo，将用户凭证，以及该用户名的正常密码，封装，并且返回,交给securityManager判断，用户输入的密码是否正常
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd ,ByteSource.Util.bytes(salt),"myrealm"  );
        //如果密码不正确，就会进入loginController
        return info;
    }
}
