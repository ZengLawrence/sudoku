# Sudoku
This is a Java implementation of solving Sudoku puzzles based on Skiena's backtracking algorithm as described in his book "The Algorithm Design Manual".

Two pruning strategies are implemented for selecting the next square to fill:
1. Sequential - pick the next free square.  This is most simplest and straight forward strategy
1. Most constrained - pick the next free square with fewest candidate numbers available.

## Source Code Structures
### Packages
algo - Basic algorithm for backtrack.

game - Solution for solving Sudoku game.

### Example
Run main class 'SudokuCommand'.

Output of 'SudokuCommand':

![Sample output of SudokuCommand](./image/sample_output.png)
