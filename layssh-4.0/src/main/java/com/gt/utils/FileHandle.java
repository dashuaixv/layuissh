package com.gt.utils;


import java.io.*;

/**
 * 文件操作工具
 *
 * @author herun
 * @createTime 2015年2月10日-上午10:05:41
 * @see 依赖：commons-io-2.0.1.jar、servlet-api.jar
 */
public class FileHandle {

    /**
     * 文件是否存在
     *
     * @param path文件路径
     * @return 是否存在
     * @author herun
     * @createTime 2015年2月10日-上午10:06:02
     */
    public static boolean isExists(String path) {
        return new File(path).exists();
    }

    /**
     * 创建文件目录
     *
     * @author herun
     * @createTime 2015年2月10日-上午11:05:51
     * @param filepath路径
     */
    public static void mkdirs(String filepath) {
        File savdir = new File(filepath);
        // 目录不存在则创建
        if (!savdir.exists()) {
            savdir.mkdirs();
        }
    }
}
