package com.song.com.song.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 需求：从文件中读数据并显示到控制台
 * 		读数据--输入流--FileReader
 *
 * FileReader:
 * 		FileReader(String fileName):传递文件名称
 *
 * 输入流读文件的步骤：
 * 		A:创建输入流对象
 * 		B:调用输入流对象的读数据方法
 * 		C:释放资源
 *
 * java.io.FileNotFoundException: fr.txt (系统找不到指定的文件。)
 */

public class FileReaderDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("c.txt");
        //调用输入流对象的读数据方法
        //int read():一次读取一个字符
        int ch = fr.read();
        System.out.println(ch);
        System.out.println((char)ch);
        //这是时候，我们发现代码的重复度很高，想用循环改进，但是不知道循环的结束条件是什么
        while((ch=fr.read())!=-1) {
            //System.out.println(ch);
            //System.out.println((char)ch);
            System.out.print((char)ch);
        }
        fr.close();

    }
}
