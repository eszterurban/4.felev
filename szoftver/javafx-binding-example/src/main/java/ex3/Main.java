package ex3;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.printf("Usage: java %s <number> <number> <number>\n", Main.class.getName());
            System.exit(1);
        }
        DoubleProperty a = new SimpleDoubleProperty();
        DoubleProperty b = new SimpleDoubleProperty();
        DoubleProperty c = new SimpleDoubleProperty();
        BooleanBinding isTriangle = a.greaterThan(0) // a > 0
                .and(b.greaterThan(0)) // b > 0
                .and(c.greaterThan(0)) // c > 0
                .and(a.add(b).greaterThan(c)) // a + b > c
                .and(a.add(c).greaterThan(b)) // a + c > b
                .and(b.add(c).greaterThan(a)); // b + c > a
        a.set(Double.parseDouble(args[0]));
        b.set(Double.parseDouble(args[1]));
        c.set(Double.parseDouble(args[2]));
        System.out.println(isTriangle.get());
    }

}
