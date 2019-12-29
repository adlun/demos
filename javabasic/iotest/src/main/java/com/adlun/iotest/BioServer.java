package com.adlun.iotest;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BioServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while(true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            byte[] b = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            while(inputStream.read(b) != -1){
                stringBuilder.append(new String(b, StandardCharsets.UTF_8));
                b = new byte[1024];
            }
            System.out.println("Receive : " + stringBuilder.toString());
            outputStream.write(("welcome," + socket.getInetAddress().getHostAddress()).getBytes(StandardCharsets.UTF_8));
        }
    }
}
