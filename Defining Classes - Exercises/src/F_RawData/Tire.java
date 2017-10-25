package F_RawData;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Tire {
    private double pressure;
    private int age;

    Tire(double pressure, int age) {
        this.setPressure(pressure);
        this.setAge(age);
    }

    double getPressure() {
        return pressure;
    }

    private void setPressure(double pressure) {
        this.pressure = pressure;
    }

    int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
