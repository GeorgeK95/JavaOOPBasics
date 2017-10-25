package F_RawData;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Cargo {
    private String cargoType;
    private int cargoWeight;

    Cargo(String cargoType, int cargoWeight) {
        this.setCargoWeight(cargoWeight);
        this.setCargoType(cargoType);
    }

    String getCargoType() {
        return cargoType;
    }

    private void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    int getCargoWeight() {
        return cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}
