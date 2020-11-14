package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author: iceixQWQ
 * @Date: 2020/11/14 - 11 - 14 - 20:38
 * @Description: com.util
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入源路径：");
        String src = in.next();
        System.out.println("\n请输入目标路径：");
        String dest = in.next();
        try {
            CopyFilesOrFolders.copyFilesOrFolders(src, dest);
        }catch (FileNotFoundException e){
            System.out.println("-----------路径有误-----------");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("-----------error！------------");
            e.printStackTrace();
        }finally {
            System.out.println("-----------复制结束-----------");
        }
    }
}
