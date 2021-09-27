package com.poly.server.threads;

import java.io.*;
import java.util.Queue;

public class ClientThread extends Thread {

    private BufferedReader reader;
    private PrintWriter writer;
    private Queue queue;

    public ClientThread(InputStream inputStream, OutputStream outputStream, Queue<String> queue) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.writer = new PrintWriter(new OutputStreamWriter(outputStream), true);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (reader.ready()) {
                    // todo read message and share
                    String msg = reader.readLine();
                    System.out.println(msg);
                    queue.add(msg);
                }
                if(!queue.isEmpty()) {
                    System.out.println(queue.peek() + "IFIFIIF");
                    writer.println(queue.poll() + "\r\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
