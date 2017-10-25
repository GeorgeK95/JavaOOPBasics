package K_CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();

        while (true) {
            String line = in.nextLine();
            if ("End".equals(line)) {
                String name = in.nextLine();
                print(name, cats);
                break;
            }
            String[] data = line.split("\\s+");
            Cat cat = null;
            switch (data[0]) {
                case "Siamese":
                    cat = new Siamese(data[1], Double.parseDouble(data[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(data[1], Double.parseDouble(data[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(data[1], Double.parseDouble(data[2]));
                    break;
            }

            cats.add(cat);
        }
    }

    private static void print(String name, List<Cat> cats) {
        Cat cat = cats.stream().filter(x -> x.getName().equals(name)).findFirst().get();
        System.out.println(cat);
    }
}
