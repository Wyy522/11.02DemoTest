package HomeWork8;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Myrun implements Runnable{
    private Socket s=null;
    public Myrun(Socket s){
        this.s=s;
    }
    @Override
    public void run() {
        try {
//            InputStream in = s.getInputStream();
//            byte[] b = new byte[1024];
//            int len = in.read(b);//block
            String path = "/opt/xxx.myml";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            line = br.readLine();
            String str="HTTP/1.1 200 OK\n" +
                    "Content-Length: 162\n" +
                    "Content-Type:text/html\n\n"+
                    line;
            System.out.println(str);
            OutputStream out = s.getOutputStream();
            out.write(str.getBytes(StandardCharsets.UTF_8));
            out.flush();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(9000,10);
        ExecutorService pool1 = Executors.newCachedThreadPool();
            Socket s = ss.accept();
            pool1.submit(new Myrun(s));
    }
}
