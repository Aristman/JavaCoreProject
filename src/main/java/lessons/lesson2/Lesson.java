package lessons.lesson2;

public class Lesson {
    static int a = 10;

    public static void main(String[] args) {
        // области видимости переменных
        System.out.println(a);
        int a = 50;
        System.out.println(a);
        method1();
        // объявление массива
        int[] b = new int[100];
        int[] c = {1,2,3,4,5,5,6,4,233,23,1,1};
        System.out.println(c[4]);
        System.out.println(factorial(5));
    }

    static public void method1() {
        System.out.println(a);
    }

    static public long factorial(int n) {
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
