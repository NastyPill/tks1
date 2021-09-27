package com.poly.server.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

public class ServerThread extends Thread {

    private static Integer PORT = 65432;
    private Queue<String> queue;

    private ServerSocket serverSocket;

    public ServerThread(Queue<String> queue) throws IOException {
        this.serverSocket = new ServerSocket(PORT);
        this.queue = queue;
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket.getInputStream(), clientSocket.getOutputStream(), queue);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
