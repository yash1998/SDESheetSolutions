package Arrays;

public class MatrixSpiral {
    public static int[] spiralMatrix(int [][]mat) {
        int n = mat.length, m = mat[0].length, res[] = new int[n*m], c = 0, top = 0, bottom = n-1, left = 0, right = m-1;

        while(top<= bottom && left<= right) {
            for(int i=left; i <=right; i++) {
                res[c++] = mat[top][i];
            }
            top++;
            for(int i=top; i <=bottom; i++) {
                res[c++] = mat[i][right];
            }
            right--;
            if (top <= bottom) {
                for(int i=right; i >= left; i--) {
                    res[c++] = mat[bottom][i];
                }
                bottom--;
            }
            if (left <= right) {
                for(int i=bottom; i >= top; i--) {
                    res[c++] = mat[i][left];
                }
                left++;
            }
        }
        

        return res;
    }  
}
