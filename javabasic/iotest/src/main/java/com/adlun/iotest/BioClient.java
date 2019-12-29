package com.adlun.iotest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BioClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8000);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("I'am adlun".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();
        byte[] b = new byte[1024];
        inputStream.read(b);
        System.out.println("receive : " + new String(b,StandardCharsets.UTF_8));
        socket.close();
    }
}
