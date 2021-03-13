package tests.test7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    //    Метод для еды из тарелки. Если запрашиваемое количество больше чем есть в тарелке - возвращается false
    //    Иначе количество еды уменьшается и возвращается true

    public boolean decreaseFood(int decFood) {
        if (decFood <= food) {
            food -= decFood;
            return true;
        }
        return false;
    }

    public int getFood() {
        return food;
    }

    // Метод для добавления еды в тарелку
    public void increaseFood(int incFood) {
        food += incFood;
    }

    public String info() {
        return "Еды на тарелке: " + food;
    }
}
