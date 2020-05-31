/**
 * 
 */
package game;

import static game.Sector.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * From a coordinate, Look through row, column and sector to find candidate values.
 * 
 * @author Lawrence
 *
 */
final class LocalCount {

	static Set<Integer> candidates(Coordinate coord, SudokuBoard board) {
		boolean[] candidates = new boolean[SudokuBoard.DIMENSION + 1];
		Arrays.fill(candidates, 1, candidates.length, true);
		board.valuesInRow(coord.x()).forEach(val -> candidates[val] = false);
		board.valuesInColumn(coord.y()).forEach(val -> candidates[val] = false);
		board.valuesForCoordinates(coordinatesIn(sector(coord))).forEach(val -> candidates[val] = false);
		
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i]) {
				s.add(i);
			}
		}
		return s;
	}

}
