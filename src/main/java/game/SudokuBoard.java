package game;

import static game.Box.coordinatesIn;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class SudokuBoard {

	static final int DIMENSION = 9;
	static final int NSQUARES = DIMENSION*DIMENSION;
	
	private static final int FREE_SQUARE = 0;
	
	private int[][] values;
	private int freeCount;
	
	SudokuBoard(int[][] startValues) {
		this.values = new int[DIMENSION][];
		copy(startValues, values);
		this.freeCount = freeSquareCount(startValues);
	}
	
	private static void copy(int[][] source, int[][] dest) {
		for (int i = 0; i < DIMENSION; i++) {
			dest[i] = Arrays.copyOf(source[i], DIMENSION);
		}
	}
	
	private static int freeSquareCount(int[][] values) {
		int count = 0;
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (values[i][j] == FREE_SQUARE) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Fill a square on the board with a value i.e. 1 - 9.
	 * 
	 * @param coord Coordinate of the square
	 * @param val
	 */
	void fill(Coordinate coord, int val) {
		values[coord.x()][coord.y()] = val;
		freeCount--;
	}
	
	/**
	 * Change a square on board to free space.
	 * 
	 * @param coord Coordinate of the square
	 */
	void unfill(Coordinate coord) {
		values[coord.x()][coord.y()] = FREE_SQUARE;
		freeCount++;
	}
	
	/**
	 * 
	 * @return Collection of free squares that do not have value placed in them.
	 */
	List<Coordinate> freeSquares() {
		List<Coordinate> freeSquares = new ArrayList<>();
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (values[i][j] == FREE_SQUARE) {
					freeSquares.add(new Coordinate(i, j));
				}
			}
		}
		return freeSquares;
	}
	
	List<Coordinate> freeSquaresIn(Row row) {
		List<Coordinate> freeSquares = new ArrayList<>();
		int x = row.x();
		for (int y = 0; y < DIMENSION; y++) {
			if (values[x][y] == FREE_SQUARE) {
				freeSquares.add(new Coordinate(x, y));
			}
		}
		return freeSquares;
	}
	
	List<Coordinate> freeSquaresIn(Column col) {
		int y = col.y();
		List<Coordinate> freeSquares = new ArrayList<>();
		for (int x = 0; x < DIMENSION; x++) {
			if (values[x][y] == FREE_SQUARE) {
				freeSquares.add(new Coordinate(x, y));
			}
		}
		return freeSquares;
	}
	
	List<Coordinate> freeSquaresIn(Box box) {
		List<Coordinate> freeSquares = new ArrayList<>();
		for (Coordinate sq : coordinatesIn(box)) {
			int x = sq.x();
			int y = sq.y();
			if (values[x][y] == FREE_SQUARE) {
				freeSquares.add(new Coordinate(x, y));
			}
		}
		return freeSquares;
	}
	
	List<Integer> valuesIn(Row row) {
		int x = row.x();
		List<Integer> l = new ArrayList<>();
		for (int val : values[x]) {
			if (val > 0) {
				l.add(val);
			}
		}
		return l;
	}
	
	List<Integer> valuesIn(Column col) {
		int y = col.y();
		List<Integer> l = new ArrayList<>();
		for (int x = 0; x < DIMENSION; x++) {
			if (values[x][y] > 0) {
				l.add(values[x][y]);
			}
		}
		return l;
	}
	
	List<Integer> valuesIn(Box box) {
		return valuesIn(coordinatesIn(box));
	}
	
	private List<Integer> valuesIn(List<Coordinate> coordinates) {
		List<Integer> l = new ArrayList<>();
		for (Coordinate coord : coordinates) {
			int x = coord.x();
			int y = coord.y();
			if (values[x][y] > 0) {
				l.add(values[x][y]);
			}
		}
		return l;
	}
	
	/**
	 * 
	 * @return <code>true</code> if board is completely filled.
	 */
	boolean isComplete() {
		return freeCount == 0;
	}
	
	int freeCount() {
		return freeCount;
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
