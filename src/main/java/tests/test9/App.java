package tests.test9;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        App app = new App();
        String[][] a = getIncomeArray();
        System.out.println("Заданный массив");
//        a[2][3] = "w";
        printArray(a);
        try {
            System.out.printf("Сумма элементов массива - %d\n", app.sumArray(a));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.printf("Ошибка преобразования элемента массива [%d, %d]\n", e.getRow(), e.getCol());
            e.printStackTrace();
        }
    }

    /*
     * Метод домашнего задания.
     * Входной массив 4*4.
     * Проброска заданных исключений
     */
    private int sumArray(String[][] inArray) throws MyArraySizeException, MyArrayDataException {
        try {
            if (inArray.length != 4) {
                throw new MyArraySizeException();
            }
            for (String[] arr : inArray) {
                if (arr.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int row = 0; row < inArray.length; row++) {
            for (int col = 0; col < inArray[row].length; col++) {
                try {
                    sum += Integer.parseInt(inArray[row][col]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(row, col);
                }
            }
        }
        return sum;
    }

    private static void printArray(String[][] a) {
        for (String[] rowArray : a) {
            System.out.println(Arrays.toString(rowArray));
        }
    }

    private static String[][] getIncomeArray() {
        String[][] a = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = String.valueOf(i * 4 + j);
            }
        }
        return a;
    }
}
