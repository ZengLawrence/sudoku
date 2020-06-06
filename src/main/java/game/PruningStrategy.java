/**
 * 
 */
package game;

import java.util.Optional;
import java.util.Set;

/**
 * Search pruning strategy for Sudoku.
 * 
 * @author Lawrence
 *
 */
class PruningStrategy implements NextSquareStrategy, CandidateStrategy {

	static PruningStrategy of(NextSquareStrategy nextSquareStrategy, CandidateStrategy candidateStrategy) {
		return new PruningStrategy(nextSquareStrategy, candidateStrategy);
	}
	
	private final NextSquareStrategy nextSquareStrategy;
	private final CandidateStrategy candidateStrategy;
	
	private PruningStrategy(NextSquareStrategy nextSquareStrategy, CandidateStrategy candidateStrategy) {
		this.nextSquareStrategy = nextSquareStrategy;
		this.candidateStrategy = candidateStrategy;
	}

	@Override
	public Optional<Square> nextSquare(SudokuBoard board) {
		return nextSquareStrategy.nextSquare(board);
	}

	@Override
	public Set<Integer> candidates(Square square, SudokuBoard board) {
		return candidateStrategy.candidates(square, board);
	}
	
}
