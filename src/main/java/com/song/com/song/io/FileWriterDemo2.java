package com.song.com.song.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
    public static void main(String[] args) throws IOException {
//        创建输出流对象
        /**
         * 相对路径  相对当前项目而言的，在项目的根目录下（a.txt）
         */
        FileWriter fw = new FileWriter("a.txt");
/**
 * 创建输出流对象做了哪些事情：
 *  A:调用系统资源创建了一个文件
 *  B:创建输出流对象
 *  C：把输出流对象指向文件
 *
 *  close（）和flush（）方法的区别
 *          flush 刷新缓冲区 流对象还可以使用
 *          close 先刷新缓冲区，然后通知系统释放资源 流对象不可以再使用了
 */
//调用输出流对象的写数据的方法

//        写一个字符串数据
        fw.write("io流你好");
        fw.write("io流你好");
//        数据没有直接写到文件，其实是写到了内存缓冲区
        /*硬盘写数据的基本单位是字节*/
//            fw.flush();
//        释放资源
//        通知系统释放和该文件相关的资源
        fw.close();

    }
}
