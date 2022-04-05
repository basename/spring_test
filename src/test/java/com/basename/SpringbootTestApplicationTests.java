package com.basename;

import com.basename.config.DatasourceConfiguration;
import com.basename.enums.WeekDay;
import com.basename.models.pojo.Book;
import com.basename.threds.*;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.reactive.GenericReactiveTransaction;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.print.DocFlavor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static com.fasterxml.jackson.core.JsonEncoding.UTF8;

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

    @Test
    void testProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/application.properties", StandardCharsets.UTF_8));

        String property = properties.getProperty("server.port");

        System.out.println(property);
    }

    @Test
    void testSet(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(5);
        set.add(3);

        System.out.println(set.size());

        System.out.println(set.contains(1));

        System.out.println(set);

        for (Integer integer : set){
            System.out.println(integer);
        }
    }

    @Test
    void testQueur(){
        Queue<String> queue = new LinkedList<>();

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue);
    }

    @Test
    void testPriorityQueue(){
        Queue<String> queue = new PriorityQueue<>();

        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banana");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    void testDuque(){
        Deque<String> deque = new LinkedList<>();

        deque.addLast("a");

        deque.addLast("b");

        deque.addLast("c");

        System.out.println(deque);

        String s = deque.removeFirst();
        System.out.println(s);
    }

    @Test
    void testStack(){
        Deque<Integer> deque = new LinkedList<>();

        deque.push(1);
        deque.push(2);
        deque.push(3);

        for(;true;){
            if (deque.size() <= 0){
                break;
            }
            Integer pop = deque.pop();
            System.out.println(pop);
        }
    }

    @Test
    void testIterator(){
        List<String> arrayList = List.of("a","b");

        for (String s : arrayList){
            System.out.println(s);
        }
    }

    @Test
    void testShuffle(){
        List<Integer> list = new ArrayList<>();

        for (Integer i = 0;i < 15;i++){
            list.add(i);
        }

        System.out.println(list);

        Collections.shuffle(list);

        System.out.println(list);
    }

    @Test
    void testFile() throws IOException {
        File file = new File("src/main/resources/application.properties");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.separator);
    }

    @Test
    void testTime(){
        Date date = new Date();

        System.out.println(date.getTime());
        System.out.println(date.getYear()+1900);
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDate());

        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);

    }

    @Test
    void testLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
    }

    @Test
    void testDateFormat(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

        ZonedDateTime zdt = ZonedDateTime.now();

        String format = dateTimeFormatter.format(zdt);

        System.out.println(format);
    }

    @Test
    void testVar(){
        var localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    @Test
    void testUrlEncode(){
        String encoded = URLEncoder.encode("中文",StandardCharsets.UTF_8);
        System.out.println(encoded);

        String aaa = URLEncoder.encode("胜多负少", StandardCharsets.UTF_8);
        System.out.println(aaa);
    }

    @Test
    void testBase64() throws NoSuchAlgorithmException {
        String s = "123445";
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        md.update(s.getBytes(StandardCharsets.UTF_8));

        String s1 = md.digest().toString();
        System.out.println(s1);

    }

    @Test
    void testHmac() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HamcMD5");

        SecretKey key = keyGenerator.generateKey();

        byte[] skey = key.getEncoded();

    }

    @Test
    void testThread(){
        TaskThred taskThred = new TaskThred();
        taskThred.start();
    }

    @Test
    void testRunnable(){

        System.out.println("开始多线程执行任务-------");

        //获取用户基本信息
        TaskRunnable taskRunnable = new TaskRunnable();
        Thread t = new Thread(taskRunnable);
        t.setDaemon(true);
        t.start();
        taskRunnable.setRunning(false);

        //获取用户扩展信息
        TaskRunnable1 taskRunnable1 = new TaskRunnable1();
        Thread thread = new Thread(taskRunnable1);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //合并用户信息输出
        List<Integer> list = taskRunnable.getList();
        List<Integer> list1 = taskRunnable1.getList();

        List<Integer> totalList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer total = list.get(i) + list1.get(i);
            totalList.add(total);
        }

        System.out.println(totalList);
        System.out.println("多线程任务启动结束-------");
    }

    @Test
    void testCounter(){
        //启动第一个线程
        AddTask addTask = new AddTask();
        Thread  addThread = new Thread(addTask);
        addThread.start();
        try {
            addThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动第二个线程
        DesTask desTask = new DesTask();
        Thread desThread = new Thread(desTask);
        desThread.start();
        try {
            desThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Counter.count);
    }

    @Test
    void testSynchronized(){
       QuqueTask ququeTask = new QuqueTask();
       Thread thread = new Thread(ququeTask);
       thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Task task = new Task();
        System.out.println(task.getTask());
    }

    @Test
    void testReentrantLock(){
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("a","1");

        System.out.println(map);
    }

    @Test
    void testStream(){
        Stream<Integer>  stream = Stream.of(1,2,3,4,5,6,7,8);

        stream.forEach(System.out::println);

        Stream<String> stream1 = Arrays.stream(new String[]{"a", "b", "c"});
        stream1.forEach(s -> System.out.println(s));

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream3 = stream2.map(n -> n * n);
        stream3.forEach(s -> System.out.println(s));
    }

    @Test
    void testJson() throws IOException {
        JsonFactory jsonFactory = new JsonFactory();

        JsonGenerator generator = jsonFactory.createGenerator(System.out, UTF8);
        try {
            generator.writeStartObject();
            generator.writeStringField("name","yanzhengke");
            generator.writeNumberField("age",18);

            generator.writeEndObject();
        } finally {
            generator.close();
        }
    }

    @Test
    void testJsonRes(){
        JsonFactory jsonFactory = new JsonFactory();

        try(JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out, UTF8)){
                jsonGenerator.writeStartObject();

                jsonGenerator.writeStringField("name","yanzhengke");
                jsonGenerator.writeNumberField("age",18);

                jsonGenerator.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testJson1(){
        JsonFactory jsonFactory = new JsonFactory();

            try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out, UTF8)) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName("zhName");
                jsonGenerator.writeEndObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Test
    void testJson2() {
        JsonFactory jsonFactory = new JsonFactory();

        try {
            JsonGenerator generator = jsonFactory.createGenerator(System.out, UTF8);

            generator.writeStartObject();

            generator.writeFieldName("chName");
            generator.writeString("zhengke");

            generator.writeFieldName("age");
            generator.writeString("18");

            generator.writeEndObject();
            generator.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testJson3(){
        JsonFactory jsonFactory = new JsonFactory();
        try (JsonGenerator generator = jsonFactory.createGenerator(System.out, UTF8)){
            generator.writeStartObject();

            generator.writeFieldName("zhName");
            generator.writeString("zhengke");

            generator.writeFieldName("person");
            generator.writeStartObject();
            generator.writeStringField("name","yanzhengke");

            generator.writeNumberField("age",18);
            generator.writeBooleanField("isboull",false);

            generator.writeEndObject();

            generator.writeEndObject();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testJson4(){

        JsonFactory jsonFactory = new JsonFactory();

        try {
            JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out,UTF8);

            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("zhName");
            jsonGenerator.writeString("zhengke");

            jsonGenerator.writeFieldName("objects");
            jsonGenerator.writeStartArray();

            jsonGenerator.writeString("yourname");

            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name","haohao");
            jsonGenerator.writeEndObject();

            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();

            jsonGenerator.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testJson5(){

        JsonFactory jsonFactory = new JsonFactory();
        try {
            JsonGenerator generator = jsonFactory.createGenerator(System.out, UTF8);

            //写入数据开始
            generator.writeStartObject();

            generator.writeFieldName("dags");
            int[] ints = new int[]{1,2,3,4,56,6};
            generator.writeArray(ints,0,ints.length - 1);

            generator.writeEndObject();
            generator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testJson6(){
        JsonFactory jsonFactory = new JsonFactory();

        try {
            JsonGenerator generator = jsonFactory.createGenerator(System.out, UTF8);

            generator.writeStartObject();

            generator.writeFieldName("success");
            generator.writeBoolean(true);

            generator.writeFieldName("myName");
            generator.writeNull();

            generator.writeEndObject();
            generator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testJson8(){
        JsonFactory jsonFactory = new JsonFactory();
        try {
            JsonGenerator generator = jsonFactory.createGenerator(System.out, UTF8);

            generator.writeStartObject();

            generator.writeBooleanField("success",true);
            generator.writeNullField("data");
            generator.writeStringField("name","zhengke");
            generator.writeNumberField("age",18);
//            generator.writeArrayFieldStart();
            generator.writeEndObject();
            generator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testJson9(){
        JsonFactory jsonFactory = new JsonFactory();

        try {
            JsonGenerator generator = jsonFactory.createGenerator(System.out, UTF8);

            generator.writeStartObject();

            generator.writeRaw("{'name':'zhengke'}");

            generator.writeEndObject();

            generator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testJson10() throws JsonProcessingException {
        Book book = new Book();
        book.setId(1);
        book.setName("name");
        book.setType("type");
        book.setDescription("descripton");

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
        System.out.println(s);

    }

    @Test
    void testConfigutration(){
        DatasourceConfiguration datasourceConfiguration = new DatasourceConfiguration();
        System.out.println(datasourceConfiguration);
    }
}
