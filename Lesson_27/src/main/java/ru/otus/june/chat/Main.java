package ru.otus.june.chat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean isFileExist = false;
        String fileName = null;
        while (!isFileExist) {
            System.out.println("Введите имя файла");
            fileName = in.nextLine();
            File file = new File(fileName);
            if (file.exists()) {
                isFileExist = true;
            } else {
                System.out.println("Данного файла не существует");
            }
        }
        System.out.println("Введите искомую последовательность");
        String sequence = in.nextLine();
        System.out.println("Данная последовательность встречается " + sequenceCounting(fileName, sequence) + " раз");
    }

    public static int sequenceCounting(String fileName, String sequence) {
        int result = 0;
        if (sequence.isEmpty()){
            return 0;
        }
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            String data = new String(bytes, StandardCharsets.UTF_8);
            int indexOfSequence = data.indexOf(sequence);
            while (indexOfSequence != -1) {
                data = data.replaceFirst(sequence, "");
                result += 1;
                indexOfSequence = data.indexOf(sequence);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}