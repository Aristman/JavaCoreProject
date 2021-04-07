package tests.test13;

import java.util.concurrent.Executors;

public class Road extends Stage {

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.threadPool = Executors.newCachedThreadPool();
    }

    @Override
    public void go(Car c) {
        System.out.println(c.getName() + " начал этап: " + description);
        c.beginStage();
        threadPool.execute(() -> runToRoad(c));
    }

    private void runToRoad(Car c) {
        try {
            Thread.sleep(length / c.getSpeed() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            c.endStage();
        }
    }
}
