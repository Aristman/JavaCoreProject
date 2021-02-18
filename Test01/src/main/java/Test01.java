public class Test01 {

    public static void main(String[] args) {
        byte b = 126;
        short sh = 250;
        int in = 1022;
        long lo = 23452;
        float fl1 = 123.12f;
        double dou = 123.456;
        char ch = 'F';
        boolean bo = false;
        String str = "First string";

/*        System.out.println(calculate(1.2f, 2.5f,66.54f, 222.5f));
        System.out.println(between10and20(12, 14));
        printSingNumber(-4);
        printSingNumber(0);
        printSingNumber(3333);
        System.out.println(isNegative(-4));
        System.out.println(isNegative(44));
        helloString("Sergey");
        leapYear(2000);
        leapYear(1999);
        leapYear(400);
        leapYear(300);*/
    }

    // Вычисление по заданной формуле
    public static float calculate(float a, float b, float c, float d) {
        return a * (b + c / d);
    }

    // Определение нахождения заданного числа между 10 и 20
    public static boolean between10and20(int n1, int n2) {
        int sum = n1 + n2;
        return (sum >= 10 && sum <= 20);
    }

    // Печать в консоль положительное или отрицательное ли заданное число
    public static void printSingNumber(int n) {
        if (n < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    // Проверка заданного числа на отрицательность
    public static boolean isNegative(int n) {
        return n < 0;
    }

    // Печать в консоль строки приветствия
    public static void helloString(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // Определение високосности заданного года
    public static void leapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}
