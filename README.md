# SudokuProj

## Context of this project

- This is a project I made during my eleventh grade year for school demonstrating my ability to interpret and traverse more complex data structures such as 2d arrays.

## What does it do
- Sudoku.java Class:

    - Can check if the sudoku board is filled out properly

    - Given the sudoku board intiialized in a 9x9 array list representing the filled in data within a board, the program will be able to determine the "tic marks" or the possible values that can go into the the blank or null items within the array

    - Contains most of the functionality required by the main to run


- MyProgram Class:

    - The main program which initializes the boards to your needs and can be adjusted in the text editor.

    - Gives an example as to creating a completely random board

    - Is the implementation of the sudoku class and cell object.

- Cell Class:

    - Used to make an array list of cell objects with easy access and functionality.

## How?

- isValid()

    - Works by traversing in in 3 different ways checking in each that there is no repeat and that the numbers lie within 1-9 through a for loop iterating through:

        1. 3x3 squares

        2. Rows

        3. Columns

- createPencilMarks()
    1. Works through by walking thorugh the array and checking each element to see if it is blank or with a value of 0

    2. If zero, it initializes an array list of 1-9 for the pencil marks attribute that can be seen in cell.java

    3. After attribute is created, it iterates in the same way as in is valid and sees if any of the values in the 3x3, rows, or columns are within the arraylist and removing them if it is found. 

    4. This process removes any duplicates from the array and board that are in conflict and gives us the possible numbers.

# Next Steps with this Project

- No scheduled plans to adjust anything, might add one more way to iterate all the way through all the possible pencil marks to create a solution.