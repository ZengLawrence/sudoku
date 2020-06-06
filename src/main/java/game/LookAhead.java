/**
 * 
 */
package game;

import static java.util.Collections.*;
import static game.LocalCount.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Look ahead at other free squares on the board to try out if candidate may be a viable one.
 * 
 * @author Lawrence
 *
 */
final class LookAhead {

	static Set<Integer> candidates(Coordinate coord, SudokuBoard board) {
		LookAhead lookAhead = forSquare(coord, board);
		return LocalCount.candidates(coord, board).stream()
				.filter( c -> lookAhead.maybeViable(c))
				.collect(Collectors.toSet());
	}
	
	private static LookAhead forSquare(Coordinate coord, SudokuBoard board) {
		Collection<Coordinate> otherFreeSquaresInRow = board.freeSquaresIn(coord.row());
		otherFreeSquaresInRow.remove(coord);
		Collection<Coordinate> otherFreeSquaresInColumn = board.freeSquaresIn(coord.column());
		otherFreeSquaresInColumn.remove(coord);
		Collection<Coordinate> otherFreeSquaresInBox = board.freeSquaresIn(coord.box());
		otherFreeSquaresInBox.remove(coord);
		
		return new LookAhead(
				localCounts(otherFreeSquaresInRow, board), 
				localCounts(otherFreeSquaresInColumn, board), 
				localCounts(otherFreeSquaresInBox, board));
	}
	
	
	
	private final Collection<LocalCount> otherFreeSquaresInRow;
	private final Collection<LocalCount> otherFreeSquaresInColumn;
	private final Collection<LocalCount> otherFreeSquaresInBox;
	
	private LookAhead(Collection<LocalCount> otherFreeSquaresInRow, Collection<LocalCount> otherFreeSquaresInColumn,
			Collection<LocalCount> otherFreeSquaresInBox) {
		this.otherFreeSquaresInRow = unmodifiableCollection(otherFreeSquaresInRow);
		this.otherFreeSquaresInColumn = unmodifiableCollection(otherFreeSquaresInColumn);
		this.otherFreeSquaresInBox = unmodifiableCollection(otherFreeSquaresInBox);
	}
	
	private boolean maybeViable(int candidate) {
		return maybeViable(candidate, otherFreeSquaresInRow) &&
				maybeViable(candidate, otherFreeSquaresInColumn) &&
				maybeViable(candidate, otherFreeSquaresInBox);
	}
	
	private static boolean maybeViable(int candidate, Collection<LocalCount> otherFreeSquares) {
		int freeSquareCount = otherFreeSquares.size();
		long candidateTotal = otherFreeSquares.stream()
				.flatMapToInt(localCount -> localCount.candidates().stream().mapToInt(n -> n))				
				.distinct()
				.filter(n -> n != candidate)
				.count();
		return candidateTotal >= freeSquareCount;
	}
}
