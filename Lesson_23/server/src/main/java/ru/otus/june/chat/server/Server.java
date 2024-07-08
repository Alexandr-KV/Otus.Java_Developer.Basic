package ru.otus.june.chat.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private int port;
    private HashMap<String, ClientHandler> clientHandlers;
    private AuthenticationProvider authenticationProvider;

    public AuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }

    public Server(int port) {
        this.port = port;
        this.clientHandlers = new HashMap<>();
        this.authenticationProvider = new InMemoryAuthenticationProvider(this);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            authenticationProvider.initialize();
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(this, socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        broadcastMessage("В чат зашел: " + clientHandler.getUsername());
        clientHandlers.put(clientHandler.getUsername(), clientHandler);
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        broadcastMessage("Из чата вышел: " + clientHandler.getUsername());
        clientHandlers.remove(clientHandler.getUsername());
    }

    public synchronized void broadcastMessage(String message) {
        for (HashMap.Entry<String, ClientHandler> entry : clientHandlers.entrySet()) {
            entry.getValue().sendMessage(message);
        }
    }

    public boolean isUsernameBusy(String username) {
        for (HashMap.Entry<String, ClientHandler> entry : clientHandlers.entrySet()) {
            if (entry.getValue().getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void personalMessage(String message, String username1, String username2) {
        clientHandlers.get(username1).sendMessage(message);
        clientHandlers.get(username2).sendMessage(message);
    }

    public ClientHandler getClientHandlerByUsername(String username) {
        return clientHandlers.get(username);
    }
}
