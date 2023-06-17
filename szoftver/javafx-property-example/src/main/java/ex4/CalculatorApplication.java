package ex4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ui.fxml"));
        fxmlLoader.setController(new CalculatorController());
        Parent root = fxmlLoader.load();
        stage.setTitle("JavaFX Property Binding");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
