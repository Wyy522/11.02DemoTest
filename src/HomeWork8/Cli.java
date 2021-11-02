package HomeWork8;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Cli {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket();
        s.bind(new InetSocketAddress(6666));//绑定本地端口
        s.connect(new InetSocketAddress("localhost", 9000));//连接远程服务端接口
        OutputStream out=s.getOutputStream();
        String path = "/opt/xxx.myml";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line = br.readLine()) != null) {
            out.write((line+"\n" ).getBytes(StandardCharsets.UTF_8));
        }
        out.flush();
        InputStream in = s.getInputStream();
        byte[] b = new byte[1024];
        int len = in.read(b);//block
        String str=new String(b);
        System.out.println(str);
        System.in.read();
        s.close();
    }
}
