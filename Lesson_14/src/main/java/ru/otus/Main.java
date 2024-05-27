package ru.otus;

public class Main {
    public static void main(String[] args) {
        String[][] arr1 = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3"}};
        String[][] arr2 = new String[][]{{"1", "2", "3", "4"}, {"a", "b", "c", "d"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] arr3 = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

        try {
            int result = sumOfArrayElements4x4(arr1);
            System.out.println(result);
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = sumOfArrayElements4x4(arr2);
            System.out.println(result);
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = sumOfArrayElements4x4(arr3);
            System.out.println(result);
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.println(e.getMessage());
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