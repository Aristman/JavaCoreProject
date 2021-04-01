package tests.test11;


public abstract class Fruit {
    private final Float weight;
    private final String nameFruit;

    public Fruit(String nameFruit, Float weight) {
        this.nameFruit = nameFruit;
        this.weight = weight;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public Float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return nameFruit;
    }
}
