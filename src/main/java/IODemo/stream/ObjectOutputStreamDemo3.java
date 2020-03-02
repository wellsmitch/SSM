package IODemo.stream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 解决对象输入流读取对象出现异常的问题
 *
 */

public class ObjectOutputStreamDemo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException   {
//        method();
        getMethods();

    }

    private static void getMethods() throws IOException, ClassNotFoundException {
        //创建对象输入流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
        //读取数据
        Object obj = ois.readObject();
        //System.out.println(obj);

        //向下转型，获取具体的子类对象
        ArrayList<Student> list = (ArrayList<Student>) obj;
        for (Student student : list) {
            System.out.println(student);
        }

        //释放资源
        ois.close();
    }

    private static void method() throws IOException, FileNotFoundException {
        //创建对象输出流的对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"));
        //创建集合对象
        ArrayList<Student> list = new ArrayList<Student>();
        //添加学生对象
        list.add(new Student("wangwu",30));
        list.add(new Student("zhaoliu",28));
        //写出集合对象
        oos.writeObject(list);

        //释放资源
        oos.close();
    }

}
