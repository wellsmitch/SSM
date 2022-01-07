package javaApi.langPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SString {
    public static void main(String[] args) {
        String a = "213.1213";
        Double aDouble = Double.valueOf(a);
//        System.out.println(aDouble);
        new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println(123);
            }
        }).start();

        StringBuilder stringBuilder = new StringBuilder("123t543543");
        int i = stringBuilder.lastIndexOf("123");
//        System.out.println(i);

        StringBuffer asd = new StringBuffer("aaafdsfaasdsdaaa");
        Pattern aar = Pattern.compile("aa");
        Matcher matcher = aar.matcher(asd);
        String bb = a.replaceAll("21", "bb");
        System.out.println(bb);
        System.out.println(Color.GREEN.getTip());

    }
}
