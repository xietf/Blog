package com.ty.Util;

import java.util.Date;

/**
 * 生成文件名
 */
public class UUIDUtils {

    public static String getUUID(){
        return new Date().getTime()+"";
    }

}