package tests.test11;

public class Orange extends Fruit {
    private static final String name = "Апельсин";

    public Orange() {
        super(name, 1.5f);
    }

    public Orange(Float weight) {
        super(name, weight);
    }
}
