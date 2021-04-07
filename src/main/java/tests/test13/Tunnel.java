package tests.test13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tunnel extends Stage {
    private final ExecutorService threadPool;

    public Tunnel(int maxCars) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.threadPool = Executors.newFixedThreadPool(maxCars);
        this.threadPool.shutdown();
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            c.beginStage();
            threadPool.execute(() -> goInTunnel(c));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goInTunnel(Car c) {
        System.out.println(c.getName() + " начал этап: " + description);
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
