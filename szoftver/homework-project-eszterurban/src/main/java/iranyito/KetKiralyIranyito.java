package iranyito;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modell.KetKiralyModell;
import modell.Negyzet;
import modell.Pozicio;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.ArrayList;


public class KetKiralyIranyito {
    @FXML
    private GridPane tabla;
    @FXML
    public Label nyertesCimke;
    @FXML
    public Button eredmenyGomb;
    @FXML
    public Button ujrakezdesGomb;
    @FXML
    private Label elsoJatekosCimke;
    @FXML
    private Label masodikJatekosCimke;

    private String elsoJatekos;
    private String masokdikJatekos;
    private ImageView feketeKiralyNezet;
    private ImageView feherKiralyNezet;
    private boolean jatekVege = false;
    private KetKiralyModell model = new KetKiralyModell();
    public void initdata1(String username1){
        this.elsoJatekos=username1;
        elsoJatekosCimke.setText((String.format("Sok szerencsét, %s!", elsoJatekos)));
    }

    public void initdata2(String username2){
        this.masokdikJatekos=username2;
        masodikJatekosCimke.setText((String.format("Sok szerencsét, %s!",masokdikJatekos)));
    }
    @FXML
    private void initialize() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                var square = createSquare(i, j);
                tabla.add(square, j, i);
            }
        }

        model.getFeherKiraly().pozicioProperty().addListener((xx, oldValue, newValue) -> {
            Node newParent = null;

            for (Node child : tabla.getChildren()) {
                if (GridPane.getColumnIndex(child) == null)
                    continue;

                if (GridPane.getRowIndex(child) == newValue.sor() && GridPane.getColumnIndex(child) == newValue.oszl()) {
                    newParent = child;
                    break;
                }
            }

            ((StackPane) newParent).getChildren().add(feherKiralyNezet);
        });

        model.getFeketeKiraly().pozicioProperty().addListener((xx, oldValue, newValue) -> {
            Node newParent = null;

            for (Node child : tabla.getChildren()) {
                if (GridPane.getColumnIndex(child) == null)
                    continue;

                if (GridPane.getRowIndex(child) == newValue.sor() && GridPane.getColumnIndex(child) == newValue.oszl()) {
                    newParent = child;
                    break;
                }
            }

            ((StackPane) newParent).getChildren().add(feketeKiralyNezet);
        });

        BooleanBinding isPossibleMovesEmptyBinding = model.isPossibleMovesEmptyBinding();
        nyertesCimke.visibleProperty().bind(isPossibleMovesEmptyBinding);
        nyertesCimke.managedProperty().bind(isPossibleMovesEmptyBinding);
    }


    private StackPane createSquare(int i, int j) {
        var square = new StackPane();
        square.getStyleClass().add("square");
        square.setOnMouseClicked(this::handleMouseClick);
        if (model.getFeketeKiraly().getPozicio().equals(new Pozicio(i, j))) {
            feketeKiralyNezet = new ImageView(new Image("/kepek/fekete.png"));
            feketeKiralyNezet.setFitHeight(40);
            feketeKiralyNezet.setFitWidth(40);
            square.getChildren().add(feketeKiralyNezet);
        }

        if (model.getFeherKiraly().getPozicio().equals(new Pozicio(i, j))) {
            feherKiralyNezet = new ImageView(new Image("/kepek/feher.png"));
            feherKiralyNezet.setFitHeight(40);
            feherKiralyNezet.setFitWidth(40);
            square.getChildren().add(feherKiralyNezet);
        }

        square.styleProperty().bind(
                Bindings.when(model.squareProperty(i, j).isEqualTo(Negyzet.NINCS))
                        .then("-fx-background-color: #8c878a;")
                        .otherwise("")
        );

        return square;
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        if(jatekVege){
            return;
        }

        StackPane clickedSquare = (StackPane) event.getSource();
        int row = GridPane.getRowIndex(clickedSquare);
        int col = GridPane.getColumnIndex(clickedSquare);
        Pozicio clickedPosition = new Pozicio(row, col);

        model.lepes(clickedPosition);
        if(model.neveaNyertesnek == null){
            return;
        }else {
            nyertesCimke.setText("The Winner is: " + (model.neveaNyertesnek.equals("Black") ? masokdikJatekos : elsoJatekos));
        }

        ArrayList<Pozicio> posMoves = model.getLehetsegesLepes(model.getFeherKiraly().getPozicio(),model.getFeketeKiraly().getPozicio());
        if(posMoves.isEmpty()){
            jatekVege = true;
            model.Nyertes();
            model.jatekosFrissites(model.neveaNyertesnek.equals("Black") ? masokdikJatekos : elsoJatekos);
            ujrakezdesGomb.setDisable(false);
        }
    }

    @FXML
    private void startujJatek() throws IOException {
        Stage currentStage = (Stage) eredmenyGomb.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Nyito.fxml"));
        Parent root = fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
        Logger.info("Nyitó kép betöltése");
    }

    @FXML
    private void eredmenytabla(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Eredmenytabla.fxml"));
        Parent root = fxmlLoader.load();
        currentStage.setScene(new Scene(root));
        Logger.info("Eredménytábla betöltése");
    }
}
