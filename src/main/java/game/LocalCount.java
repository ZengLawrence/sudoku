/**
 * 
 */
package game;

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
		board.valuesIn(coord.row()).forEach(val -> candidates[val] = false);
		board.valuesIn(coord.column()).forEach(val -> candidates[val] = false);
		board.valuesIn(coord.sector()).forEach(val -> candidates[val] = false);
		
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i]) {
				s.add(i);
			}
		}
		return s;
	}

}
