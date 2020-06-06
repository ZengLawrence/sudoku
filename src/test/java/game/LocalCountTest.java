package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalCountTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCandidates() {
		int[][] startValues = {
				{0, 1, 0, 0, 0, 0, 0, 0, 0},
				{4, 0, 0, 0, 0, 0, 0, 9, 0},
				{0, 5, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 8, 0, 0, 0, 0, 0, 0, 5},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0},
		};
		SudokuBoard board = new SudokuBoard(startValues);
		
		Set<Integer> expected = new HashSet<>(Arrays.asList(3, 6, 7));
		assertEquals(expected, LocalCount.candidates(new Square(1, 1), board));
	}

}
