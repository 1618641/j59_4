package org.java.realm;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author: 马果
 * @Date: 2019/5/18 23:18
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        Md5Hash m = new Md5Hash("111","accp" , 1);
        System.out.println(m.toString());
    }
}
