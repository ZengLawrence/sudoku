# Sudoku
This is a Java implementation of solving Sudoku puzzles based on Skiena's backtracking algorithm as described in his book "The Algorithm Design Manual".

## Pruning Strategies
Tow different type of pruning strategies are implemented, selecting next square to fill and suggesting candidates for filling.

### Next Square
1. Sequential - pick the next free square.  This is most simplest and straight forward strategy
1. Most constrained - pick the next free square with fewest candidate numbers available.

### Candidate Suggestion
1. Local count - find candidates from a square after removing values already placed in its row, column or sector.
1. Look ahead - find candidates who would not block other free squares in its row, column or sector.

## Source Code Structures
### Packages
algo - Basic algorithm for backtrack.

game - Solution for solving Sudoku game.

### Example
Run main class 'SudokuCommand'.

Output of 'SudokuCommand':

![Sample output of SudokuCommand](./image/sample_output.png)
