package com.bjpowernode.javase.io;

import java.io.*;

/*
拷贝目录
 */
public class CopyAll {
    public static void main(String[] args) {
        //指定一个拷贝源
        File srcFile = new File("D:\\IoTest");
        //拷贝目标
        File destFile = new File("D:\\total\\");
        //调用方法拷贝
        copyDir(srcFile,destFile);
    }
/*
拷贝目录方法
 */
    private static void copyDir(File srcFile, File destFile) {
        if(srcFile.isFile()){
            //srcFile如果是一个文件的话,递归结束
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                //读这个文件
                in = new FileInputStream(srcFile);
                //写这个文件
                out = new FileOutputStream((destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcFile.getAbsolutePath().substring(3));
                //一边读一边写
                byte[] bytes = new byte[1024*1024];
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1){
                    out.write(bytes,0,readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        //获取源下面的子目录
        File[] files = srcFile.listFiles();
       // System.out.println(files.length);
        for(File file : files){
            //获取所有文件的绝对路径
            //System.out.println(file.getAbsolutePath());//输出获取到的文件或文件夹路径
            //新建对应的目录
            if(file.isDirectory()){
                //如果是一个目标，把这个拷贝完毕的路径拼接出来
                String srcDir = file.getAbsolutePath();
                //把盘符截掉，将上一个目录加到下一个目录最后面
                String destDir = (destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcDir.substring(3);
                System.out.println(destDir);
                //有了新路径后，创建这个路径为构造方法的File对象
                File newFile = new File(destDir);
                if(!newFile.exists()){
                    //如果不存在，则新建它
                    newFile.mkdirs();
                }

            }

            copyDir(file,destFile);//如果目录里还要目录就会继续递归
        }
    }
}
