package com.song.com.song.ioSuper;

import java.io.File;
import java.io.IOException;

/*
 *	判断功能
 * 		boolean exists()
 * 		boolean isAbsolute()
 * 		boolean isDirectory()
 		boolean isFile()
 		boolean isHidden()
 */

public class FileCreatePanduan {
    public static void main(String[] args) throws IOException {
        //method();
        //method2();
        //method3();

        method4();


    }

    private static void method4() {
        File f = new File("d:\\a\\b.txt");
        //boolean isHidden() :判断File对象指向的路径是否有隐藏属性，如果隐藏了则返回true，否则返回false

        System.out.println(f.isHidden());
    }

    private static void method3() {
        File f = new File("a.txt");
        File f2 = new File("b");
        //boolean isDirectory() ：判断File对象指向的路径是否是文件夹，如果是则返回true，否则返回false
        //boolean isFile()  : 判断File对象指向的路径是否是文件，如果是则返回true，否则返回false

        //System.out.println(f.isDirectory());
        //System.out.println(f2.isDirectory());

        System.out.println(f.isFile());
        System.out.println(f2.isFile());
    }

    private static void method2() {
        //File f = new File("a.txt");
        File f2 = new File("d:\\a\b.txt");

        //boolean isAbsolute() :判断File对象指向的路径是否是绝对路径，如果是绝对路径则返回true，否则返回false
        System.out.println(f2.isAbsolute());
    }

    private static void method() {
        File f = new File("a.txt");
        //f.createNewFile();

        //boolean exists() : 判断文件或者文件夹是否存在，如果存在则返回true，否则返回false
        System.out.println(f.exists());

    }
}
