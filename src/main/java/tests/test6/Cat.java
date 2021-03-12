package tests.test6;

public class Cat extends Animal {
    private static int countCats = 0;

    public Cat(String name) {
        super(name, 200, 0);
        countCats++;
    }

    // Метод возвращает количество созданных экземпляров класса Кот
    public static int getCountCats() {
        return countCats;
    }

    @Override
    public void run(int length) {
        if (length > this.getMaxRunLength()) {
            System.out.printf("Кот не может пробежать %d метров, ", length);
        }
        length = Math.min(length, this.getMaxRunLength());
        System.out.printf("Кот %s пробежал %d метров\n", this.getName(), length);
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }
}
