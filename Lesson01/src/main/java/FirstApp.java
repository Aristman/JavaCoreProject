import java.util.Scanner;

public class FirstApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        System.out.println("Hello, " + name);
        int a = 255;
        byte b = (byte) 255; // будет переполнение. Результа -1
        System.out.println(a);
    }
}
