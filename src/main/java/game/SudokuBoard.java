package game;

import java.util.Arrays;

final class SudokuBoard {

	private static final int DIMENSION = 9;
	private static final int NCELLS = DIMENSION*DIMENSION;
	
	private static final int FREE_CELL = 0;
	
	private int[][] values;
	private int freeCount;
	private Coordinate[] moves;
	
	SudokuBoard(int[][] startValues) {
		this.values = new int[DIMENSION][];
		copy(values, startValues);
		this.freeCount = freeCells(startValues);
		this.moves = new Coordinate[NCELLS];
	}
	
	private static void copy(int[][] source, int[][] dest) {
		for (int i = 0; i < DIMENSION; i++) {
			dest[i] = Arrays.copyOf(source[i], DIMENSION);
		}
	}
	
	private static int freeCells(int[][] values) {
		int count = 0;
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (values[i][j] == FREE_CELL) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @return <code>true</code> if board is completely filled.
	 */
	boolean isComplete() {
		return false;
	}
	
}
