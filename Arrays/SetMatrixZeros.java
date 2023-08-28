package Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean isAnyItemInFirstColumnZero = false;
        int n = matrix.length, m = matrix[0].length;
        for(int i =0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j==0) {
                        isAnyItemInFirstColumnZero = true;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for(int i =1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(matrix[i][j] != 0 && matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for(int j=0; j<m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isAnyItemInFirstColumnZero) {
            for(int i =0; i<n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
