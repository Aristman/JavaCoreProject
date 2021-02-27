package tests.test3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int countTry = 3;
        int userNumber = 0;
        int guessNumber;
        do {
            guessNumber = randomNumber.nextInt(10);
            System.out.printf("Загадано число от 0 до 9. Отгадайте его за %d попыток\n", countTry);

            for (int stage = 1; stage <= countTry; stage++) {
                System.out.printf("Попытка %d. Введите ваше число: ", stage);
                userNumber = scanner.nextInt();
                if (userNumber < guessNumber) {
                    System.out.printf("Загаданное число больше, чем %d\n", userNumber);
                } else if (userNumber > guessNumber) {
                    System.out.printf("Загаданное число меньше, чем %d\n", userNumber);
                } else {
                    System.out.println("Поздравляю! Вы отгадали загаданное число!");
                    break;
                }
            }
            if (userNumber != guessNumber) {
                System.out.printf("Было загадано число %d\n", guessNumber);
            }
            System.out.print("Повторить игру? (1-да, 0-нет):");

        } while (scanner.nextInt() == 1);
    }
}
