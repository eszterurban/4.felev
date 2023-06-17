package ex4;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class CalculatorModel {

    private DoubleProperty number1 = new SimpleDoubleProperty();
    private DoubleProperty number2 = new SimpleDoubleProperty();
    private ReadOnlyDoubleWrapper result = new ReadOnlyDoubleWrapper();

    public CalculatorModel() {
        result.bind(Bindings.add(number1, number2));
    }

    public final double getNumber1() {
        return number1.get();
    }

    public DoubleProperty number1Property() {
        return number1;
    }

    public final void setNumber1(double number1) {
        this.number1.set(number1);
    }

    public final double getNumber2() {
        return number2.get();
    }

    public DoubleProperty number2Property() {
        return number2;
    }

    public final void setNumber2(double number2) {
        this.number2.set(number2);
    }

    public final double getResult() {
        return result.get();
    }

    public ReadOnlyDoubleProperty resultProperty() {
        return result.getReadOnlyProperty();
    }

    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        calculatorModel.setNumber1(Math.PI);
        calculatorModel.setNumber2(Math.PI);
        System.out.printf("%f + %f = %f%n", calculatorModel.getNumber1(), calculatorModel.getNumber2(), calculatorModel.getResult());
    }

}
