/**
 * 
 */
package game;

import java.util.Optional;

import algo.Backtrack;

/**
 * @author Lawrence
 *
 */
public final class Sudoku extends Backtrack<SudokuBoard>{

	private final Coordinate[] moves;
	private final SudokuLifeCycle subscriber;
	
	private Sudoku(SudokuLifeCycle lifeCycleSubscriber) {
		moves = new Coordinate[SudokuBoard.NCELLS];
		this.subscriber = lifeCycleSubscriber;
	}

	public static void solve(SudokuBoard board, SudokuLifeCycle subscriber) {
		Sudoku sudoku = new Sudoku(subscriber);
		sudoku.boardInitialized(board);
		int[] values = new int[SudokuBoard.NCELLS];
		int level = 0;
		sudoku.backtrack(values, level, board);
	}
	
	private void boardInitialized(SudokuBoard board) {
		this.subscriber.boardInitialized(board);
	}
	
	@Override
	protected void unmakeMove(int[] a, int k, SudokuBoard board) {
		board.unfill(moves[k]);
	}

	@Override
	protected void makeMove(int[] a, int k, SudokuBoard board) {
		board.fill(moves[k], a[k]);
		subscriber.moveMade(moves[k], a[k]);
	}
	
	@Override
	protected int[] constructCandidates(int[] a, int k, SudokuBoard board) {
		Optional<Coordinate> nextSquare = nextSequare(board);
		if (nextSquare.isPresent()) {
			moves[k] = nextSquare.get();
			return possibleValues(moves[k], board);
		} else {
			return new int[0];
		}
	}

	private int[] possibleValues(Coordinate nextSquare, SudokuBoard board) {
		return LocalCount.candidates(nextSquare, board).stream().mapToInt(n -> n).toArray();
	}

	private Optional<Coordinate> nextSequare(SudokuBoard board) {
		return board.emptySquares().stream().findFirst();
	}

	@Override
	protected void processSolution(int[] a, int k, SudokuBoard board) {
		this.subscriber.solutionFound(board);
		super.finish();
	}

	@Override
	protected boolean isASolution(int[] a, int k, SudokuBoard board) {
		return board.isComplete();
	}

}
