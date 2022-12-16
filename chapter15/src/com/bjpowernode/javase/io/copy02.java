package com.bjpowernode.javase.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
用fileReader 和FileWriter进行拷贝
 */
public class copy02 {
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out = null;
        try {
            in = new FileReader("D:\\IoTest\\temp.txt");
            out = new FileWriter("D:\\IoTest\\file");

            //边读一边写：
            char[] chars = new char[1024*1024];
            int readCount = 0;

            while ((readCount = in.read(chars)) != -1){
                out.write(chars,0,readCount);
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
    }
}
