/*
 * Домашнее задание занятия 10
 * Выполнил студент Аристов Сергей Константинович
 */

package tests.test10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {
        task1();
        task2();
    }

    private void task1() {
        ArrayList<String> wordArray = new ArrayList<>(Arrays.asList(
                "груша", "киви", "банан", "яблоко", "киви",
                "кран", "кирпич", "кирпич", "кирпич", "мастерок",
                "деревья", "небо", "солнце", "небо", "облако"));
        HashMap<String, Integer> countWords = new HashMap<>();
        for (String word : wordArray) {
            countWords.put(word, countWords.getOrDefault(word, 0) + 1);
        }
        System.out.println("Список уникальных слов:");
        System.out.println(Arrays.toString(wordArray.stream()
                .filter(word -> countWords.get(word) == 1).toArray()));
        System.out.println("Количество слов:");
        countWords.forEach((word, count) ->
                System.out.printf("Слово \"%s\" встречается %d раз%s\n", word, count, getPostfix(count))
        );
    }

    private void task2() {
        PhoneBook book = new PhoneBook();
        book.add("Иванов", "2334234");
        book.add("Иванов", "2334234");
        book.add("Петров", "58873939030");
        book.add("Сидоров", "24872987423");
        book.add("Иванов", "985888484");
        book.add("Васечкин", "59938238823");
        System.out.println("Телефоны.\nИванов");
        System.out.println(book.get("Иванов"));
        System.out.println("Петров");
        System.out.println(book.get("Петров"));
        System.out.println("Пертов");
        System.out.println(book.get("Пертов"));
    }

    // Метод возвращает окончание слова "раз(а)" для формирования числительной строки
    private String getPostfix(Integer count) {
        String postfix = "";
        if (count % 10 > 1 && count % 10 < 5
                && (count < 10 || count > 20)) {
            postfix = "a";
        }
        return postfix;
    }

}
