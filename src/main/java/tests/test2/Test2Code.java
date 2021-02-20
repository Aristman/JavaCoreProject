package tests.test2;

import java.util.Arrays;

public class Test2Code {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    public static void task1() {
        System.out.println("Задание №1");
        int[] binaryMassive = {1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(Arrays.toString(binaryMassive) + " задан массив");
        for (int i = 0; i < binaryMassive.length; i++) {
            if (binaryMassive[i] == 1) {
                binaryMassive[i] = 0;
                continue;
            }
            binaryMassive[i] = 1;
        }
        System.out.println(Arrays.toString(binaryMassive) + " результат работы");
    }

    private static void task2() {
        System.out.println("Задание №2");
        int[] task2Massive = new int[8];
        for (int i = 0; i < task2Massive.length; i++) {
            task2Massive[i] = i * 3;
        }
        System.out.println("Результат работы - " + Arrays.toString(task2Massive));
    }

    private static void task3() {
        System.out.println("Задание №3");
        int[] arrayOfNumner = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayOfNumner) + " Заданный массив");
        for (int i = 0; i < arrayOfNumner.length; i++) {
            if (arrayOfNumner[i] < 6) {
                arrayOfNumner[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrayOfNumner) + " Результат работы");
    }

    private static void task4() {
        System.out.println("Задание №4");
        int dimension = 5;
        int[][] arrayOfTask4 = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            arrayOfTask4[i][i] = 1;
            arrayOfTask4[i][dimension - i - 1] = 1;
            System.out.println(Arrays.toString(arrayOfTask4[i]));
        }
    }

    private static void task5() {
        int[] task5Array = {1, 224, 3, 9, 11, 4, -5, 2, 0, 8, 9, 1};
        int minNumber = task5Array[0];
        int maxNumber= task5Array[0];
        for (int i = 1; i < task5Array.length; i++) {
            if (task5Array[i] > maxNumber) maxNumber = task5Array[i];
            if (task5Array[i] < minNumber) minNumber = task5Array[i];
        }
        System.out.println("Минимальное число массива = " + minNumber);
        System.out.println("Максимальное число массива = " + maxNumber);
    }

    private static void task6() {

    }

    private static void task7() {

    }
}
