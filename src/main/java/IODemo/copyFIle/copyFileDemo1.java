package IODemo.copyFIle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 需求：
 * 		把项目路径下的FileWriterDemo.java中的内容复制到项目路径下的Copy.java中
 *
 * 文件复制也是有规律可循的，也就是说有套路。
 *
 * 数据源：
 * 		FileWriterDemo.java -- 读数据 -- FileReader
 * 目的地：
 * 		Copy.java -- 写数据 -- FileWriter
 */

public class copyFileDemo1 {
    public static void main(String[] args) throws IOException {
        //创建输入流对象
        FileReader fr = new FileReader("c.txt");
        //创建输出流对象
        FileWriter fw = new FileWriter("d.txt");
        //读写数据
        int ch;
        while((ch=fr.read())!=-1) {
            fw.write(ch);
        }

        //释放资源
        fw.close();
        fr.close();

    }
}
