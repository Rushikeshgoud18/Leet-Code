class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Helper function for backtracking
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { // If the cell is empty
                    // Try numbers 1-9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            if (solve(board)) { // Recursively solve the rest
                                return true;
                            }
                            board[row][col] = '.'; // Backtrack if no solution
                        }
                    }
                    return false; // If no valid number can be placed, return false
                }
            }
        }
        return true; // If all cells are filled, the Sudoku is solved
    }

    // Helper function to check if placing `num` at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // If no conflicts, the number is valid
    }
}
