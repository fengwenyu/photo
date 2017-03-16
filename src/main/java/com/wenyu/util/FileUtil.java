package com.wenyu.util;

import java.util.Random;

/**
 * Created by 文宇 on 2017/3/16.
 */
public class FileUtil {
    /**
     * 获取文件上传名
     * @return
     */
    public static String getFileName(){
        StringBuffer sb = new StringBuffer();
        sb.append(System.currentTimeMillis());
        Random random = new Random();
        sb.append(random.nextInt() * 10000);
        return sb.toString();
    }

}
