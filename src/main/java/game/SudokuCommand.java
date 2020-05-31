/**
 * 
 */
package game;

/**
 * @author Lawrence
 *
 */
public final class SudokuCommand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] startValues = {
				{1, 0, 8, 5, 0, 9, 0, 0, 6},
				{6, 4, 0, 0, 0, 0, 0, 1, 0},
				{9, 0, 0, 0, 0, 6, 8, 4, 7},
				{8, 1, 9, 3, 0, 0, 7, 0, 0},
				{0, 2, 0, 1, 7, 0, 3, 0, 9},
				{5, 0, 0, 0, 0, 2, 1, 6, 0},
				{0, 6, 5, 0, 3, 7, 0, 0, 1},
				{0, 0, 0, 6, 2, 0, 0, 9, 3},
				{0, 0, 4, 0, 0, 0, 0, 7, 0},
		};
		solve(new SudokuBoard(startValues), PruningStrategy.sequentialOrder());
		solve(new SudokuBoard(startValues), PruningStrategy.mostConstrained());
	}

	private static void solve(SudokuBoard board, PruningStrategy pruningStrategy) {
		StatsCollector statsCollector = new StatsCollector();
		Sudoku.solve(board, PruningStrategy.sequentialOrder(), SudokuLifeCycle.concat(statsCollector, new PrintBoardToConsole()));
		statsCollector.print(System.out);
	}

}
