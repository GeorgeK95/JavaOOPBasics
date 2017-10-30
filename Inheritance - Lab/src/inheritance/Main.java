package inheritance;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
//        task_1();
//        task_2();
//        task_3();
    }

    private static void task_3() {
        task_1();
        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }

    private static void task_2() {
        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.bark();
        puppy.weep();
    }

    private static void task_1() {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}
