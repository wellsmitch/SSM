package IODemo.PropertiesDemoPackage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/*
 * Properties和IO流结合的功能：
			void load(Reader reader)

			void list(PrintWriter out)
			void store(Writer writer, String comments)

 *
 */

public class PropertiesRead {
    public static void main(String[] args) throws IOException{
//        method();

//        method2();
        method3();


    }

    private static void method3() throws IOException {
        //创建属性列表对象
        Properties prop = new Properties();
        //添加映射关系
        prop.setProperty("CZBK001", "zhangsan");
        prop.setProperty("CZBK002", "lisi");
        prop.setProperty("CZBK003", "wangwu");
        //创建输出流对象
        FileWriter fw = new FileWriter("e.txt");

        //void store(Writer writer, String comments)
        prop.store(fw, "hello world2");

        //释放资源
        fw.close();
    }

    private static void method2() throws FileNotFoundException, IOException {
        //创建属性列表对象
        Properties prop = new Properties();
        //创建一个输入流对象
        FileReader fr = new FileReader("d.txt");

        //void load(Reader reader)
        prop.load(fr);

        //释放资源
        fr.close();

        System.out.println(prop);
    }

    private static void method() throws FileNotFoundException {
        //创建属性列表对象
        Properties prop = new Properties();
        //添加映射关系
        prop.setProperty("CZBK001", "zhangsan");
        prop.setProperty("CZBK002", "lisi");
        prop.setProperty("CZBK003", "wangwu");

        //创建打印流对象
        PrintWriter out = new PrintWriter("d.txt");
        //void list(PrintWriter out)
        prop.list(out);

        //释放资源
        out.close();
    }

}
