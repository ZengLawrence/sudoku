/**
 * 
 */
package game;

import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Collect total runtime and moves made.
 * 
 * @author Lawrence
 *
 */
final class StatsCollector implements SudokuLifeCycle {

	private LocalDateTime startTime;
	private Duration processDuration;
	private long numbMove;
	private int freeSquareCount;
	
	@Override
	public void boardInitialized(SudokuBoard board) {
		startTime = LocalDateTime.now();
		freeSquareCount = board.freeCount();
	}

	@Override
	public void solutionFound(SudokuBoard board) {
		processDuration = Duration.between(startTime, LocalDateTime.now());
	}

	@Override
	public void moveMade(Coordinate coord, int val) {
		numbMove++;
	}

	void print(PrintStream out) {
		out.println("Time taken: " + processDuration);
		out.println("Number of free squares: " + freeSquareCount);
		out.println("Moves made: " + numbMove);
	}
}
