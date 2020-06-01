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
	public void moveMade(Coordinate coord, int val) {
		System.out.println("Square: " + coord + " Value: " + val);
	}

}
