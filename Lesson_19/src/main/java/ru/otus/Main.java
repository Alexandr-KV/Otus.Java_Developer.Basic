package ru.otus;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File folder = new File("files");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> fileNames = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }
        for (String name : fileNames) {
            System.out.print(name + " ");
        }
        System.out.println();
        System.out.println("Выберите файл, с которым хотите работать:");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        String filePath = "files/" + fileName;
        readingBasedOnEncoding(filePath);
        System.out.println();
        System.out.println("Введите строку");
        String str = in.nextLine();
        bufferedWriteToFile(filePath, str);
        System.out.println("Строка записана в файл");
    }

    public static void bufferedWriteToFile(String filepath, String str) {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filepath))) {
            byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readingBasedOnEncoding(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            int n = reader.read();
            while (n != -1) {
                System.out.print((char) n);
                n = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}