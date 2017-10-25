package G_CarSalesman;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Engine {
    private String model;
    private int power;
    private String displacements;
    private String efficiency;

    Engine(String model, int power, String displacements, String efficiency) {
        this.setModel(model);
        this.setPower(power);
        this.setDisplacements(displacements);
        this.setEfficiency(efficiency);
    }

    @Override
    public String toString() {
        String format = String.format("%s:\n    Power: %d\n    Displacement: %s\n    Efficiency: %s", this.getModel(), this.getPower(),
                this.getDisplacements(), this.getEfficiency());
        return format;
    }

    String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    private String getDisplacements() {
        return displacements;
    }

    private void setDisplacements(String displacements) {
        this.displacements = displacements;
    }

    private String getEfficiency() {
        return efficiency;
    }

    private void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
