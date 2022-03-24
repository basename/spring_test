package com.basename;

import com.basename.enums.WeekDay;
import com.basename.models.pojo.Book;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.SchemaOutputResolver;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetPermission;
import java.util.*;

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

    @Test
    void test11(){
        String s = "abc";

        try {
            Integer i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test12() throws NoSuchFieldException {
        @Data
        class AAA{
            private Integer age;
            private String name;

            public AAA(Integer age, String name) {
                this.age = age;
                this.name = name;
            }
        }

        AAA aaa = new AAA(19,"jack");

        Class aaaClass = aaa.getClass();

        Field name = aaaClass.getDeclaredField("name");
        System.out.println(name);

        Method[] methods = aaaClass.getMethods();

        for (Method method : methods){
            String name1 = method.getName();

        }

    }

    @Test
    void test13(){
        ArrayList<String>  arrayList = new ArrayList<>(10);

        arrayList.add("aaa");
        arrayList.add("sdfds");

        System.out.println(arrayList.toString());
    }

    @Test
    void test14(){

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.remove(1);

        for (Iterator<String> it = arrayList.iterator();it.hasNext();){
            String next = it.next();
            System.out.println(next);
        }

        for (String it : arrayList){
            System.out.println(it);
        }

        String[] strings = arrayList.toArray(new String[arrayList.size()]);
        System.out.println(strings);

    }

    @Test
    void test15(){
        HashMap<String,Integer> hashMap = new HashMap<>();

        hashMap.put("小明",59);
        hashMap.put("小红",99);
        hashMap.put("小刚",88);

        for (String key : hashMap.keySet()){
            Integer score = hashMap.get(key);
            System.out.print(key+" ===== ");
            System.out.println(score);
        }
    }

    @Test
    void test16(){
        ArrayList<Student> studentList = new ArrayList<>();
        
        Student student = new Student("小明",59);
        studentList.add(student);
        
        Student studentg = new Student("小刚",88);
        studentList.add(studentg);
        
        Students students = new Students(studentList);

        Integer score = students.getScore("小明");


    }

    class Students{
        ArrayList<Student> studentList;
        HashMap<String,Integer> mapCache;

        public Students(List<Student> studentList){
            this.studentList = (ArrayList<Student>) studentList;
            this.mapCache = new HashMap<>();
        }

        public Integer getScore(String name){
            Integer score = null;

            if (this.mapCache.containsKey(name)){
                System.out.println("======查缓存里的数据了======");
                score = this.mapCache.get(name);
            }else {
                System.out.println("======查列表里的数据了======");
                for (Student student : this.studentList){
                    String sname = student.getName();
                    if (sname.equals(name)){
                        score = student.getScore();
                        this.mapCache.put(name,score);
                    }
                }
            }
            return  score;
        }
    }

    @Data
    class Student{
        private String name;
        private Integer score;

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }

}
