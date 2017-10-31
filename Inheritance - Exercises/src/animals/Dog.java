package animals;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Dog extends Animal {

    Dog(String name, int age, String isMale) {
        super(name, age, isMale);
    }

    @Override
    void produceSound() {
        System.out.println("BauBau");
    }
}
