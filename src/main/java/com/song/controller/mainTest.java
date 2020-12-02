package com.song.controller;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@Component
public class mainTest {
    @Value("${asd.a}")
    String wxAppId;

    @Test
    public void getWxAppId() throws IOException {
//        String wxAppId = this.wxAppId;
        System.out.println(this.getg());

        Properties properties = new Properties();
//        InputStream resourceAsStream = this.getClass().getResourceAsStream("/resource/database.properties");
        InputStream InputStream = new FileInputStream(new File("src/main/resources/database.properties"));//new BufferedInputStream(new FileInputStream(new File("src/main/resources/database.properties")));
        properties.load(InputStream);
        Object o = properties.get("asd.a");
        System.out.println(o);
    }

    @Test
    public void dasds() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        Ticks tick = ac.getBean(Ticks.class);
        tick.getTicks();
    }
    @Test
    public void timeTaskRun() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1223423");
            }
        },1000,1000);
    }


    public String getg() {
        return this.wxAppId;
    }
    public static void main(String[] args) {

        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("12344324dfs");
            }
        },10000);
        String[] testArray = { "hi", "hello", "bye", "goodbye" };
        List<String> words = Arrays.asList(testArray);
        Iterator<String> g = words.iterator();
        while (g.hasNext()) {
            System.out.println(g.next());
        }

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("a1aa","a1");
        stringObjectHashMap.put("a2","a2");
        stringObjectHashMap.put("a3","a3");
        stringObjectHashMap.put("a4","a4");
        stringObjectHashMap.put("a5","a5");
        stringObjectHashMap.entrySet().stream().map(a -> a.getValue()+"123").forEach(x-> System.out.println(x));
//        Set<String> strings = stringObjectHashMap.keySet();

//        String s1 = words.stream().filter(word -> word.contains("o")).findFirst().orElse(null);
    }
}
