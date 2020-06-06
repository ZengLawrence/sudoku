/**
 * 
 */
package game;

/**
 * Print moves to console.
 * 
 * @author Lawrence
 *
 */
final class PrintMovesToConsole implements SudokuLifeCycle {

	@Override
	public void moveMade(Square square, int val) {
		System.out.println("Square: " + square + " Value: " + val);
	}

}
