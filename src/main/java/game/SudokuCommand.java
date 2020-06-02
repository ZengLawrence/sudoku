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
		solveMediumComplexityPuzzle();
		
		System.out.println();
		System.out.println();
		
		solveHardComplexityPuzzle();
	}

	private static void solveMediumComplexityPuzzle() {
		System.out.println("Medium complexity puzzle");
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
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Pruning strategies:");
		System.out.println("Next square: sequential order to pick next square");
		System.out.println("Candidate values: local count for any remaing values");
		solve(new SudokuBoard(startValues), 
				PruningStrategy.of(NextSquareStrategy.sequentialOrder(), CandidateStrategy.localCount()));
		
		System.out.println();
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Pruning strategies:");
		System.out.println("Next square: most constrained to pick next square i.e. fewest candidates");
		System.out.println("Candidate values: local count for any remaning values");
		solve(new SudokuBoard(startValues), 
				PruningStrategy.of(NextSquareStrategy.mostConstrained(), CandidateStrategy.localCount()));
	}
	
	private static void solveHardComplexityPuzzle() {
		System.out.println("Hard complexity puzzle");
		int[][] startValues = {
				{0, 0, 0, 0, 0, 0, 0, 1, 2},
				{0, 0, 0, 0, 3, 5, 0, 0, 0},
				{0, 0, 0, 6, 0, 0, 0, 7, 0},
				{7, 0, 0, 0, 0, 0, 3, 0, 0},
				{0, 0, 0, 4, 0, 0, 8, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 2, 0, 0, 0, 0},
				{0, 8, 0, 0, 0, 0, 0, 4, 0},
				{0, 5, 0, 0, 0, 0, 6, 0, 0},
		};
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Pruning strategies:");
		System.out.println("Next square: most constrained to pick next square i.e. fewest candidates");
		System.out.println("Candidate values: local count for any remaning values");
		solve(new SudokuBoard(startValues), 
				PruningStrategy.of(NextSquareStrategy.mostConstrained(), CandidateStrategy.localCount()));
	}

	private static void solve(SudokuBoard board, PruningStrategy pruningStrategy) {
		StatsCollector statsCollector = new StatsCollector();
		// use PrintMovesToConsole to print moves
		Sudoku.solve(board, pruningStrategy, SudokuLifeCycle.concat(statsCollector, new PrintBoardToConsole()));
		statsCollector.print(System.out);
	}

}
