class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;           // Number of rows
        int m = matrix[0].length;        // Number of columns
        int col0 = 1;                    // Flag for the first column
        
        // First pass: Identify rows and columns that should be zeroed
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) col0 = 0;  // Mark if the first column should be zeroed
            for (int j = 1; j < m; j++) {     // Start from 1 to leave first column for col0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;         // Mark the first cell of the row
                    matrix[0][j] = 0;         // Mark the first cell of the column
                }
            }
        }
        
        // Second pass: Set matrix elements to zero based on the markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;         // Zero out cells based on the markers
                }
            }
        }
        
        // Handle the first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Handle the first column
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

                    
                
 