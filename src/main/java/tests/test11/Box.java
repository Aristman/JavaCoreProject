package tests.test11;


public class Box<C extends Fruit> {

    private Integer value = 0;
    private final C fruitType;

    public Box(Class<C> fruitClass) throws Exception {
        this.fruitType = fruitClass.getDeclaredConstructor().newInstance();

    }

    public Float getWeight() {
        return value * fruitType.getWeight();
    }

    public Integer getValue() {
        return value;
    }

    public void emptyBoxToBox(Box<C> toBox) {
        toBox.add(this.value);
        value = 0;
    }

    public <T extends Fruit> boolean compare(Box<T> compareBox) {
        return (this.getWeight() - compareBox.getWeight() < 0.1);
    }

    public C getFruitType() {
        return fruitType;
    }

    public int add(int i) {
        return value += i;
    }

    @Override
    public String toString() {
        return String.format("Коробка содержит %s в количестве %d штук", fruitType.getNameFruit(), value);
    }
}
