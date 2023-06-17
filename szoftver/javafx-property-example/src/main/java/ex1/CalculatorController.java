package ex1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

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
        //number1Field.textProperty().bindBidirectional(calculatorModel.number1Property(), new NumberStringConverter());
        //number2Field.textProperty().bindBidirectional(calculatorModel.number2Property(), new NumberStringConverter());
        StringConverter<? extends Number> converter =  new IntegerStringConverter();
        number1Field.textProperty().bindBidirectional(calculatorModel.number1Property(), (StringConverter<Number>) converter);
        number2Field.textProperty().bindBidirectional(calculatorModel.number2Property(), (StringConverter<Number>) converter);
        resultField.textProperty().bind(calculatorModel.resultProperty().asString());
    }

}
