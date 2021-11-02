package HomeWork5;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Scanner;

public class t {
    static HashMap <String,String> hashMap1 =new HashMap();
    public static void main(String[] args) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException {

          t1 x=new t1();
        x.Stringfenkai(hashMap1);
        //x.ShuJuTpye(hashMap1);
        //x.WriteJava(hashMap1);
        x.FanSheDuiXiang(hashMap1);
    }
}
