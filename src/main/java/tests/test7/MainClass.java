/*
 * Домашнее задание №7
 * Студент Аристов Сергей Константинович
 * Реализованы лишние функции для закрепления материала и понимания основ ООП
 *
 */

package tests.test7;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Милка", 4, 8, CatSex.FEMALE);
        cats[1] = new Cat("Мурзик", 4, 8, CatSex.MALE);
        cats[2] = new Cat("Барсик", 5);
        cats[3] = new Cat("Мурка", 3, 10, CatSex.FEMALE);
        printCatsInfo(cats);
        Plate plate = new Plate(12);
        System.out.println(plate.info());
        System.out.println("Кормим всех котов");
        int addFood = 0;
        for (Cat cat : cats) {
            if (!cat.eat(plate)) {
                addFood += cat.getAppetite();
            }
        }
        printCatsInfo(cats);
        addFood -= plate.getFood();
        System.out.println(plate.info());
        System.out.println("Нужно добавить в тарелку " + addFood +
                " еды для того, чтобы накормить оставшихся голодными котов.");
        plate.increaseFood(addFood);
        System.out.println(plate.info());
        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                cat.eat(plate);
            }
        }
        printCatsInfo(cats);
        System.out.println(plate.info());
    }

    private static void printCatsInfo(Cat[] cats) {
        for (Cat cat : cats) {
            System.out.println(cat.info());
        }
    }
}
