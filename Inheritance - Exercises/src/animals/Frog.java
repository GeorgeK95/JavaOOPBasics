package animals;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Frog extends Animal {

    Frog(String name, int age, String isMale) {
        super(name, age, isMale);
    }

    @Override
    void produceSound() {
        System.out.println("Frogggg");
    }
}
