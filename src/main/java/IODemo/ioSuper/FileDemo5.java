package IODemo.ioSuper;

import java.io.File;

/*
 * 	String[] list()
 	File[] listFiles()
 	static File[] listRoots()
 */
public class FileDemo5 {
    public static void main(String[] args)  {
        //method();
        //method2();

        //static File[] listRoots() :  返回的是所有盘符
        File[] files = File.listRoots();
        for (File file : files) {
            System.out.println(file);
        }


    }

    private static void method2() {
        File f = new File("b");
        File f2 = new File("D:\\workspace\\myFile");
        File f3 = new File("c.txt");

        //File[] listFiles()
        File[] files = f3.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static void method() {
        File f = new File("b");
        File f2 = new File("D:\\workspace\\myFile");
        File f3 = new File("c.txt");

        //String[] list() : 返回当前路径下所有的文件和文件夹名称
        //注意：只有指向文件夹的File对象才可以调用该方法
        String[] files = f3.list();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }


}
