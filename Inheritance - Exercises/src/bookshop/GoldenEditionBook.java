package bookshop;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class GoldenEditionBook extends Book {
    private static final double INCREASE_PERCENTAGE = 0.3;

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() + super.getPrice() * INCREASE_PERCENTAGE;
    }
}
