package ex3;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.function.UnaryOperator;

public class CalculatorController {

    @FXML
    private TextField number1Field;

    @FXML
    private TextField number2Field;

    @FXML
    private TextField resultField;

    private CalculatorModel calculatorModel = new CalculatorModel();

    @FXML
    private void initialize() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getControlNewText().matches("[+-]?\\d*")) {
                return change;
            } else {
                return null;
            }
        };
        number1Field.setTextFormatter(new TextFormatter<>(filter));
        number2Field.setTextFormatter(new TextFormatter<>(filter));
        StringConverter<? extends Number> converter = new IntegerStringConverter();
        number1Field.textProperty().bindBidirectional(calculatorModel.number1Property(), (StringConverter<Number>) converter);
        number2Field.textProperty().bindBidirectional(calculatorModel.number2Property(), (StringConverter<Number>) converter);
        resultField.textProperty().bind(calculatorModel.resultProperty().asString());
    }

}
