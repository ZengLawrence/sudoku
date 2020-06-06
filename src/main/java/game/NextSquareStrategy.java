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

	Optional<Square> nextSquare(SudokuBoard board);
	
	static NextSquareStrategy sequentialOrder() {
		return board -> board.freeSquares().stream().findFirst();
	};
	
	static NextSquareStrategy mostConstrained() {
		return board -> {
			return localCounts(board.freeSquares(), board)
				.stream()
				.sorted(LocalCount::sortByCandidateTotal)
				.findFirst()
				.map(LocalCount::square);
		};
	}

}
