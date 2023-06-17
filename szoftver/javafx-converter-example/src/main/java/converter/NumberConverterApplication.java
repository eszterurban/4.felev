package converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NumberConverterApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ui.fxml"));
        stage.setTitle("JavaFX Number Converter");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
