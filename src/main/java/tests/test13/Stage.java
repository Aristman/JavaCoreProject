package tests.test13;

import java.util.concurrent.ExecutorService;

public abstract class Stage {
    protected int length;
    protected String description;
    protected ExecutorService threadPool;

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public abstract void go(Car c);
}
