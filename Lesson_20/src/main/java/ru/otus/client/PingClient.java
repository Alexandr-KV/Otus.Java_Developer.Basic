package ru.otus.client;

import java.io.*;
import java.net.Socket;

public class PingClient {

    private final DataInputStream in;
    private final DataOutputStream out;

    public PingClient(Socket socket) throws IOException {
        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        this.out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void send(int firstNumber, int secondNumbers, String operation) throws IOException {
        out.write(firstNumber);
        out.write(secondNumbers);
        out.write(operation.getBytes());
        out.flush();
    }

    public Double read() throws IOException {
        return in.readDouble();
    }
}
