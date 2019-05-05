package com.jbb.uploaddemo.utils;

import com.jbb.uploaddemo.common.enums.ExtEnum;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

/**
 * 文件工具类
 *
 * @author jbb
 * @date 19-4-25
 */
public class FileUtils {
    public static Double IMG_MAX_SIZE = 2D;
    public static String TEMP_HOME = System.getProperty("user.home") + "/tempFile/";

    private static String imgRegex = "jpg|jpeg|png|PNG|JPEG|JPG|gif|GIF";

    /**
     * 校验文件类型是否为图片
     *
     * @param fileName 文件名称
     * @return
     */
    public static Boolean checkImage(String fileName) {
        return Pattern.matches(".+(.jpg|.jpeg|.png|.gif|.JPG|.JPEG|.PNG|.GIF)", fileName);
    }

    /**
     * 设置文件所属父类型
     *
     * @param ext 文件类型
     * @return
     */
    public static String setParentExt(String ext) {
        if (Pattern.matches(imgRegex, ext)) {
            return ExtEnum.IMG.toString();
        }
        return null;
    }

    /**
     * kb转化mb
     *
     * @param size 文件大小 kb
     * @return
     */
    public static Double unitConversion(Long size) {
        return new BigDecimal(size).divide(new BigDecimal(1024))
                .divide(new BigDecimal(1024)).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
