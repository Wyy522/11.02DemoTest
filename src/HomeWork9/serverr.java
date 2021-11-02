package HomeWork9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class serverr {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9000);
        System.out.println("服务器已启动...");
        // 启用一个线程 接收客户端
        Thread thread = new Thread(() -> {
            // run方法中:
            while (true) {
                try {
                    // 接收到客户端
                    Socket socket = server.accept();
                    // 获取输入流
                    BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                    // 保证图片名唯一UUID
                    String path = "/home/wyy/桌面/"+ UUID.randomUUID().toString()+".txt";

                    BufferedOutputStream bos = new BufferedOutputStream(
                            //UUID.randomUUID().toString() + ".jpg"默认输出到工程文件路径下
                            //UUID.randomUUID().toString()生成随机字符串 改这里可以更改上传后文件的名字
                            //将文件上传到E盘路径下
                            new FileOutputStream(path));
                    byte[] b = new byte[3 * 1024];
                    int len = -1;
                    while ((len = bis.read(b)) != -1) {
                        bos.write(b, 0, len);
                    }
                    // 关闭资源
                    bos.close();
                    bis.close();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        // 启动线程
        thread.start();
    }
}