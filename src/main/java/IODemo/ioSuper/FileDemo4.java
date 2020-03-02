package IODemo.ioSuper;

import java.io.File;
import java.io.IOException;

/*
 *	获取功能
 		File getAbsoluteFile()
 * 		String getAbsolutePath()
 * 		String getParent()
 * 		File getParentFile()
 * 		String getName()
 * 		String getPath()
  		long lastModified()
  		long length()
  	修改功能：
 		boolean renameTo(File dest)
 */
public class FileDemo4 {
    public static void main(String[] args) throws IOException  {
        //method();
        //method2();
        //method3();

        File f = new File("d.txt");
        File f2 = new File("e.txt");

        //boolean renameTo(File dest) : 将当前File对象所指向的路径 修改为 指定File所指向的路径
        //注意：修改的文件路径不能存在，如果存在则修改失败
        System.out.println(f.renameTo(f2));
    }

    private static void method3() {
        File f = new File("a.txt");
        File f2 = new File("d:\\a\\b.txt");
        File f3 = new File("b");

        //String getName() : 获取文件和文件夹的名称
        //System.out.println(f.getName());
        //System.out.println(f2.getName());
        //System.out.println(f3.getName());

        //String getPath() : 返回创建File对象时给的路径
        //System.out.println(f.getPath());
        //System.out.println(f2.getPath());
        //System.out.println(f3.getPath());

        //long lastModified() : 以毫秒值的形式返回最后修改时间
        //System.out.println(f.lastModified());
        //2514023311294
        //Date d = new Date(2514023311294L);
        //System.out.println(d.toLocaleString());

        //long length() : 返回文件的字节数
        System.out.println(f.length());
        System.out.println(f3.length());
    }

    private static void method2() throws IOException {
        //File f = new File("a.txt");

        //File f2 = new File("b","c.txt");
        //System.out.println(f2.createNewFile());

        File parent = new File("b");
        File f3 = new File(parent,"c.txt");
        if(!parent.exists()) {
            parent.mkdirs();
        }
        System.out.println(f3.createNewFile());

        //String getParent()
        System.out.println(f3.getParent());
        //File getParentFile()
        System.out.println(f3.getParentFile());
    }

    private static void method() {
        File f = new File("d:\\a\\b.txt");
        File f2 = new File("a.txt");

        //File getAbsoluteFile()  ：以File对象的形式返回当前File对象所有指向的绝对路径
        System.out.println(f2.getAbsoluteFile());
        //String getAbsolutePath() : 返回File对象所指向的绝对路径
        System.out.println(f2.getAbsolutePath());
    }

}
