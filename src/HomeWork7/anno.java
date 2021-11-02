package HomeWork7;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class anno {
    static  int i;
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("HomeWork7.t1");
        Method[] methods = clazz.getMethods();
        if (methods != null) {
            for (Method method : methods) {
                before b1 = method.getAnnotation(before.class);
                Boolean b2 = method.isAnnotationPresent(HomeWork7.before.class);
                test t1 = method.getAnnotation(test.class);
                Boolean t2 = method.isAnnotationPresent(HomeWork7.test.class);
                after a1 = method.getAnnotation(after.class);
                Boolean a2 = method.isAnnotationPresent(HomeWork7.after.class);
               if(b2) {
                   for (int i = 0; i <= 1; i++){
                       if (b1.id() == i) {
                           method.invoke(clazz.getConstructor(null).newInstance(null), null);
                       }
                   }
               }

                if(t2) {
                    for (int i = 0; i <= 1; i++){

                        if (t1.id() == i) {
                            method.invoke(clazz.getConstructor(null).newInstance(null), null);
                        }
                    }
                }

                if(a2) {
                    for (int i = 0; i <= 1; i++)
                    {
                        if (a1.id() == i) {
                            method.invoke(clazz.getConstructor(null).newInstance(null), null);
                        }
                    }

                }
            }
        }
    }
}