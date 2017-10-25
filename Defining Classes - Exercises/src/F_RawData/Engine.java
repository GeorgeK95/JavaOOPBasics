package F_RawData;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Engine {
    private int engineSpeed;
    private int enginePower;

    Engine(int engineSpeed, int enginePower) {
        this.setEngineSpeed(engineSpeed);
        this.setEnginePower(enginePower);
    }

    int getEngineSpeed() {
        return engineSpeed;
    }

    private void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    int getEnginePower() {
        return enginePower;
    }

    private void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
