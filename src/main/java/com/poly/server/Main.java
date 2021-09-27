package com.poly.server;

import com.poly.server.threads.ServerThread;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        try {
            ServerThread serverThread = new ServerThread(queue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
