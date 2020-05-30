package game;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

final class SudokuBoard {

	private static final int DIMENSION = 9;
	private static final int NCELLS = DIMENSION*DIMENSION;
	
	private static final int FREE_CELL = 0;
	
	private int[][] values;
	private int freeCount;
	private Coordinate[] moves;
	
	SudokuBoard(int[][] startValues) {
		this.values = new int[DIMENSION][];
		copy(startValues, values);
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
		return freeCount == 0;
	}
	
	/**
	 * Pretty print board in text.
	 * 
	 * @param out
	 */
	void print(PrintStream out) {
		for (int i = 0; i < DIMENSION; i++) {
			if (i % 3 == 0) {
				printLine(out);
			}
			out.println(toString(values[i]));
		}
		printLine(out);
	}

	private static String toString(int[] vals) {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < vals.length; i++) {
			if (i % 3 == 0) {
				l.add("|");
			}
			if (vals[i] == 0) {
				l.add(" ");
			} else {
				l.add(String.valueOf(vals[i]));
			}
		}
		l.add("|");
		return String.join(" ", l);
	}

	private static void printLine(PrintStream out) {
		out.println("-------------------------");
	}
	
}
