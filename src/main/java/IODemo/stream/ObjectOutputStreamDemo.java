package IODemo.stream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 使用对象输出流和读对象输入流写对象
 * Exception in thread "main" java.io.NotSerializableException: com.itheima_07.Student
 * Serializable:序列号，是一个标识接口，只起标识作用，没有方法
 * 				当一个类的对象需要IO流进行读写的时候，这个类必须实现该接口
 *
 * Exception in thread "main" java.io.EOFException:当输入过程中意外到达文件或流的末尾时，抛出此异常。
 *
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
//        method();
        readMethod();
//        return;
    }

    private static void readMethod() throws IOException, ClassNotFoundException {
        //创建对象输入流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        //读取对象
		/*Object obj = ois.readObject();
		System.out.println(obj);

		Object obj2 = ois.readObject();
		System.out.println(obj2);

		Object obj3 = ois.readObject();
		System.out.println(obj3);*/

        try {
            while(true) {
                Object obj = ois.readObject();
                System.out.println(obj);
            }
        } catch(EOFException e) {
            System.out.println("读到了文件的末尾");
        }

        //释放资源
        ois.close();
    }

    private static void method() throws IOException, FileNotFoundException {
        //创建对象输出流的对象
        //FileOutputStream fos = new FileOutputStream("a.txt");
        //ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));

        //创建学生对象
        Student s = new Student("zhangsan",18);
        Student s2 = new Student("lisi",19);
        //写出学生对象
        oos.writeObject(s);
        oos.writeObject(s2);

        //释放资源
        oos.close();
    }

}
