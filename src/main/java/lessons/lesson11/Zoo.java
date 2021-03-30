package lessons.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Zoo<T> {

    private List<T> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public boolean encade(T animal) {
        return animals.add(animal);
    }

    public T release(T animal) {
        if (animals.contains(animal)) {
            animals.remove(animal);
            return animal;
        } else {
            return null;
        }
    }

    public static <A> Zoo<A> createZoo() {
        return new Zoo<>();
    }

}
