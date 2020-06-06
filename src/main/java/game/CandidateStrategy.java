/**
 * 
 */
package game;

import java.util.Set;

/**
 * Strategy to provide candidate values to fill the next square.
 * 
 * @author Lawrence
 *
 */
public interface CandidateStrategy {

	Set<Integer> candidates(Coordinate coord, SudokuBoard board);
	
	/**
	 * 
	 * @return Candidate values for a free squares after removing values already placed in its row, column or box. 
	 */
	static CandidateStrategy localCount() {
		return LocalCount::candidates;
	}
	
	static CandidateStrategy lookAhead() {
		return LookAhead::candidates;
	}
	
}
