/**
 * 
 */
package game;

import algo.Backtrack;

/**
 * @author Lawrence
 *
 */
public final class Sudoku extends Backtrack<SudokuBoard>{

	private final Square[] moves;
	private final PruningStrategy pruningStrategy;
	private final SudokuLifeCycle subscriber;
	
	private Sudoku(PruningStrategy pruningStrategy, SudokuLifeCycle subscriber) {
		moves = new Square[SudokuBoard.NSQUARES];
		this.pruningStrategy = pruningStrategy;
		this.subscriber = subscriber;
	}

	public static void solve(SudokuBoard board, PruningStrategy pruningStrategy, SudokuLifeCycle subscriber) {
		Sudoku sudoku = new Sudoku(pruningStrategy, subscriber);
		sudoku.boardInitialized(board);
		int[] values = new int[SudokuBoard.NSQUARES];
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
		return pruningStrategy.nextSquare(board).map( square -> {
			moves[k] = square;
			return possibleValues(square, board);
		}).orElse(new int[0]);
	}

	private int[] possibleValues(Square nextSquare, SudokuBoard board) {
		return pruningStrategy.candidates(nextSquare, board).stream().mapToInt(n -> n).toArray();
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
