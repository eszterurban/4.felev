package iranyito;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import modell.KetKiralyModell;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class EredmenytablaIranyito {
    @FXML
    private ListView<String> listView;
    private KetKiralyModell model = new KetKiralyModell();
    private Map<String,Integer> myMap = model.jsonToMap("Eredmeny.json");


    @FXML
    private void initialize(){
        listView.getItems().addAll(convertMapToList(myMap));
    }

    private List<String> convertMapToList(Map<String, Integer> map) {
        List<String> keyValuePairs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String keyValuePair = entry.getKey() + ": " + entry.getValue();
            keyValuePairs.add(keyValuePair);
        }

        keyValuePairs.sort(Comparator.comparingInt(s -> -1 * Integer.parseInt(s.split(": ")[1])));

        return keyValuePairs;
    }

    public void startAction(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Nyito.fxml"));
        Parent root = fxmlLoader.load();
        currentStage.setScene(new Scene(root));
        Logger.info("Nyitó képernyőre váltás.");
    }
}
