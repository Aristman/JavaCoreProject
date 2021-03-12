/*
 * Суперкласс Животное.
 * В конструктор передается кличка животного, максимальные длины бега и плаванья.
 * Кличка выдается при создании и после меняться не может
 *
 */

package tests.test6;


public abstract class Animal{
    private static int countAnimals = 0;
    private final String name;
    private final int maxRunLength;
    private final int maxSwimLength;

    // Конструктор
    public Animal(String name, int maxRunLength, int maxSwimLength) {
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.name = name;
        countAnimals++;
    }

    //Метод возвращает количество созданных экземпляров животных
    public static int getCountAnimals() {
        return countAnimals;
    }

    //Метод для реализации бега животного
    public abstract void run(int length);

    // Метод для реализации плаванья животного
    public abstract void swim(int length);

    // Метод возвращает кличку животного
    public String getName() {
        return name;
    }

    // Метод возвращает максимальную дистанцию для бега
    public int getMaxRunLength() {
        return maxRunLength;
    }

    // Метод возвращает максимальную дистанцию для плаванья
    public int getMaxSwimLength() {
        return maxSwimLength;
    }
}
