package tests.test12;

import java.util.Arrays;

public class App {
    static final int SIZE = 1_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        App app = new App();
        app.arrayMethod1();
        app.arrayMethod2();
    }

    private void arrayMethod2() {
        float[] array = getArray();
        long beginTime = System.currentTimeMillis();
        float[] array1 = new float[HALF];
        float[] array2 = new float[HALF];
        System.arraycopy(array, 0, array1, 0, HALF);
        System.arraycopy(array, HALF, array2, 0, HALF);
        long endTime = System.currentTimeMillis();
        System.out.printf("Время разбивки массива на две части - %d\n", endTime - beginTime);
        beginTime = endTime;
        Thread thread1 = new Thread(() -> calculateArray(array1));
        Thread thread2 = new Thread(() -> calculateArray(array2));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы по вычислению потоков - %d\n", endTime - beginTime);
        beginTime = endTime;
        System.arraycopy(array1, 0, array, 0, HALF);
        System.arraycopy(array2, 0, array, HALF, HALF);
        endTime = System.currentTimeMillis();
        System.out.printf("Время склейки двух массивов в один результат - %d\n", endTime - beginTime);
    }

    private void arrayMethod1() {
        float[] array = getArray();
        long beginTime = System.currentTimeMillis();
        calculateArray(array);
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы метода 1 - %d\n", endTime - beginTime);
    }

    private void calculateArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private float[] getArray() {
        float[] resultArray = new float[SIZE];
        Arrays.fill(resultArray, 1);
        return resultArray;
    }
}

