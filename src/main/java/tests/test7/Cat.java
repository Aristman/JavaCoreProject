/*
 * Класс Cat
 * В классе два конструктора. Один как задано в методичке. Второй с заданием дополнительных параметров: Вес и Пол.
 * По умолчанию вес 5, пол мужской.
 *
 */
package tests.test7;

import java.util.Objects;

public class Cat {
    private static final int DEFAULT_WEIGHT = 5;
    private static final CatSex DEFAULT_SEX = CatSex.MALE;

    private final String name;
    private final CatSex catSex;
    private int appetite;
    private int weight;
    private boolean satiety = false;

    public Cat(String name, int appetite, int weight, CatSex catSex) {
        this.name = name;
        this.appetite = appetite;
        this.weight = weight;
        this.catSex = catSex;
    }

    public Cat(String name, int appetite) {
        this(name, appetite, DEFAULT_WEIGHT, DEFAULT_SEX);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return appetite == cat.appetite &&
                weight == cat.weight &&
                satiety == cat.satiety &&
                name.equals(cat.name) &&
                catSex == cat.catSex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, appetite, weight, catSex, satiety);
    }

    @Override
    public String toString() {
        return catSex.getSex() + " " + name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        if (appetite > 0 && appetite <= this.weight / 2) {
            this.appetite = appetite;
        }
    }

    // Метод для еды из тарелки. После получившегося питания вес кота увеличивается на 50% аппетита
    // Аппетит растет на 1. Если поесть не получилось, то вес уменьшается на 1. Если поел то возвращается true
    public boolean eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            weight += appetite / 2;
            appetite += 1;
            satiety = true;
            return true;
        } else {
            weight--;
            return false;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void getHungry() {
        satiety = false;
    }

    public String info() {
        return String.format("%s, вес %d, %s",
                toString(),
                weight,
                catSex.getSatietyWord(satiety
                )
        );
    }

}
