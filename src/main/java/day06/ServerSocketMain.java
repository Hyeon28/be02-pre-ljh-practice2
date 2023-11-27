package day06;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.ServerSocket;

public class ServerSocketMain {
    public static void main(String[] args) {
        //랜카드와 스트림 사이의 통로를 여는 것
        try {
            ServerSocket serverSocket = new ServerSocket(9999); //서버 스트림, 포트를 listen 상태로 바꿔주는 것

            Socket clientSocket = serverSocket.accept(); //클라리언트 스트림, 서버를 실행하고 클라이언트를 실행해서 접속해야

            System.out.println(clientSocket.getInetAddress());

            InputStream clientinputStream = clientSocket.getInputStream();
            int number = clientinputStream.read();
            System.out.println(number);


            serverSocket.close();
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
