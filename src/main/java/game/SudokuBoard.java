package game;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

final class SudokuBoard {

	private static final int DIMENSION = 9;
	
	private static final int FREE_CELL = 0;
	
	private int[][] values;
	private int freeCount;
	
	SudokuBoard(int[][] startValues) {
		this.values = new int[DIMENSION][];
		copy(startValues, values);
		this.freeCount = freeCells(startValues);
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
	 * Fill a cell on the board with a value i.e. 1 - 9.
	 * 
	 * @param coord Coordinate of the cell
	 * @param val
	 */
	void fill(Coordinate coord, int val) {
		values[coord.x()][coord.y()] = val;
		freeCount--;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + freeCount;
		result = prime * result + Arrays.deepHashCode(values);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SudokuBoard other = (SudokuBoard) obj;
		if (freeCount != other.freeCount)
			return false;
		if (!Arrays.deepEquals(values, other.values))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SudokuBoard [values=" + Arrays.deepToString(values) + ", freeCount=" + freeCount + "]";
	}
	
	
}
