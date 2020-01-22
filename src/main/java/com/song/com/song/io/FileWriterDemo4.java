package com.song.com.song.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 如何实现数据的换行？
 * \n 可以实现换行 ，但是windows系统自带的记事本没有换行（\r\n）
 * windows \r\n
 * linux \n
 * mac \r
 * 如何实现数据的追加输入？
 */
public class FileWriterDemo4 {
    public static void main(String[] args) throws IOException {
//        FileWriter fw = new FileWriter("c.txt");
        // 追加数据
        FileWriter fw = new FileWriter("c.txt", true);
        for (int x = 0; x < 10; x++) {
            fw.write("hello" + x);
        }
        System.out.println("====");
        fw.close();
    }
}
