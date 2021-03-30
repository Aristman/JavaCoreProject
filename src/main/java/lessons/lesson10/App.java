package lessons.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {
        int[] array = new int[5]; //массив
        List myList = new ArrayList();
        myList.add(1);
        myList.add("dsdads");
        myList.add(3.6);
        myList.add(new int[5]);
        myList.add(new App());

        String str = (String) myList.get(1);//для другого номера будет исключение
        System.out.println(str.length());

        List<String> paramList = new ArrayList<>();
        paramList.add("33");
        System.out.println(paramList.get(0).length());
        paramList.forEach(System.out::println);

         List<String> collect = paramList.stream()
                .filter(it -> it.equals("22"))
                .collect(Collectors.toList());

         //  Set -  точно как в Python
        // LinkedHashSet - сохраняет порядок вставки. Проверяет на наличие элемента и если он есть - ничего не делает
    }
}
