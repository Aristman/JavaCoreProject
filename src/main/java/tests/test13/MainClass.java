package tests.test13;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (Car car : cars) {
            threadPool.execute(car);
        }
        while (!race.isStartRace()) {
            boolean statusStartRace = true;
            for (Car car : cars) {
                statusStartRace &= car.isReady();
            }
            race.setStartRace(statusStartRace);
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
        }
        for (Stage stage : race.getStages()) {
            stage.getThreadPool().shutdown();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

