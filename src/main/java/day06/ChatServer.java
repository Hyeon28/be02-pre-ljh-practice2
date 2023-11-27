package day06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress() + "연결됨 \n");

            //전송
            OutputStream os = clientSocket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            Scanner scanner = new Scanner(System.in);
            System.out.println("클라이언트에게 전송할 메세지를 입력하세요");
            String msg = scanner.nextLine();

            bw.write(msg + "\n");
            bw.flush();


            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String msg1 = br.readLine();
            System.out.println("클라이언트로부터 수신한 메세지");
            System.out.println(msg1);

            clientSocket.close();
            bw.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
