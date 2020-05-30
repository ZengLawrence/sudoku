package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SudokuBoardTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("complete?  has free space i.e. 0, return false")
	void testIsComplete() {
		
		int[][] startValues = {
				{0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 5},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		SudokuBoard board = new SudokuBoard(startValues);
		assertFalse(board.isComplete());
	}

	@Test
	@DisplayName("complete?  no free space i.e. values 1 - 9, return true")
	void testIsGameFinished2() {
		
		int[][] startValues = {
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
				{1, 1, 1, 4, 5, 6, 6, 8, 9},
		};
		SudokuBoard board = new SudokuBoard(startValues);
		assertTrue(board.isComplete());
	}

}