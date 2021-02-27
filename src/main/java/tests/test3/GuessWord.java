package tests.test3;

import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    private static final String[] words = {
            "apple", "orange", "lemon", "banana",
            "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom",
            "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        String guessWord = words[new Random().nextInt(words.length)];
        String userWord;
        System.out.println("Загадно слово. Отгадайте его.\nЧисло попыток не ограничено.");
        do {
            System.out.print("Введите ваше слово:");
            userWord = scanner.next();
            if (userWord.equals(guessWord)) {
                System.out.println("Вы отгадали слово. Поздравляю с победой!");
                break;
            }
            StringBuilder responce = new StringBuilder();
            for (int i = 0; i < userWord.length(); i++) {
                if (i >= guessWord.length()) break;
                if (userWord.charAt(i) == guessWord.charAt(i)) {
                    responce.append(userWord.charAt(i));
                } else {
                    responce.append("#");
                }
            }
            if (responce.length() < 15) responce.append("#".repeat(15 - responce.length()));
            System.out.printf("Вы не угадали.\nМакет угаданных букв %s \n", responce);
        } while (true);
    }
}
