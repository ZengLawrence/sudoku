/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sector on the board.
 * 
 * @author Lawrence
 *
 */
final class Sector {
	
	private static final int[][] SECTOR_MATRIX = {
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
	
	private static final Map<Integer, List<Coordinate>> SECTOR_MAP;
	
	static {
		SECTOR_MAP = new HashMap<>();
		int dimension = SECTOR_MATRIX.length;
		for (int x = 0; x < dimension ; x++) {
			for (int y = 0; y < dimension; y++) {
				int sectorNumber = SECTOR_MATRIX[x][y];
				List<Coordinate> coordinates = SECTOR_MAP.getOrDefault(sectorNumber, new ArrayList<>());
				coordinates.add(new Coordinate(x, y));
				SECTOR_MAP.put(sectorNumber, coordinates);
			}
		}
	}

	/**
	 * 
	 * @param coord
	 * @return Sector that the given coordinate belongs to.
	 */
	static final Sector sector(Coordinate coord) {
		return new Sector(SECTOR_MATRIX[coord.x()][coord.y()]);
	}
	
	/**
	 * 
	 * @param sector
	 * @return List of coordinates in the sector
	 */
	static final List<Coordinate> coordinatesIn(Sector sector) {
		return new ArrayList<>(SECTOR_MAP.get(sector.number));
	}
	
	private final int number;

	private Sector(int number) {
		this.number = number;
	}

}
