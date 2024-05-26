package ru.otus;

public class Main {
    public static void main(String[] args) {
        String[][] arr1 = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3"}};
        String[][] arr2 = new String[][]{{"1", "2", "3", "4"}, {"a", "b", "c", "d"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] arr3 = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        //Создаем два массива, один правильный, два других с ошибками
        //Применяем метод к этим массивам  и обрабатываем исключения
        try {
            try {
                int result = sumOfArrayElements4x4(arr1);
                System.out.println(result);
            } catch (AppArraySizeException e) {
                System.out.println("Неверный размер массива");
            }
        } catch (AppArrayDataException e) {
            System.out.println("Неверное значение массива");
            System.out.println("Ошибка в ячейке: (" + e.i + "," + e.j + ")");
        }

        try {
            try {
                int result = sumOfArrayElements4x4(arr2);
                System.out.println(result);
            } catch (AppArraySizeException e) {
                System.out.println("Неверный размер массива");
            }
        } catch (AppArrayDataException e) {
            System.out.println("Неверное значение массива");
            System.out.println("Ошибка в ячейке: (" + e.i + "," + e.j + ")");
        }

        try {
            try {
                int result = sumOfArrayElements4x4(arr3);
                System.out.println(result);
            } catch (AppArraySizeException e) {
                System.out.println("Неверный размер массива");
            }
        } catch (AppArrayDataException e) {
            System.out.println("Неверное значение массива");
            System.out.println("Ошибка в ячейке: (" + e.i + "," + e.j + ")");
        }
    }

    public static int sumOfArrayElements4x4(String[][] arr) throws AppArraySizeException, AppArrayDataException {
        int k = 0;
        if (arr.length != 4) {
            throw new AppArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new AppArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    k += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                }
            }
        }
        return k;
    }
}