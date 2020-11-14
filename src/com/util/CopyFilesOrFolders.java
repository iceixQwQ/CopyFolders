package com.util;

import java.io.*;

/**
 * @Author: iceixQWQ
 * @Date: 2020/11/14 - 11 - 14 - 20:37
 * @Description: com.util
 * @Version: 1.0
 */

public class CopyFilesOrFolders {
    public static void copyFilesOrFolders(String src, String dest) throws IOException {
        File srcFilesOrFolders = new File(src);
        File destFolders = new File(dest);
        copyFilesOrFolders(srcFilesOrFolders, destFolders);
    }

    public static void copyFilesOrFolders(File srcFilesOrFolders, File destFolders) throws IOException {

        //如果目标路径不是文件夹则直接返回
        if(!destFolders.isDirectory()) return;

        //判断源路径是文件还是文件夹
        if(srcFilesOrFolders.isFile()){
            //如果源路径是文件
            String fileName = srcFilesOrFolders.getName();
            File destFile = new File(destFolders, fileName);
            copyFiles(srcFilesOrFolders, destFile);
        }else{
            //如果源路径是文件夹
            //创建同名目标文件夹
            File newFolder = new File(destFolders, srcFilesOrFolders.getName());
            if(!newFolder.exists()){
                newFolder.mkdir();
            }

            //获取源文件夹下的文件和文件夹
            File[] filesOrFoldersArray = srcFilesOrFolders.listFiles();

            //递归调用进行复制
            for (File file : filesOrFoldersArray) {
                copyFilesOrFolders(file, newFolder);
            }
        }
    }

    private static void copyFiles(File src, File dest) throws IOException {
        //创建输入输出流
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(dest));

        //复制
        byte[] buffer = new byte[8192];
        int len = 0;
        while((len = bi.read(buffer)) != -1){
            bo.write(buffer, 0, len);
        }

        //释放资源
        bi.close();
        bo.close();
    };
}
