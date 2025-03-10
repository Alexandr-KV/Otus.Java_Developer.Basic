package ru.otus.client;


import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9000)) {
            PingClient client = new PingClient(socket);
            Scanner scanner = new Scanner(System.in);
            String operations = client.readLine();
            System.out.println("Введите одну из операций: " + operations);
            String operation = scanner.nextLine();
            if (!operations.contains(operation)) {
                System.out.println("Введена неверная операция");
                return;
            }
            System.out.println("Введите первое целое число");
            int firstNumber = scanner.nextInt();
            System.out.println("Введите второе целое число");
            int secondNumber = scanner.nextInt();

            client.send(firstNumber, secondNumber, operation + "\n");
            double result = client.readDouble();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Не удалось подключиться к серверу");
        }
    }

}