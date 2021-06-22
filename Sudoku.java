import java.util.ArrayList;

//Entire class developed by student (myself)
public class Sudoku {
    
	Cell[][] grid;

	public Sudoku(Cell[][] aGrid) {
		grid = aGrid;
	}

	public boolean isValid() {
		// box
		for (int boxRow = 0; boxRow < grid.length; boxRow += 3) {
			for (int BoxCol = 0; BoxCol < grid[boxRow].length; BoxCol += 3) {
				for (int row = boxRow; row < boxRow + 3; row++) {
					for (int col = BoxCol; col < BoxCol + 3; col++) {
						if (grid[row][col].getValue() == 0) {
							return false;
						}
					//	int currentVal = grid[row][col].getValue();
						int currentRow = row;
						int currentCol = col;
						for (int rowA = boxRow; rowA < boxRow + 3; rowA++) {
							for (int colA = BoxCol; colA < BoxCol + 3; colA++) {
								if (grid[currentRow][currentCol].getValue() == grid[rowA][colA].getValue()
										&& (rowA != currentRow && colA != currentCol)) {
									return false;

								}
							}
						}
					}
				}

			}

		}
		// columns
		for (int row = 0; row < grid.length; row++) {
			if (!horizCheck(grid[row])) {
				return false;
			}

		}
		// rows
		for (int col = 0; col < grid[0].length; col++) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = i + 1; j < grid.length; j++) {
					if (grid[i][col].getValue() == grid[j][col].getValue() || grid[i][col].getValue() == 0
							|| grid[j][col].getValue() == 0) {
						return false;
					}
				}
			}
		}

		return true;

	}

	private boolean horizCheck(Cell[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].getValue() == array[j].getValue() || array[i].getValue() == 0
						|| array[j].getValue() == 0) {
					return false;
				}
			}
		}
		return true;

	}

	public void createPencilMarks() {

		for (int curRow = 0; curRow < grid.length; curRow++) {
			for (int curCol = 0; curCol < grid[curRow].length; curCol++) {
				if (grid[curRow][curCol].getValue() == 0) {
					ArrayList <Integer> pCellValue = new ArrayList<Integer>();
					pCellValue.add(1);
					pCellValue.add(2);
					pCellValue.add(3);
					pCellValue.add(4);
					pCellValue.add(5);
					pCellValue.add(6);
					pCellValue.add(7);
					pCellValue.add(8);
					pCellValue.add(9);
					removeValuesfromCurrentRow(pCellValue, curRow);
					removeValuesfromCurrentCol(pCellValue, curCol);
					removeValuesfromCurrentBox(pCellValue, curRow, curCol);
					grid[curRow][curCol].clearPencilMarks();
					for (int i = 0; i < pCellValue.size(); i++) {
						grid[curRow][curCol].addPencilMark(pCellValue.get(i));
					}

				}

			}
		}

	}

	public String toString() {
		String finalGrid = "";
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				finalGrid += (grid[row][col] + "  ");
				if (col == 2 || col == 5) {
					finalGrid += ("|  ");
				}
			}
			finalGrid += "\n";
			if (row == 2 || row == 5) {
				finalGrid += ("-------------------------------\n");
			}
		}
		return finalGrid;
	}

	private void removeValuesfromCurrentRow(ArrayList<Integer> pCellValue, int row) {
		for (int j = 0; j < grid[row].length; j++) {
			if (grid[row][j].getValue() != 0) {
				for (int z = 0; z < pCellValue.size(); z++) {
					if (pCellValue.get(z) == grid[row][j].getValue()) {
						pCellValue.remove(z);
					}
				}

			}

		}

	}

	private void removeValuesfromCurrentCol(ArrayList<Integer> pCellValue, int col) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][col].getValue() != 0) {
				for (int z = 0; z < pCellValue.size(); z++) {
					if (pCellValue.get(z) == grid[i][col].getValue()) {
						pCellValue.remove(z);
					}
				}
			}
		}
	}

	private void removeValuesfromCurrentBox(ArrayList<Integer> pCellValue, int curRow, int curCol) {
		// find box top left

		int upInd = curRow - (curRow % 3);
		int leftInd = curCol - (curCol % 3);
		for (int row = upInd; row < upInd + 3; row++) {
			for (int col = leftInd; col < leftInd + 3; col++) {
				for (int z = 0; z < pCellValue.size(); z++) {
					if (pCellValue.get(z) == grid[row][col].getValue()) {
						pCellValue.remove(z);
					}
				}
			}
		}
	}
}
