package IODemo.stream;

import java.io.Serializable;

public class Student implements Serializable {

    /**
     * 必要的  如果成员变量变化  则  读流的时候就会报错
     */
    private static final long serialVersionUID = 7415910271728145448L;
    /**
     *
     */
    String name;
    int age;


    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age +"]";
    }
}
