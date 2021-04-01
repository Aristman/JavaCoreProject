package tests.test11;


import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        Integer[] intArray = new Integer[]{3, 2, 1};
        app.swapItems(intArray, 0, 2);
        app.swapItems(intArray, 1, 0);
        System.out.println(Arrays.toString(intArray));
        System.out.println(app.toArrayList(intArray).getClass());
        System.out.println("Задание 3");
        Box<Apple> box1 = new Box<>(Apple.class);
        Box<Orange> box2 = new Box<>(Orange.class);
        Box<Orange> box3 = new Box<>(Orange.class);
        int addApples = 66;
        int addOranges = 44;
        System.out.printf("В коробку 1 добавили %d яблок\n", addApples);
        System.out.println("В коробке стало яблок  - " + box1.add(addApples));
        System.out.printf("В коробку 2 добавили %d апельсина\n", addOranges);
        System.out.println("В коробке стало апельсин - " + box2.add(addOranges));
        System.out.print("Веса коробок 1 : коробки 2 -> ");
        System.out.println(box1.getWeight() + " : " + box2.getWeight());
        System.out.println("Коробки идентичны по весу? " + box1.compare(box2));
        System.out.println("Вес коробки 3 - " + box3.getWeight());
        System.out.println("Пересыпаем из коробки 2 в коробку 3");
        box2.emptyBoxToBox(box3);
        System.out.println("Коробка 2");
        System.out.println(box2);
        System.out.println("Коробка 3");
        System.out.println(box3);
    }

    // Метод решения второго задания
    private <T> ArrayList<T> toArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    // Метод решени первого задания
    private <T> void swapItems(T[] array, int item1, int item2) {
        T tempItem = array[item1];
        array[item1] = array[item2];
        array[item2] = tempItem;
    }
}
