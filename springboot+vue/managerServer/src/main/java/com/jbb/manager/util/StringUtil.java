package com.jbb.manager.util;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName StringUtil
 * @Author 金斌斌
 * @Description 常规校验工具类
 * @Date 2018-07-06 11:31
 **/
public class StringUtil {

    /**
     * @return java.lang.String UUID
     * @Author 金斌斌
     * @Description 生成UUID
     * @Date 2018-07-06 14:50
     * @Param []
     **/
    public static String getUUID() {
        String u = UUID.randomUUID().toString();
        String uuid = u.replaceAll("-", "");
        return uuid;
    }

    /**
     * @return boolean 返回标识 true为空
     * @Author 金斌斌
     * @Description 判断对象是否为空
     * @Date 2018-07-06 11:52
     * @Param [o] 传入对象
     **/
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof List) {
            return ((List) o).size() == 0;
        }
        if (o instanceof String) {
            return ((String) o).length() == 0;
        }
        return false;
    }

    /**
     * @return boolean  返回标识 true不为空
     * @Author 金斌斌
     * @Description 判断对象是否不为空
     * @Date 2018-07-06 11:53
     * @Param [o] 传入对象
     **/
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
