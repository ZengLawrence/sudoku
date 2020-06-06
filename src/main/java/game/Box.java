/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Box or 3x3 sub grid on the board.
 * 
 * @author Lawrence
 *
 */
final class Box {
	
	private static final int[][] BOX_MATRIX = {
			{1, 1, 1, 2, 2, 2, 3, 3, 3},
			{1, 1, 1, 2, 2, 2, 3, 3, 3},
			{1, 1, 1, 2, 2, 2, 3, 3, 3},
			{4, 4, 4, 5, 5, 5, 6, 6, 6},
			{4, 4, 4, 5, 5, 5, 6, 6, 6},
			{4, 4, 4, 5, 5, 5, 6, 6, 6},
			{7, 7, 7, 8, 8, 8, 9, 9, 9},
			{7, 7, 7, 8, 8, 8, 9, 9, 9},
			{7, 7, 7, 8, 8, 8, 9, 9, 9},
	};
	
	private static final Map<Integer, List<Square>> BOX_SQUARES_MAP;
	
	static {
		BOX_SQUARES_MAP = new HashMap<>();
		int dimension = BOX_MATRIX.length;
		for (int x = 0; x < dimension ; x++) {
			for (int y = 0; y < dimension; y++) {
				int boxNumber = BOX_MATRIX[x][y];
				List<Square> squares = BOX_SQUARES_MAP.getOrDefault(boxNumber, new ArrayList<>());
				squares.add(new Square(x, y));
				BOX_SQUARES_MAP.put(boxNumber, squares);
			}
		}
	}

	/**
	 * 
	 * @param square
	 * @return Box that the given square belongs to.
	 */
	static final Box box(Square square) {
		return new Box(BOX_MATRIX[square.x()][square.y()]);
	}
	
	/**
	 * 
	 * @param box
	 * @return List of squares in the box
	 */
	static final List<Square> squaresIn(Box box) {
		return new ArrayList<>(BOX_SQUARES_MAP.get(box.number));
	}
	
	private final int number;

	private Box(int number) {
		this.number = number;
	}

}
