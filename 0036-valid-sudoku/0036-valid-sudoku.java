class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use three arrays of sets to keep track of the numbers seen in rows, columns, and subgrids
        Set<String>[] rows = new HashSet[9];
        Set<String>[] cols = new HashSet[9];
        Set<String>[] subgrids = new HashSet[9];
        
        // Initialize the sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            subgrids[i] = new HashSet<>();
        }

        // Iterate through each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;  // Skip empty cells
                }

                // Check for the current row
                if (rows[i].contains(String.valueOf(num))) {
                    return false;  // Duplicate in the same row
                }
                rows[i].add(String.valueOf(num));

                // Check for the current column
                if (cols[j].contains(String.valueOf(num))) {
                    return false;  // Duplicate in the same column
                }
                cols[j].add(String.valueOf(num));

                // Check for the current 3x3 subgrid
                int subgridIndex = (i / 3) * 3 + (j / 3);
                if (subgrids[subgridIndex].contains(String.valueOf(num))) {
                    return false;  // Duplicate in the same subgrid
                }
                subgrids[subgridIndex].add(String.valueOf(num));
            }
        }

        return true;  // All checks passed
    }
}
