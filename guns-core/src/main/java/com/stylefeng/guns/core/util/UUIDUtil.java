package com.stylefeng.guns.core.util;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 数据库不建议存：-
     * @return
     */
    public static String genUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
