package com.basename;

import com.basename.enums.WeekDay;
import com.basename.models.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

@SpringBootTest
class SpringbootTestApplicationTests {

    @Test
    void contextLoads() {
        String s1 = "hello";
        String s2 = "hello";
        boolean isequal = s1.equals(s2);
        System.out.println(isequal);
    }

    @Test
    void testEqual(){
        String s1 = "hello";
        String s2 = "Hello";
        String ts = s2.toLowerCase();
        System.out.println(s1.equals(ts));

        System.out.println(s1 == ts);
    }

    @Test
    void test1(){
        String s1 = "hello";

        Integer index = s1.indexOf("l");
        System.out.println(index);
    }

    @Test
    void tes2(){
        String s1 = "  hello";
        System.out.println(s1);
        System.out.println(s1.trim());
    }

    @Test
    void test3(){
        String s1 = "hello";
        String rs = s1.replace("l","tt");
        System.out.println(rs);
    }

    @Test
    void test4(){
        String s1 = "a,b,c,d,e,f";
        String[] strings = s1.split(",");

        System.out.println(strings);
    }

    @Test
    void test5(){
        Integer i = 12;
        String s = String.valueOf(i);
        System.out.println(s);

        String s1 = "12345";

        Integer integer = Integer.parseInt(s1);
        System.out.println(integer);

        Boolean b = Boolean.parseBoolean(s1);
        System.out.println(b);

    }

    @Test
    void test6(){
        StringBuilder stringBuilder = new StringBuilder(100);

        for (int i = 0;i<100;i++){
            stringBuilder.append(",");
            stringBuilder.append(i);
        }

        String s = stringBuilder.toString();

        System.out.println(s);
    }

    @Test
    void test7(){

        String[] strings = {"aook","book","cook","dook"};

        StringJoiner stringJoiner = new StringJoiner(",","HELLO ","!");

        Arrays.asList(strings).forEach(iteam -> stringJoiner.add(iteam));

        System.out.println(stringJoiner.toString());
    }

    @Test
    void test8() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Book.class);

        for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()){
            System.out.println(pd.getName());
            System.out.println(pd.getReadMethod());
            System.out.println(pd.getWriteMethod());
        }
    }

    @Test
    void test9(){
        System.out.println(WeekDay.TWO.ordinal());
        System.out.println(WeekDay.TWO.name());
        System.out.println(WeekDay.TWO.getName());
    }

    @Test
    void test10(){
        Random random = new Random(12345);
        System.out.println(random.nextInt());
    }

}
