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
	
	private static final Map<Integer, List<Coordinate>> BOX_COORDINATE_MAP;
	
	static {
		BOX_COORDINATE_MAP = new HashMap<>();
		int dimension = BOX_MATRIX.length;
		for (int x = 0; x < dimension ; x++) {
			for (int y = 0; y < dimension; y++) {
				int boxNumber = BOX_MATRIX[x][y];
				List<Coordinate> coordinates = BOX_COORDINATE_MAP.getOrDefault(boxNumber, new ArrayList<>());
				coordinates.add(new Coordinate(x, y));
				BOX_COORDINATE_MAP.put(boxNumber, coordinates);
			}
		}
	}

	/**
	 * 
	 * @param coord
	 * @return Box that the given coordinate belongs to.
	 */
	static final Box box(Coordinate coord) {
		return new Box(BOX_MATRIX[coord.x()][coord.y()]);
	}
	
	/**
	 * 
	 * @param box
	 * @return List of coordinates in the box
	 */
	static final List<Coordinate> coordinatesIn(Box box) {
		return new ArrayList<>(BOX_COORDINATE_MAP.get(box.number));
	}
	
	private final int number;

	private Box(int number) {
		this.number = number;
	}

}
