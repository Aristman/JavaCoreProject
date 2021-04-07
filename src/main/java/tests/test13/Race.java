package tests.test13;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private final ArrayList<Stage> stages;
    private boolean startRace;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public void setStartRace(boolean status) {
        this.startRace = status;
    }

    public boolean isStartRace() {
        return startRace;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        startRace = false;
    }
}
