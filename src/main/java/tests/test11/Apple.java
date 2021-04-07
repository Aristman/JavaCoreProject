package tests.test11;

public class Apple extends Fruit {
    static String name = "Яблоко";

    public Apple() {
        super(name, 1.0f);
    }

    public Apple(Float weight) {
        super(name, weight);
    }
}
