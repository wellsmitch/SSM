package IODemo.ioSuper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 使用字节流复制文本文件
 *
 * 数据源		IODemo.java
 * 目的地		d:\\a\\IODemo.java
 *

 */

public class FileCopyInputStream {
    public static void main(String[] args) throws IOException  {
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("IODemo.java");
        //创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("d:\\a\\IODemo.java");

        //一次读写一个字节
		/*int by;
		while((by = fis.read()) != -1) {
			fos.write(by);
		}*/
        //一次读写一个字节数组
        int len;//存储读到的字节个数
        byte[] bys = new byte[1024];
        while((len = fis.read(bys)) != -1) {
            fos.write(bys,0,len);
        }


        //释放资源
        fos.close();
        fis.close();
    }

}
