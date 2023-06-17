package iranyito;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class NyitoIranyito {

    @FXML
    private TextField FeherJatekosNevmezo;

    @FXML
    private TextField FeketeJatekosNevmezo;

    @FXML
    private Label errorMezo;

    @FXML
    public Button startGomb;
    @FXML
    public Button ujJatekGomb;

    @FXML
    private void startAction(ActionEvent actionEvent) throws IOException {
        startJatek();
    }

    private void startJatek() throws IOException {
        if (FeherJatekosNevmezo.getText().isEmpty() && FeketeJatekosNevmezo.getText().isEmpty()){
            errorMezo.setText("Írj be nevet!");
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/KetKiraly.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<KetKiralyIranyito>getController().initdata1(FeherJatekosNevmezo.getText());
            fxmlLoader.<KetKiralyIranyito>getController().initdata2(FeketeJatekosNevmezo.getText());
            Stage stage = (Stage) ((Node) FeherJatekosNevmezo).getScene().getWindow();
            stage.setScene(new Scene(root));
            Logger.info("Fehér játékos neve: {}, indul a játék. ", FeherJatekosNevmezo.getText());
            Logger.info("Fehér játékos neve: {},  indul a játék.", FeherJatekosNevmezo.getText());
            stage.show();
        }
    }
    public void Eredmenytabla(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Eredmenytabla.fxml"));
        Parent root = fxmlLoader.load();
        currentStage.setScene(new Scene(root));
        Logger.info("Eredménytábla betöltése.");
    }
}