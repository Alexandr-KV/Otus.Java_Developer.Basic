package ru.otus.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

public class PingServer {

    private static final Set<String> OPERATIONS = Set.of("+", "-", "/", "*");

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket client = serverSocket.accept();
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            out.writeUTF(OPERATIONS.toString());
            out.flush();
            processRequest(client);
        }
    }

    public static void processRequest(Socket client) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
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
        out.writeDouble(result);
        out.flush();
    }
}