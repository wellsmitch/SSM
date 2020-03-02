package IODemo.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriterDemo1:
 * FileWriterDemo1(String fileName): 创建一个文件名称
 * 输出流写数据的步骤：
 * A：创建输出流对象
 * B:调用输出流对象的写数据方法
 * C：释放资源
 */
public class FileWriterDemo1 {
    public static void main(String[] args) throws IOException {
//        创建输出流对象
        FileWriter fw = new FileWriter("d:\\a.txt");
/**
 * 创建输出流对象做了哪些事情：
 *  A:调用系统资源创建了一个文件
 *  B:创建输出流对象
 *  C：把输出流对象指向文件
 */
//调用输出流对象的写数据的方法

//        写一个字符串数据
        fw.write("io流你好");
//        数据没有直接写到文件，其实是写到了内存缓冲区
        /*硬盘写数据的基本单位是字节*/
        fw.flush();
//        释放资源
//        通知系统释放和该文件相关的资源
        fw.close();

    }
}
