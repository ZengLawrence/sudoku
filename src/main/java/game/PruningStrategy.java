/**
 * 
 */
package game;

import java.util.Optional;

/**
 * Search pruning strategy for Sudoku.  By default, using sequential for picking the next square to fill.
 * 
 * @author Lawrence
 *
 */
public interface PruningStrategy {
	
	default Optional<Coordinate> nextSquare(SudokuBoard board) {
		return board.emptySquares().stream().findFirst();
	};
	
	static PruningStrategy sequentialOrder() {
		return new PruningStrategy() {
		};
	};
}
