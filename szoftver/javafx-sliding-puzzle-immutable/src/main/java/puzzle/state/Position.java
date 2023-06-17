package puzzle.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import java.util.Arrays;
import java.util.Optional;

/**
 * Represents a 2D position.
 */
@Value
@AllArgsConstructor
public class Position {

    int row;
    int col;

    /**
     * {@return the position whose vertical and horizontal distances from this
     * position are equal to the coordinate changes of the direction given}
     *
     * @param direction a direction that specifies a change in the coordinates
     */
    public Position getNeighbor(
            @NonNull final Direction direction) {

        return new Position(row + direction.getRowChange(), col + direction.getColChange());
    }

    @Override
    public String toString() {
        return String.format("({},{})", row, col);
    }

    /**
     * Represents the four main directions.
     */
    @Getter
    @AllArgsConstructor
    public enum Direction {

        UP(-1, 0),
        RIGHT(0, 1),
        DOWN(1, 0),
        LEFT(0, -1);

        private final int rowChange;
        private final int colChange;

        /**
         * {@return the direction that corresponds to the coordinate changes
         * specified}
         *
         * @param rowChange the change in the row coordinate
         * @param colChange the change in the column coordinate
         */
        public static Optional<Direction> of(
                final int rowChange,
                final int colChange) {

            return Arrays.stream(Direction.values())
                    .filter(d -> d.rowChange == rowChange && d.colChange == colChange)
                    .findFirst();
        }
    }
}
