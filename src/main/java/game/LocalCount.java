/**
 * 
 */
package game;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find candidates from a square after removing values already placed in its row, column or box.
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
		board.valuesIn(coord.box()).forEach(val -> candidates[val] = false);
		
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i]) {
				s.add(i);
			}
		}
		return s;
	}

	static Collection<LocalCount> localCounts(Collection<Coordinate> squares, SudokuBoard board) {
		return squares.stream()
				.map( coord -> new LocalCount(coord, candidates(coord, board)))
				.collect(Collectors.toList());
	}
	
	static int sortByCandidateTotal(LocalCount localCount1, LocalCount localCount2) {
		return 	Integer.compare(localCount1.candidateTotal(), localCount2.candidateTotal());
	}

	private final Coordinate coordinate;
	private final Set<Integer> candidates;
	
	private LocalCount(Coordinate coordinate, Set<Integer> candidates) {
		this.coordinate = coordinate;
		this.candidates = candidates;
	}

	Coordinate coordinate() {
		return coordinate;
	}

	Set<Integer> candidates() {
		return candidates;
	} 
	
	private int candidateTotal() {
		return candidates.size();
	}
}
