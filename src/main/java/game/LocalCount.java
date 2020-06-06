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

	static Set<Integer> candidates(Square square, SudokuBoard board) {
		boolean[] candidates = new boolean[SudokuBoard.DIMENSION + 1];
		Arrays.fill(candidates, 1, candidates.length, true);
		board.valuesIn(square.row()).forEach(val -> candidates[val] = false);
		board.valuesIn(square.column()).forEach(val -> candidates[val] = false);
		board.valuesIn(square.box()).forEach(val -> candidates[val] = false);
		
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i]) {
				s.add(i);
			}
		}
		return s;
	}

	static Collection<LocalCount> localCounts(Collection<Square> squares, SudokuBoard board) {
		return squares.stream()
				.map( square -> new LocalCount(square, candidates(square, board)))
				.collect(Collectors.toList());
	}
	
	static int sortByCandidateTotal(LocalCount localCount1, LocalCount localCount2) {
		return 	Integer.compare(localCount1.candidateTotal(), localCount2.candidateTotal());
	}

	private final Square square;
	private final Set<Integer> candidates;
	
	private LocalCount(Square square, Set<Integer> candidates) {
		this.square = square;
		this.candidates = candidates;
	}

	Square square() {
		return square;
	}

	Set<Integer> candidates() {
		return candidates;
	} 
	
	private int candidateTotal() {
		return candidates.size();
	}
}
