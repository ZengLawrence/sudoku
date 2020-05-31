package game;

import java.util.Arrays;
import java.util.stream.Stream;

public interface SudokuLifeCycle {
	
	default void boardInitialized(SudokuBoard board) {
		return;
	}

	default void solutionFound(SudokuBoard board) {
		return;
	}
	
	default void moveMade(Coordinate coord, int val) {
		return;
	}

	public static SudokuLifeCycle concat(final SudokuLifeCycle... subscribers) {
		
		return new SudokuLifeCycle() {

			@Override
			public void boardInitialized(SudokuBoard board) {
				Arrays.stream(subscribers).forEach( sub -> sub.boardInitialized(board));
			}

			@Override
			public void solutionFound(SudokuBoard board) {
				Arrays.stream(subscribers).forEach( sub -> sub.solutionFound(board));
			}

			@Override
			public void moveMade(Coordinate coord, int val) {
				Arrays.stream(subscribers).forEach( sub -> sub.moveMade(coord, val));
			}
			
		};
	}
}