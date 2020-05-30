/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.List;

import algo.Backtrack;

/**
 * @author Lawrence
 *
 */
public final class Sudoku extends Backtrack<SudokuBoard>{

	private final List<Coordinate> moves;
	
	public Sudoku() {
		moves = new ArrayList<>();
	}

	@Override
	protected void unmakeMove(int[] a, int k, SudokuBoard board) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void makeMove(int[] a, int k, SudokuBoard board) {
		board.fill(moves.get(k), a[k]);		
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
