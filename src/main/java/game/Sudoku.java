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

	private final Coordinate[] moves;
	private final PruningStrategy pruningStrategy;
	private final SudokuLifeCycle subscriber;
	
	private Sudoku(PruningStrategy pruningStrategy, SudokuLifeCycle subscriber) {
		moves = new Coordinate[SudokuBoard.NCELLS];
		this.pruningStrategy = pruningStrategy;
		this.subscriber = subscriber;
	}

	public static void solve(SudokuBoard board, PruningStrategy pruningStrategy, SudokuLifeCycle subscriber) {
		Sudoku sudoku = new Sudoku(pruningStrategy, subscriber);
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
		return pruningStrategy.nextSquare(board).map( coord -> {
			moves[k] = coord;
			return possibleValues(coord, board);
		}).orElse(new int[0]);
	}

	private int[] possibleValues(Coordinate nextSquare, SudokuBoard board) {
		return LocalCount.candidates(nextSquare, board).stream().mapToInt(n -> n).toArray();
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
