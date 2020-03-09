package IODemo.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException {
        //创建输入流对象
        FileReader fr = new FileReader("bbb.iml");
        // int read(char[] cbuf): 一次读一个字符数组的数据
     /*   char[] chs = new char[50];
        int len = fr.read(chs);
        System.out.println("len:" + len);
        System.out.println(new String(chs, 0, len));

        len = fr.read(chs);
        System.out.println("len:" + len);
        System.out.println(new String(chs, 0, len));
        */
        char[] chs = new char[1024]; // 可以是1024及其整数倍
        int len;
        while ((len = fr.read(chs)) != -1) {
            System.out.print(new String(chs, 0, len));//new String(tmp,1,nlen,"UTF8")就是将字节数组tmp从索引的第1位取nlen长度后组成字符串，切组成后的字符串按照utf8的字符集编码，够详细了吧
        }
        fr.close();
    }
}
