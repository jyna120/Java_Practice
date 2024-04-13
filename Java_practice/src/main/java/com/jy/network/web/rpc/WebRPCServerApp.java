package com.jy.network.web.rpc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 네트워크 실습문제
public class WebRPCServerApp {
    public static void main(String[] args) {
        int port = 80;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[서버 대기중...]");
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "로부터 웹요청...");

            Thread choiceThread = new Thread(() -> {
                try (
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                ) {
                    System.out.println(br.readLine());
                    String header = """
                            HTTP/1.1 200 OK
                            Content-Type : text/html;charset=UTF-8 
                            """;
                    String body = """
                            <h1>가위바위보 선택 페이지</h1>
                            사용자는 가위 ✌, 바위 🤛,  보🖐를 선택할 수 있습니다.
                            <br></br>
                            <a href="/result?value=1">가위✌</a>
                            <a href="/result?value=2">바위🤛</a>
                            <a href="/result?value=3">보🖐</a>
                            """;
                    pw.println(header);
                    pw.println();
                    pw.println(body);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            choiceThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            System.out.println("[서버 대기중...]");
//            Socket socket = serverSocket.accept();
//            System.out.println(socket.getInetAddress().getHostAddress() + "로부터 웹요청...");
//
//            Thread resultThread = new Thread(() -> {
//                try (
//                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//                ) {
//                    System.out.println(br.readLine());
//
//                    String header = """
//                            HTTP/1.1 200 OK
//                            Content-Type : text/html;charset=UTF-8
//                            """;
//                    String body = """
//                            <h1>가위바위보 결과 페이지</h1>
//                            """;
//                    if ()
//                        pw.println(header);
//                    pw.println();
//                    pw.println(body);
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            resultThread.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
