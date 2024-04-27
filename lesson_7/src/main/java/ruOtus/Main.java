package ruOtus;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        square(5);//вывод второго метода
        Random random = new Random();
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(-9, 10);
            }
        }//создаем массив с отрицательными и положительными рандомными элементами
        outputOfATwoDimensionalArrayInTheFormOfATable(arr);//вывод созданного массива
        //вывод оставшихся методов в консоль
        System.out.println(sumOfPositiveElements(arr));
        System.out.println(findMax(arr));
        System.out.println(sumOfTheElementsOfTheSecondRow(arr));
        zeroingDiagonalElements(arr);
        outputOfATwoDimensionalArrayInTheFormOfATable(arr);
    }

    //реализация первого метода
    public static int sumOfPositiveElements(int[][] arr) {
        int summa = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    summa += arr[i][j];
                }
            }
        }
        return summa;
    }

    //реализация второго метода
    public static void square(int size) {
        if (size==1){
            System.out.print("*");
            return;
        }
        for (int m = 0; m < size; m++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < size-2; i++) {
            System.out.print("*");
            for (int j = 0; j < size-2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int m = 0; m < size; m++) {
            System.out.print("*");
        }
        System.out.println();
    }

    //реализация третьего метода
    public static void zeroingDiagonalElements(int [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i==j){
                    arr[i][j] = 0;
                }
                if (i+j==arr.length-1){
                    arr[i][j]=0;
                }
            }
        }
    }

    //реализация четвертого метода
    public static int findMax(int[][] array){
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]){
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    //реализация пятого метода
    public static int sumOfTheElementsOfTheSecondRow(int[][] arr){
        if (arr.length > 1) {
            int summa=0;
            for (int i = 0; i < arr[1].length; i++) {
                summa+=arr[1][i];
            }
            return summa;
        } else {
            return -1;
        }
    }

    //метод для вывода двумерного массива в виде таблички
    public static void outputOfATwoDimensionalArrayInTheFormOfATable(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}