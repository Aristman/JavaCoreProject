package tests.test13;


import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static String WINNER = "";
    private volatile boolean isEndStage;
    private boolean ready;
    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }


    public boolean isReady() {
        return ready;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        isEndStage = true;
        ready = false;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            this.ready = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!race.isStartRace()) {
            Thread.onSpinWait();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            while (!isEndStage) {
                Thread.onSpinWait();
            }
        }
        System.out.printf("%s закончил гонку\n", name);
        synchronized (race) {
            if (WINNER.equals("")) {
                System.out.printf("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> %s победил!\n", name);
                WINNER = name;
            }
        }
    }

    public void beginStage() {
        isEndStage = false;
    }

    public void endStage() {
        isEndStage = true;
    }
}
