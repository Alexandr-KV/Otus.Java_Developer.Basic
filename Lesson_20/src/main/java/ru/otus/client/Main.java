package ru.otus.client;


import java.net.Socket;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> operations = Set.of("+", "-", "/", "*");
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
        try (Socket socket = new Socket("localhost", 9000)) {
            PingClient client = new PingClient(socket);
            client.send(firstNumber, secondNumber, operation + "\n");
            double result = client.read();
            System.out.println(result);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Ошибка");
        }
    }

}