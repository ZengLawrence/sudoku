/**
 * 
 */
package game;

import java.util.Optional;

/**
 * Search pruning strategy for Sudoku.
 * 
 * @author Lawrence
 *
 */
class PruningStrategy implements NextSquareStrategy {

	static PruningStrategy of(NextSquareStrategy nextSquareStrategy) {
		return new PruningStrategy(nextSquareStrategy);
	}
	
	private final NextSquareStrategy nextSquareStrategy;
	
	private PruningStrategy(NextSquareStrategy nextSquareStrategy) {
		this.nextSquareStrategy = nextSquareStrategy;
	}

	@Override
	public Optional<Coordinate> nextSquare(SudokuBoard board) {
		return nextSquareStrategy.nextSquare(board);
	}
	
}
