package ex2;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.printf("Usage: java %s <integer> <integer> <integer>\n", Main.class.getName());
            System.exit(1);
        }
        IntegerProperty a = new SimpleIntegerProperty();
        IntegerProperty b = new SimpleIntegerProperty();
        IntegerProperty c = new SimpleIntegerProperty();
        BooleanBinding result = a.multiply(a).add(b.multiply(b)).isEqualTo(c.multiply(c)); // (a * a) + (b * b) == c * c
        a.set(Integer.parseInt(args[0]));
        b.set(Integer.parseInt(args[1]));
        c.set(Integer.parseInt(args[2]));
        System.out.println(result.get());
    }

}
