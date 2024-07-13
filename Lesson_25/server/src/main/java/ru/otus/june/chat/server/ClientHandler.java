package ru.otus.june.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                System.out.println("Подключился новый клиент");
                while (true) {
                    String message = in.readUTF();
                    if (message.equals("/exit")) {
                        sendMessage("/exitok");
                        return;
                    }
                    if (message.startsWith("/auth ")) {
                        String[] elements = message.split(" ");
                        if (elements.length != 3) {
                            sendMessage("Неверный формат команды /auth");
                            continue;
                        }
                        if (server.getAuthenticationProvider().authenticate(this, elements[1], elements[2])) {
                            break;
                        }
                        continue;
                    }
                    if (message.startsWith("/register ")) {
                        String[] elements = message.split(" ");
                        if (elements.length != 4) {
                            sendMessage("Неверный формат команды /register");
                            continue;
                        }
                        if (server.getAuthenticationProvider().registration(this, elements[1], elements[2], elements[3])) {
                            break;
                        }
                        continue;
                    }
                    sendMessage("Перед работой с чатом необходимо выполнить аутентификацию '/auth login password' или регистрацию '/register login password username'");
                }
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                        if (message.startsWith("/w ")) {
                            String[] words = message.split(" ");
                            if (words.length >= 3 && server.isUsernameBusy(words[1])) {
                                String name = words[1];
                                String[] messageArray = Arrays.copyOfRange(words, 2, words.length);
                                message = String.join(" ", messageArray);
                                server.personalMessage(username + ": (личное сообщение для " + name + ") " + message, name, username);
                            }
                        }
                        if (message.startsWith("/kick ")) {
                            String[] words = message.split(" ");
                            if (words.length == 2 && server.isUsernameBusy(words[1]) && this.isAdmin()) {
                                String name = words[1];
                                if (server.getClientHandlerByUsername(name).isAdmin()) {
                                    this.sendMessage("Нельзя удалить админа из чата!");
                                    continue;
                                }
                                server.getClientHandlerByUsername(name).sendMessage("Вы удалены из чата");
                                server.getClientHandlerByUsername(name).disconnect(false);
                            } else {
                                this.sendMessage("Неправильно введена команда, либо вы не являетесь админом");
                            }
                        }
                        continue;
                    }
                    server.broadcastMessage(username + ": " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect(true);
            }
        }).start();
    }

    public boolean isAdmin() {
        return role.equals("ADMIN");
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(boolean isUnsubscribe) {
        if (isUnsubscribe) {
            server.unsubscribe(this);
        }
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
