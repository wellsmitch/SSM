package com.song.com.song.ioSuper;
import java.io.File;

/*
 * 需求：输出指定目录下所有的java文件名（包含子目录）
 */
public class RecurrenceTest {
    public static void main(String[] args) {
        File f = new File("src");
        //File f = new File("src\\com\\itheima_01\\RecurrenceDemo.java");
        method(f);
    }

    public static void method(File file) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                //判断是否是文件对象
                if(f.isFile()) {
                    if(f.getName().endsWith(".java")) {
                        System.out.println(f.getName());
                    }
                }
                else if(f.isDirectory()){
                    //是一个目录对象
                    method(f);
                }
            }
        }
    }


    //输出指定目录下的所有java文件名（不包含子目录）
    public static void method2(File file) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                //判断是否是文件对象
                if(f.isFile()) {
                    if(f.getName().endsWith(".java")) {
                        System.out.println(f.getName());
                    }
                }
            }
        }
    }

}
