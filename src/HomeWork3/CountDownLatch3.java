package HomeWork3;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatch3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc =new Scanner(System.in);
        int a=sc.nextInt();
        CountDownLatch cdl =new CountDownLatch(a);

        while(true) {
            System.out.println("需要定闹钟吗");
            String t = sc.next();
            if(t!="yes") {
                System.out.println("请输入闹钟时间和事情");
                Scanner s1 = new Scanner(System.in);
                int n = s1.nextInt();
                String s = s1.next();
                //Scanner s2 =new Scanner(System.in);
                Meesage meesage = new Meesage(n, s);
                Mythread mythread = new Mythread(cdl, meesage);
                mythread.start();
            } else {
                System.out.println("已退出");
                break;
            }
        }
    }
}
class Mythread extends Thread {

    public CountDownLatch cdl ;
    public  Meesage meesage;
    static ArrayList<Meesage> m1 = new ArrayList<>();
    public Mythread(CountDownLatch cdl, Meesage meesage) {
        this.cdl = cdl;
        this.meesage = meesage;
    }
    public synchronized void run() {
            m1.add(meesage);
            try {
                System.out.println(meesage.time+"秒后叫我"+meesage.thing);
                cdl.await(meesage.time, TimeUnit.SECONDS);
                    System.out.println("以提醒我"+meesage.thing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cdl.countDown();
    }
//    public static void PriMessage() {
//        for (Meesage value : m1) {
//            System.out.println(value.time);
//        }
//    }
}
class Meesage {
    int time;
    String thing;

    public  Meesage(int time, String thing) {
        this.time = time;
        this.thing = thing;
    }
}
