package puzzle.gui;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.Data;
import lombok.NonNull;
import org.tinylog.Logger;
import puzzle.results.GameResult;
import puzzle.results.GameResultRepository;
import puzzle.state.Position;
import puzzle.state.PuzzleState;
import util.javafx.ControllerHelper;
import util.javafx.Stopwatch;

import javax.inject.Inject;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Data
public final class GameController {
    @FXML
    private Label messageLabel;

    @FXML
    private GridPane grid;

    @FXML
    private TextField numberOfMovesField;

    @FXML
    private Label stepsLabel;

    @FXML
    private Button resetButton;

    @FXML
    private Button giveUpFinishButton;

    @FXML
    private Label stopwatchLabel;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private GameResultRepository gameResultRepository;

    private String playerName;

    private BooleanProperty isSolved = new SimpleBooleanProperty();

    private IntegerProperty countOfSteps = new SimpleIntegerProperty();

    private ImageView[] pieceViews;

    private PuzzleState state;

    private Stopwatch stopwatch = new Stopwatch();

    private Instant startTime;

    @FXML
    private void initialize() {
        // creating bindings
        stepsLabel.textProperty().bind(countOfSteps.asString());
        stopwatchLabel.textProperty().bind(stopwatch.hhmmssProperty());
        isSolved.addListener(this::handleSolved);

        // loading images
        pieceViews = Stream.of("block.png", "red-shoe.png", "blue-shoe.png", "black-shoe.png")
                .map(s -> "/images/" + s)
                .peek(s -> Logger.debug("Loading image resource {}", s))
                .map(Image::new)
                .map(ImageView::new)
                .toArray(ImageView[]::new);

        // populating grid
        populateGrid();

        // registering listeners
        registerKeyEventHandler();

        // starting new game
        Platform.runLater(() -> messageLabel.setText(String.format("Good luck, %s!", playerName)));
        resetGame();
    }


    private void resetGame() {
        // initializing state
        state = new PuzzleState();
        countOfSteps.set(0);
        isSolved.set(false);

        // initializing watch
        startTime = Instant.now();
        if (stopwatch.getStatus() == Animation.Status.PAUSED) {
            stopwatch.reset();
        }
        stopwatch.start();

        // initializing board
        clearState();
        showState();
    }


    private void registerKeyEventHandler() {
        final KeyCombination restartKeyCombination = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        final KeyCombination quitKeyCombination = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN);
        Platform.runLater(() -> grid.getScene().setOnKeyPressed(
                keyEvent -> {
                    if (restartKeyCombination.match(keyEvent)) {
                        Logger.debug("Restarting game...");
                        resetGame();
                    } else if (quitKeyCombination.match(keyEvent)) {
                        Logger.debug("Exiting...");
                        Platform.exit();
                    } else if (keyEvent.getCode() == KeyCode.UP) {
                        Logger.debug("Up arrow pressed");
                        performMove(Position.Direction.UP);
                    } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                        Logger.debug("Right arrow pressed");
                        performMove(Position.Direction.RIGHT);
                    } else if (keyEvent.getCode() == KeyCode.DOWN) {
                        Logger.debug("Down arrow pressed");
                        performMove(Position.Direction.DOWN);
                    } else if (keyEvent.getCode() == KeyCode.LEFT) {
                        Logger.debug("Left arrow pressed");
                        performMove(Position.Direction.LEFT);
                    }
                }
        ));
    }

    @FXML
    private void handleMouseClick(
            @NonNull final MouseEvent event) {

        final var source = (Node) event.getSource();
        final var row = GridPane.getRowIndex(source);
        final var col = GridPane.getColumnIndex(source);

        Logger.debug("Click on square ({},{})", row, col);

        getDirectionFromClickPosition(row, col)
                .ifPresentOrElse(this::performMove,
                        () -> Logger.warn("Click does not correspond to any direction"));
    }

    private void performMove(
            @NonNull final Position.Direction direction) {

        if (state.checkMove(direction)) {
            Logger.info("Move: {}", direction);

            state = state.doMove(direction);
            Logger.trace("New state: {}", state);

            countOfSteps.set(countOfSteps.get() + 1);

            showState();
            if (state.isGoal()) {
                isSolved.set(true);
            }
        } else {
            Logger.warn("Invalid move: {}", direction);
        }
    }

    public void handleResetButton(ActionEvent actionEvent) {
        Logger.debug("{} is pressed", ((Button) actionEvent.getSource()).getText());
        Logger.info("Resetting game");
        stopwatch.stop();
        resetGame();
    }

    public void handleGiveUpFinishButton(
            @NonNull final ActionEvent actionEvent) throws IOException {

        final var buttonText = ((Button) actionEvent.getSource()).getText();
        Logger.debug("{} is pressed", buttonText);
        if (Objects.equals(buttonText, "Give Up")) {
            stopwatch.stop();
            Logger.info("The game has been given up");
        }

        Logger.debug("Saving result");
        gameResultRepository.addOne(createGameResult());

        Logger.debug("Loading HighScoreController");
        ControllerHelper.loadAndShowFXML(
                fxmlLoader,
                "/fxml/high-scores.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow()
        );
    }

    private void handleSolved(ObservableValue<? extends Boolean> observableValue, boolean oldValue, boolean newValue) {
        if (newValue) {
            Logger.info("Player {} has solved the game in {} steps", playerName, countOfSteps.get());
            stopwatch.stop();
            messageLabel.setText(String.format("Congratulations, %s!", playerName));
            resetButton.setDisable(true);
            giveUpFinishButton.setText("Finish");
        }
    }


    private void populateGrid() {
        for (int row = 0; row < grid.getRowCount(); row++) {
            for (int col = 0; col < grid.getColumnCount(); col++) {
                final var square = new StackPane();
                square.getStyleClass().add("square");
                square.getStyleClass().add((row + col) % 2 == 0 ? "light" : "dark");
                square.setOnMouseClicked(this::handleMouseClick);
                grid.add(square, col, row);
            }
        }
    }

    private void clearState() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                getGridNodeAtPosition(grid, row, col)
                        .ifPresent(node -> ((StackPane) node).getChildren().clear());
            }
        }
    }

    private void showState() {
        clearState();
        for (int i = 0; i < 4; i++) {
            final var position = state.getPosition(i);
            final var pieceView = pieceViews[i];
            getGridNodeAtPosition(grid, position)
                    .ifPresent(node -> ((StackPane) node).getChildren().add(pieceView));
        }
    }


    private Optional<Position.Direction> getDirectionFromClickPosition(
            final int row,
            final int col) {

        final var blockPosition = state.getPosition(PuzzleState.BLOCK);
        return Position.Direction.of(row - blockPosition.getRow(), col - blockPosition.getCol());
    }

    private static Optional<Node> getGridNodeAtPosition(
            @NonNull final GridPane gridPane,
            @NonNull final Position pos) {

        return getGridNodeAtPosition(gridPane, pos.getRow(), pos.getCol());
    }

    private static Optional<Node> getGridNodeAtPosition(
            @NonNull final GridPane gridPane,
            final int row,
            final int col) {

        return gridPane.getChildren().stream()
                .filter(child -> GridPane.getRowIndex(child) == row && GridPane.getColumnIndex(child) == col)
                .findFirst();
    }

    private GameResult createGameResult() {
        return GameResult.builder()
                .player(playerName)
                .solved(state.isGoal())
                .duration(Duration.between(startTime, Instant.now()))
                .steps(countOfSteps.get())
                .build();
    }
}