package ru.otus.java.basic.http.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpServer {
    private int port;
    private Dispatcher dispatcher;
    ExecutorService executor = Executors.newFixedThreadPool(3);
    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);


    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                executor.execute(() -> {
                    try {
                        byte[] buffer = new byte[8192];
                        int n = socket.getInputStream().read(buffer);
                        String rawRequest = new String(buffer, 0, n);
                        HttpRequest request = new HttpRequest(rawRequest);
                        request.printInfo();
                        dispatcher.execute(request, socket.getOutputStream());
                    } catch (IOException e) {
                        logger.error("Возникло IOException ",e);
                    }
                });
            }
        } catch (IOException e) {
            logger.error("Возникло IOException ",e);
        }

    }
}
