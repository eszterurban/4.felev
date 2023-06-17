package ex4;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.printf("Usage: java %s <integer> <integer> <integer>\n", Main.class.getName());
            System.exit(1);
        }
        IntegerProperty angle1 = new SimpleIntegerProperty();
        IntegerProperty angle2 = new SimpleIntegerProperty();
        IntegerProperty angle3 = new SimpleIntegerProperty();
        BooleanBinding rightTriangle = new BooleanBinding() {
                {
                    super.bind(angle1, angle2, angle3);
                }
                @Override
                protected boolean computeValue() {
                    return angle1.get() > 0
                            && angle2.get() > 0
                            && angle3.get() > 0
                            && angle1.get() + angle2.get() + angle3.get() == 180
                            && (angle1.get() == 90 || angle2.get() == 90 || angle3.get() == 90);
                }
        };
        angle1.set(Integer.parseInt(args[0]));
        angle2.set(Integer.parseInt(args[1]));
        angle3.set(Integer.parseInt(args[2]));
        System.out.println(rightTriangle.get());
    }

}
