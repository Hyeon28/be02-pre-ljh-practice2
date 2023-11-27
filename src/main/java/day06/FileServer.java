package day06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class FileServer {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress() + "연결됨 \n");

            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String filename = br.readLine();

            System.out.println(filename);

            FileInputStream fileInputStream = new FileInputStream("c:\\test\\" + filename+".txt");

            OutputStream os = clientSocket.getOutputStream();
            byte[] bytes = fileInputStream.readAllBytes();
            for (int i = 0; i < bytes.length; i++) {
                os.write(bytes[i]);
            }

            os.close();
            br.close();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
