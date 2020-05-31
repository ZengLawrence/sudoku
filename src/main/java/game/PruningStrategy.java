/**
 * 
 */
package game;

import static game.LocalCount.*;

import java.util.Optional;

/**
 * Search pruning strategy for Sudoku.
 * 
 * @author Lawrence
 *
 */
public interface PruningStrategy {
	
	Optional<Coordinate> nextSquare(SudokuBoard board);
	
	static PruningStrategy sequentialOrder() {
		return board -> board.emptySquares().stream().findFirst();
	};
	
	static PruningStrategy mostConstrained() {
		return board -> {
			return localCounts(board.emptySquares(), board)
				.stream()
				.sorted(LocalCount::sortByCandidateTotal)
				.findFirst()
				.map(LocalCount::coordinate);
		};
	}



}
