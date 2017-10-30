package randomArrayList;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        RandomArrayList opa = new RandomArrayList();
        opa.add(2);
        opa.add(5);
        opa.add(5);
        opa.add(3);
        for (int i = 0; i < 5; i++) {
            System.out.println(opa.getRandomElement());
        }
    }
}
