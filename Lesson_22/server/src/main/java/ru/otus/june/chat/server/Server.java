package ru.otus.june.chat.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private HashMap<String, ClientHandler> clientHandlers;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        this.clientHandlers = new HashMap<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(this, socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        broadcastMessage("В чат зашел: " + clientHandler.getUsername());
        clients.add(clientHandler);
        clientHandlers.put(clientHandler.getUsername(), clientHandler);
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        clientHandlers.remove(clientHandler.getUsername());
        broadcastMessage("Из чата вышел: " + clientHandler.getUsername());
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }

    public boolean isUser(String string) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(string)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void personalMessage(String message, String username1, String username2) {
        clientHandlers.get(username1).sendMessage(message);
        clientHandlers.get(username2).sendMessage(message);
    }
}
