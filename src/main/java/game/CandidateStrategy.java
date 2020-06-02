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
	
	static CandidateStrategy localCount() {
		return LocalCount::candidates;
	}
	
}
