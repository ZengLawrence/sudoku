/**
 * 
 */
package game;

import static game.LocalCount.localCounts;

import java.util.Optional;

/**
 * Pruning strategy on selecting next square on the board.
 * 
 * @author Lawrence
 *
 */
public interface NextSquareStrategy {

	Optional<Coordinate> nextSquare(SudokuBoard board);
	
	static NextSquareStrategy sequentialOrder() {
		return board -> board.emptySquares().stream().findFirst();
	};
	
	static NextSquareStrategy mostConstrained() {
		return board -> {
			return localCounts(board.emptySquares(), board)
				.stream()
				.sorted(LocalCount::sortByCandidateTotal)
				.findFirst()
				.map(LocalCount::coordinate);
		};
	}

}
