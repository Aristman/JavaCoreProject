package tests.test6;

public class Dog extends Animal {
    private static int countDogs = 0;

    public Dog(String name) {
        super(name, 500, 10);
        countDogs++;
    }

    // Метод возвращает количество созданных экземпляров класса Собака
    public static int getCountDogs() {
        return countDogs;
    }

    @Override
    public void run(int length) {
        if (length > this.getMaxRunLength()) {
            System.out.printf("Собака не может пробежать %d метров, ", length);
        }
        length = Math.min(length, this.getMaxRunLength());
        System.out.printf("Собака %s пробежал %d метров\n", this.getName(), length);
    }

    @Override
    public void swim(int length) {
        if (length > this.getMaxSwimLength()) {
            System.out.printf("Собака не может проплыть %d метров, ", length);
        }
        length = Math.min(length, this.getMaxSwimLength());
        System.out.printf("Собака %s проплыла %d метров\n", this.getName(), length);

    }
}
