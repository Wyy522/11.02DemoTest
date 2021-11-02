package HomeWork9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientt {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("请输入要上传的图片路径");
        Scanner sc=new Scanner(System.in);
        String pathname=sc.nextLine();
        //2启动客户端
        Socket client =new Socket("localhost",9000);
        //3.上传文件
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(pathname));
        BufferedOutputStream bos=new BufferedOutputStream(client.getOutputStream());
        byte[] b=new byte[3*1024];
        int len=-1;
        while((len=bis.read(b))!=-1) {
            bos.write(b,0,len);
        }
        System.out.println("文件上传完毕");
        //关闭资源
        bos.close();
        bis.close();
        client.close();
        sc.close();
        System.out.println("文件上传成功");
    }
}