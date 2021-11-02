package HomeWork5;

import jdk.nashorn.internal.codegen.MethodEmitter;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

public class t1 {
    public String string = new String();

    public void Stringfenkai(HashMap hashMap) throws IOException {
        String path = "/home/wyy/桌面/1.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line = br.readLine()) != null) {
            String s = line;
            String[] ss = s.split("\\s+");
            hashMap.put(ss[0], ss[1]);
        }
//        for (Object key : hashMap.keySet()) {
//            System.out.println("key:" + key + "------value:" + hashMap.get(key));
//        }
    }

    public void ShuJuTpye(HashMap hashMap1) {

        for (Object key : hashMap1.keySet()) {

            if (hashMap1.get(key) instanceof String) {
                hashMap1.put(key, "String");
            } else hashMap1.put(key, "int");
        }
//            if (hashMap1.get(key).equals("aa")) {
//
//            } else
        for (Object key : hashMap1.keySet()) {
            System.out.println("key:" + key + "------value:" + hashMap1.get(key));
        }
    }
    public  void WriteJava(HashMap hashMap1)
    {
        try {
            File writeName = new File
                    ("/home/wyy/文档/IdeaProjects/06-20线下/7-25-test/src/HomeWork5/test1.java"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write("package HomeWork5;\r\n\n\n"); // \r\n即为换行
                out.write("class test1{\r\n"); // \r\n即为换行
                out.write("public test1(){\n}\n");
                for (Object key : hashMap1.keySet()) {
                    out.write("public String "+key+" = "+hashMap1.get(key)+";\n");
                }
                out.write("}\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void FanSheDuiXiang(HashMap hashMap1) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("HomeWork5.test1");
        Object obj =c1.newInstance();
        for (Object key : hashMap1.keySet()) {
            Field field =c1.getDeclaredField((String)key);
            field.setAccessible(true);
            field.set(obj,(String)hashMap1.get(key));
            System.out.println(field.get(obj));
        }
//        Method method= c1.getMethod("getaa",null);
//        System.out.println(method.invoke(obj,null));
    }
}

