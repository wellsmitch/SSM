package com.song.com.song.bufferStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamCopy {
    public static void main(String[] args) throws IOException {
        //创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader("Copy1.txt"));
        //创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("Copy2.txt"));

        //读写数据
        String line;
        while((line=br.readLine())!=null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
        br.close();

    }
}
