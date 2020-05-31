package game;

/**
 * Pretty print board to console.
 * 
 * @author Lawrence
 *
 */
final class PrintBoardToConsole implements SudokuLifeCycle {

	@Override
	public void boardInitialized(SudokuBoard board) {
		System.out.println("Initial Board:");
		board.print(System.out);
	}

	@Override
	public void solutionFound(SudokuBoard board) {
		System.out.println("Solution:");
		board.print(System.out);
	}

}
