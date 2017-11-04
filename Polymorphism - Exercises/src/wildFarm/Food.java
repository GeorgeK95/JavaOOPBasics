package wildFarm;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
abstract class Food {
    private int quantity;

    Food(int quantity) {
        this.setQuantity(quantity);
    }

    int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
