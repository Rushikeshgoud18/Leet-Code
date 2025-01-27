class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) return s;  // No zigzag pattern needed
        
        vector<string> rows(min(numRows, int(s.length())));  // To hold the rows
        int currentRow = 0;
        bool goingDown = false;
        
        for (char c : s) {
            rows[currentRow] += c;  // Add the current character to the current row
            
            // If we're at the top or bottom row, reverse the direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to the next row, either down or up
            currentRow += goingDown ? 1 : -1;
        }
        
        // Concatenate all rows to get the result
        string result = "";
        for (const string& row : rows) {
            result += row;
        }
        
        return result;
    }
};
