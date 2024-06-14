package ru.otus.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket client = serverSocket.accept();
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            processRequest(client);
        }
    }

    public static void processRequest(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        int firstNumber = in.read();
        int secondNumber = in.read();
        String operation = in.readLine();
        double result;
        if (operation.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (operation.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operation.equals("*")) {
            result = firstNumber * secondNumber;
        } else if (operation.equals("/")) {
            result = (double) firstNumber / (double) secondNumber;
        } else {
            result = 0;
        }
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        out.writeDouble(result);
        out.flush();
    }
}