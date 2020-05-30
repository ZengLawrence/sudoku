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
	
	public Sudoku() {
		moves = new Coordinate[SudokuBoard.NCELLS];
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
		// TODO Auto-generated method stub
		// add to moves before returning
		return null;
	}

	@Override
	protected void processSolution(int[] a, int k, SudokuBoard board) {
		board.print(System.out);
		super.finished();
	}

	@Override
	protected boolean isASolution(int[] a, int k, SudokuBoard board) {
		return board.isComplete();
	}

}
