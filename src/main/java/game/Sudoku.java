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

	@Override
	protected void unmakeMove(int[] a, int k, SudokuBoard board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void makeMove(int[] a, int k, SudokuBoard board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int[] constructCandidates(int[] a, int k, SudokuBoard board) {
		// TODO Auto-generated method stub
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
