package overloadMethod;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class MathOperation {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return this.add(a, b) + c;
    }

    int add(int a, int b, int c, int d) {
        return this.add(a, b, c) + d;
    }
}
