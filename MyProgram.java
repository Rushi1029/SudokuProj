//Only made create board on random numbers on this file

public class MyProgram {

    private static Sudoku puzzle;
    private static Cell[][] board;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int[][] board1 = {{7, 6, 1, 5, 4, 9, 2, 8, 3},
                          {2, 4, 8, 3, 7, 1, 6, 5, 9},
                          {9, 5, 3, 6, 8, 2, 1, 4, 7},
                          {5, 1, 4, 7, 6, 3, 8, 9, 2},
                          {6, 2, 7, 9, 5, 8, 4, 3, 1},
                          {3, 8, 9, 2, 1, 4, 5, 7, 6},
                          {8, 9, 5, 1, 2, 7, 3, 6, 4},
                          {1, 3, 6, 4, 9, 5, 7, 2, 8},
                          {4, 7, 2, 8, 3, 6, 9, 1, 5}};

        int[][] board2 = {{6, 5, 9, 0, 0, 2, 0, 7, 0},
                          {6, 2, 0, 5, 7, 0, 4, 0, 8},
                          {4, 7, 0, 0, 0, 3, 0, 9, 2},
                          {8, 0, 0, 2, 9, 0, 6, 0, 7},
                          {3, 6, 0, 0, 5, 0, 0, 1, 4},
                          {0, 0, 7, 0, 6, 4, 8, 0, 5},
                          {0, 9, 4, 8, 0, 6, 0, 5, 3},
                          {2, 0, 0, 0, 0, 5, 0, 8, 0},
                          {0, 8, 0, 1, 3, 0, 2, 4, 0}};

        board = createBoard(board1, false);
        puzzle = new Sudoku(board);
        if (puzzle.isValid()) {
            System.out.println(puzzle + "The solution is valid\n");
        } else {
            System.out.println(puzzle + "The solution is not valid\n");
        }

        board = createBoard(board1, true);
        puzzle = new Sudoku(board);
        if (puzzle.isValid()) {
            System.out.println(puzzle + "The solution is valid\n");
        } else {
            System.out.println(puzzle + "The solution is not valid\n");
        }

        board = createBoard(board2, false);
        puzzle = new Sudoku(board);
        puzzle.createPencilMarks();
        puzzle.createPencilMarks();
        System.out.println(puzzle + "Pencil Marks at (row, col)");
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (!cell.getPencilMarks().isEmpty()) {
                    int num = cell.getCellNum();
                    System.out.print("(" + (num / 9) + "," + (num % 9) + "): ");
                    System.out.println(cell.getPencilMarks());
                }
            }
        }
    }

    public static Cell[][] createBoard(int[][] nums, boolean random) {

        Cell[][] grid = new Cell[9][9];
        int rnd, temp, cellNum;
        int length = 9;

        for (int r = 0; r < length; r++) {
            if (random) {
                for (int c = 0; c < length; c++) {

                    rnd = (int) (Math.random() * 9);
                    temp = nums[r][c];
                    nums[r][c] = nums[r][rnd];
                    nums[r][rnd] = temp;
                }
            }
            for (int c = 0; c < length; c++) {
                cellNum = (r * length) + c;
                grid[r][c] = new Cell(cellNum, nums[r][c]);
            }
        }
        return grid;
    }

}