# Sudoku
This is a Java implementation of solving Sudoku puzzles based on Skiena's backtracking algorithm as described in his book ["The Algorithm Design Manual"](http://www.algorist.com/algorist.html).

## First thing first, what is Sudoku?
[Sudoku](https://en.wikipedia.org/wiki/Sudoku) is a puzzle game whose objective is to fill in a 9x9 grid of squares with numbers 1 to 9.  In each row, column, or box (3x3 grid of squares within the grid), there should not be any repeating numbers.  

Note: 'box' is what Skiena called 'sector' in his book.  I use 'box' to be more aligned to what is generally accepted term in Sudoku games.

Example puzzle:

![Example Sudoku puzzle](./image/example_puzzle.png)

Solution:

![Example Sudoku puzzle](./image/example_puzzle_solution.png)

## Pruning Strategies
Tow different type of pruning strategies are implemented, selecting next square to fill and suggesting candidates for filling.

### Next Square
1. Sequential - pick the next free square.  This is most simplest and straight forward strategy
1. Most constrained - pick the next free square with fewest candidate numbers available.

### Candidate Suggestion
1. Local count - find candidates from a square after removing values already placed in its row, column or boxes.
1. Look ahead - find candidates who would not block other free squares in its row, column or sector.

### Comparison of Pruning Strategies
This is a summary of what I think are more interesting comparison of efficacy of each strategy.  Feel free to play with the source code and come up with your own comparison.

Hardware on which processing time is collected on is *puny* Intel Atom Z3735F @ 1.33GHZ with 2GB of RAM memory.

#### Medium Complexity Puzzle Example
Number of free squares in this example is 43.

![Medium Complexity Sudoku puzzle](./image/example_puzzle.png)

Next Square      | Candidate Suggestion | Moves Required | Processing Time |
---------------- | -------------------- | --------------:| ---------------:|
Sequential       | Local Count          | 72             | 97ms            |
Most Constrained | Local Count          | 72             | 62ms            |

#### Hard Complexity Puzzle Example
Number of free squares in this example is 64.  Or only 17 squares filled, which is the lowest possible number of clues.

![Hard Complexity Sudoku puzzle](./image/example_hard_puzzle.png)

Next Square      | Candidate Suggestion | Moves Required | Processing Time |
---------------- | -------------------- | --------------:| ---------------:|
Most Constrained | Local Count          | 10,373         | 1,509ms         |
Most Constrained | Look Ahead           |    440         |   191ms         |

>:information_source:**Take-Home Lesson**:  "Do not optimize prematurely."  Modern hardware is very fast, which simple strategy would be good enough.  Most of puzzle can be solved under 1 second. Even for the hardest one, it takes about 1.5 second with simple pruning strategies on *puny* modern hardware (Intel Atom).  On any respectable laptop or desktop CPU, it will be 2 or 3 times faster.  That means even for hard puzzles, it would be solved under a second.

## Source Code Structures
### Packages
algo - Basic algorithm for backtrack.

game - Solution for solving Sudoku game.

### Example
Run main class 'SudokuCommand'.

Output of 'SudokuCommand':

![Sample output of SudokuCommand](./image/sample_output.png)
