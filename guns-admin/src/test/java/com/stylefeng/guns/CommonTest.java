package com.stylefeng.guns;

import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.core.shiro.ShiroKit;
import org.junit.Test;

public class CommonTest extends BaseJunit {

    @Test
    public void testPwd() {
        String admin = ShiroKit.md5("admin", "8pgby");
        System.out.print("admin 加密后的密码是：" + admin);
    }

}
