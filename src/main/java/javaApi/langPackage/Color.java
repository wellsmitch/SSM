package javaApi.langPackage;
public enum Color {
    RED("红色", 123211,"aaa"), GREEN("绿色", 21312, "bbb"), BLANK("白色", 3, "ccc"), YELLO("黄色", 4, "ddd");
    // 成员变量
    private String name;
    private int index;
    private String tip;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    // 构造方法
    private Color(String name, int index, String ddd) {
        this.name = name;
        this.index = index;
        this.tip = ddd;
    }
    // 普通方法
//    public static String getName(int index) {
//        for (Color c : Color.values()) {
//            if (c.getIndex() == index) {
//                return c.name;
//            }
//        }
//        return null;
//    }

    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
