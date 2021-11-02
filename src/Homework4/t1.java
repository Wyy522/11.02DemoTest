package Homework4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Arch{
    int sale(int a);
}
class MyIBM implements Arch{

    @Override
    public int sale(int a) {
        System.out.println("ibm的电脑:"+a);
        return 12;
    }
}
class MyHW implements Arch{

    @Override
    public int sale(int a) {
        System.out.println("交换机:"+a);
        return 12;
    }
}
class MyHandler implements InvocationHandler {
    private Arch ibm;
    public MyHandler(Arch ibm){
        this.ibm=ibm;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("送鼠标");
        int c= (int) method.invoke(this.ibm,args);
        System.out.println("送键盘");
        return c;
    }
}
public class t1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String str="com.MyHW";
        Arch a= (Arch) Proxy.newProxyInstance(Arch.class.getClassLoader(),
                new Class[]{Arch.class},
                new MyHandler((Arch) Class.forName(str).newInstance()));
        int c=a.sale(11);
        System.out.println(c);
    }
}