package boardgame;

import boardgame.modell.TicTacToeState;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;


public class BoardGameController {
    @FXML
    private GridPane board;
    @FXML
    private Button newGameButton;
    @FXML
    private Button finishGameButton;
    private BooleanProperty inGame;
    private ObjectProperty<TicTacToeState> model;
    @FXML
    private void initialize(){
        inGame = new SimpleBooleanProperty(false);
        model = new SimpleObjectProperty<>(new TicTacToeState());

        model.addListener((element, old, actual) -> drawGrid());

        inGame.addListener((element,old,actual)->{
            newGameButton.setDisable(actual);
            finishGameButton.setDisable(!actual);
        });

        finishGameButton.setDisable(true);
        drawGrid();
    }

    private void drawGrid(){
        board.getChildren().clear();
        for (int row = 0; row < board.getRowCount(); row++) {
            for (int col = 0; col < board.getColumnCount(); col++) {
                board.add(createSquare(model.getValue().getBoard()[row][col]), col, row);
            }
        }
    }

    private StackPane createSquare(final TicTacToeState.State state){
        final var size = 50;
        final var square = new StackPane();
        square.setPrefHeight(size);
        square.setPrefWidth(size);
        square.getStyleClass().add("square");

        if(inGame.get()){
            square.getStyleClass().add("inGame");
            square.setOnMouseClicked(this::handleMouseClick);
        }

        final var piece = new Circle(size/2);
        piece.fillProperty().set(switch (state){
            case RED -> Color.RED;
            case BLUE -> Color.BLUE;
            case EMPTY -> Color.TRANSPARENT;
        });
        square.getChildren().add(piece);

        return square;
    }


    private void handleMouseClick(MouseEvent event){
        var square = (StackPane) event.getSource();
        var row = GridPane.getRowIndex(square);
        var col = GridPane.getColumnIndex(square);
        if (model.get().canMove(row,col)){
            model.set(model.get().doMove(row,col));
            if (model.getValue().getWinner().isPresent()){
                inGame.set(false);
                drawGrid();
            }
        }
    }

    public void onStartGame(ActionEvent actionEvent) {
        inGame.set(true);
        model.set(new TicTacToeState());
        drawGrid();
    }

    public void onFinishGame(ActionEvent actionEvent) {
        inGame.set(false);
        model.set(new TicTacToeState());
        drawGrid();

    }
}
