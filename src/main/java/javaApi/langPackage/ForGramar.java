package javaApi.langPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class ForGramar {
    public static void main(String[] args) throws ParseException {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i=0;i<10;i++){
            l.add(i);
        }
        Iterator<Integer> i = l.iterator();
        i.next();
        if(i.hasNext()){
            i.remove();
        }
        for (Integer s : l) {
            System.out.println(s);
        }

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("aa", 123);
        stringObjectHashMap.put("bb", 879);
        Stream<Map.Entry<String, Object>> entryStream = stringObjectHashMap.entrySet().stream().filter(v -> v.getKey() == "aa");
        Iterator<Map.Entry<String, Object>> iterator = entryStream.iterator();
        for (Iterator<Map.Entry<String, Object>> it = iterator; it.hasNext(); ) {
            Object o = it.next();
            System.out.println(((Map.Entry) o).getValue());
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm");

        long d = simpleDateFormat.parse("1993-10-30 10:25:36").getTime();
        String format = simpleDateFormat.format(d);
        System.out.println(format);
    }
}
