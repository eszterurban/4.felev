package ex3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;

public class CalculatorModel {

    private IntegerProperty number1 = new SimpleIntegerProperty();
    private IntegerProperty number2 = new SimpleIntegerProperty();
    private ReadOnlyIntegerWrapper result = new ReadOnlyIntegerWrapper();

    public CalculatorModel() {
        result.bind(Bindings.add(number1, number2));
    }

    public final int getNumber1() {
        return number1.get();
    }

    public IntegerProperty number1Property() {
        return number1;
    }

    public final void setNumber1(int number1) {
        this.number1.set(number1);
    }

    public final int getNumber2() {
        return number2.get();
    }

    public IntegerProperty number2Property() {
        return number2;
    }

    public final void setNumber2(int number2) {
        this.number2.set(number2);
    }

    public final int getResult() {
        return result.get();
    }

    public ReadOnlyIntegerProperty resultProperty() {
        return result.getReadOnlyProperty();
    }

    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        calculatorModel.setNumber1(13);
        calculatorModel.setNumber2(4);
        System.out.printf("%d + %d = %d%n", calculatorModel.getNumber1(), calculatorModel.getNumber2(), calculatorModel.getResult());
    }

}
