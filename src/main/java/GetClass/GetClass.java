package GetClass;

import org.junit.Test;

public class GetClass {
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("测试========》");
        String s1=this.getClass().getResource("").getPath();
        String s2=this.getClass().getResource("/log4j2.xml").getPath();
        System.out.println(s1);
        System.out.println(s2);
    }

    public static void main(String[] args) {
        new GetClass().run();
    }
}
