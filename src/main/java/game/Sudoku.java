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
	
	public Sudoku() {
		moves = new Coordinate[SudokuBoard.NCELLS];
	}

	public static void solve(SudokuBoard board) {
		Sudoku sudoku = new Sudoku();
		System.out.println("Initial Board:");
		board.print(System.out);
		int[] values = new int[SudokuBoard.NCELLS];
		int step = 0;
		sudoku.backtrack(values, step, board);
	}
	
	@Override
	protected void unmakeMove(int[] a, int k, SudokuBoard board) {
		board.unfill(moves[k]);
	}

	@Override
	protected void makeMove(int[] a, int k, SudokuBoard board) {
		board.fill(moves[k], a[k]);		
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
		System.out.println("Solution:");
		board.print(System.out);
		super.finished();
	}

	@Override
	protected boolean isASolution(int[] a, int k, SudokuBoard board) {
		return board.isComplete();
	}

}
