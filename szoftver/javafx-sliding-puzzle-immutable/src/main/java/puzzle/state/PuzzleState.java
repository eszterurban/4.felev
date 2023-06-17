package puzzle.state;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.With;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents the state of the puzzle.
 */
@Value
@AllArgsConstructor
@With
public class PuzzleState {

    /**
     * The size of the board.
     */
    private static final int BOARD_SIZE = 3;

    /**
     * The index of the block.
     */
    public static final int BLOCK = 0;

    /**
     * The index of the red shoe.
     */
    public static final int RED_SHOE = 1;

    /**
     * The index of the blue shoe.
     */
    public static final int BLUE_SHOE = 2;

    /**
     * The index of the black shoe.
     */
    public static final int BLACK_SHOE = 3;

    List<Position> positions;

    private static final List<Position> INITIAL_STATE = List.of(
            new Position(0, 0),
            new Position(2, 0),
            new Position(1, 1),
            new Position(0, 2)
    );

    /**
     * Creates a {@code PuzzleState} object that corresponds to the original
     * initial state of the puzzle.
     */
    public PuzzleState() {
        this.positions = INITIAL_STATE;
    }

    /**
     * Performs a move and returns the new state.
     *
     * @param direction the direction to which the block is moved
     * @return the new state
     */
    public PuzzleState doMove(
            @NonNull final Position.Direction direction) {
        return switch (direction) {
            case UP:
                yield moveUp();
            case RIGHT:
                yield move(Position.Direction.RIGHT, Set.of(RED_SHOE, BLUE_SHOE, BLACK_SHOE));
            case DOWN:
                yield move(Position.Direction.DOWN, Set.of(RED_SHOE, BLUE_SHOE, BLACK_SHOE));
            case LEFT:
                yield move(Position.Direction.LEFT, Set.of(RED_SHOE, BLUE_SHOE));
        };
    }

    /**
     * {@return whether the block can be moved to the direction specified}
     *
     * @param direction a direction to which the block is intended to be moved
     */
    public boolean checkMove(Position.Direction direction) {
        return switch (direction) {
            case UP -> canMoveUp();
            case RIGHT -> canMoveRight();
            case DOWN -> canMoveDown();
            case LEFT -> canMoveLeft();
        };
    }

    /**
     * {@return a copy of the position of the piece specified}
     *
     * @param n the number of a piece
     */
    public Position getPosition(final int n) {
        return positions.get(n);
    }

    /**
     * {@return whether the puzzle is solved}
     */
    public boolean isGoal() {
        return haveEqualPositions(RED_SHOE, BLUE_SHOE);
    }


    private boolean canMoveUp() {
        return positions.get(BLOCK).getRow() > 0 && isEmpty(positions.get(BLOCK).getNeighbor(Position.Direction.UP));
    }

    private boolean canMoveRight() {
        if (getPosition(BLOCK).getCol() == BOARD_SIZE - 1) {
            return false;
        }
        final var right = getPosition(BLOCK).getNeighbor(Position.Direction.RIGHT);
        return isEmpty(right) || (Objects.equals(getPosition(BLACK_SHOE), right) && !haveEqualPositions(BLOCK, BLUE_SHOE));
    }

    private boolean canMoveDown() {
        if (getPosition(BLOCK).getRow() == BOARD_SIZE - 1) {
            return false;
        }
        final var down = getPosition(BLOCK).getNeighbor(Position.Direction.DOWN);
        if (isEmpty(down)) {
            return true;
        }
        if (haveEqualPositions(BLACK_SHOE, BLOCK) || Objects.equals(getPosition(BLACK_SHOE), down)) {
            return false;
        }
        return Objects.equals(getPosition(BLUE_SHOE), down) || (Objects.equals(getPosition(RED_SHOE), down) && !haveEqualPositions(BLUE_SHOE, BLOCK));
    }

    private boolean canMoveLeft() {
        return getPosition(BLOCK).getCol() > 0 && isEmpty(getPosition(BLOCK).getNeighbor(Position.Direction.LEFT));
    }


    private PuzzleState moveUp() {
        final var newPositions = new ArrayList<>(this.positions);
        final var newPosition = getPosition(BLOCK).getNeighbor(Position.Direction.UP);
        if (haveEqualPositions(BLACK_SHOE, BLOCK)) {
            if (haveEqualPositions(RED_SHOE, BLOCK)) {
                newPositions.set(RED_SHOE, newPosition);
            }
            newPositions.set(BLACK_SHOE, newPosition);
        }
        newPositions.set(BLOCK, newPosition);
        return withPositions(Collections.unmodifiableList(newPositions));
    }


    private PuzzleState move(
            @NonNull final Position.Direction direction,
            @NonNull final Set<Integer> shoes) {

        final var newPositions = new ArrayList<>(this.positions);
        final var newPosition = getPosition(BLOCK).getNeighbor(direction);
        newPositions.set(BLOCK, newPosition);
        for (final int shoe : shoes) {
            if (haveEqualPositions(shoe, BLOCK)) {
                newPositions.set(shoe, newPosition);
            }
        }
        return withPositions(Collections.unmodifiableList(newPositions));
    }

    private boolean haveEqualPositions(int i, int j) {
        return Objects.equals(positions.get(i), positions.get(j));
    }

    private boolean isEmpty(
            @NonNull final Position position) {

        return positions.stream()
                .noneMatch(p -> Objects.equals(p, position));
    }

    @Override
    public String toString() {
        return positions.stream()
                .map(Position::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }
}
