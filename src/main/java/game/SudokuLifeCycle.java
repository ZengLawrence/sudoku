package game;

public interface SudokuLifeCycle {
	
	default void boardInitialized(SudokuBoard board) {
		return;
	}

	default void solutionFound(SudokuBoard board) {
		return;
	}
}