package tests.test6;

public class Test {
    public static void main(String[] args) {
        Animal cat1 = new Cat("Барсик");
        Animal cat2 = new Cat("Пират");
        Animal dogBobik = new Dog("Бобик");
        Animal dogBobik2 = new Dog("Шарик");
        Animal dogBobik3 = new Dog("Тузик");
        Animal dogBobik4 = new Dog("Полкан");


        cat1.run(100);
        cat1.swim(100);
        cat2.run(555);
        dogBobik.run(1000);
        dogBobik2.swim(5);
        dogBobik3.swim(25);
        dogBobik4.run(36);
        System.out.println("Всего создано животных - " + Animal.getCountAnimals());
        System.out.println("Создано собак - " + Dog.getCountDogs());
        System.out.println("Создано котов - " + Cat.getCountCats());
    }
}
