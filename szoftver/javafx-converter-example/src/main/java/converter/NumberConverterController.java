package converter;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NumberConverterController {

    @FXML
    private TextField decimalNumber;

    @FXML
    private TextField binaryNumber;

    @FXML
    private TextField octalNumber;

    @FXML
    private TextField hexadecimalNumber;

    @FXML
    private void initialize() {
        decimalNumber.textProperty().bindBidirectional(binaryNumber.textProperty(), new NumberSystemConverter(10, 2));
        decimalNumber.textProperty().bindBidirectional(octalNumber.textProperty(), new NumberSystemConverter(10, 8));
        decimalNumber.textProperty().bindBidirectional(hexadecimalNumber.textProperty(), new NumberSystemConverter(10, 16));
    }

}
