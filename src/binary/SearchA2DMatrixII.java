package binary;

public class SearchA2DMatrixII {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return -1;
        }
        int x=matrix.length-1;
        int y=0;
        int count=0;
        while (x>=0 && y<matrix[0].length){
            if (target<matrix[x][y]){
                x--;
            }else if (target==matrix[x][y]){
                y++;
                count++;
            }else{
                y++;
            }
        }
        return count;
    }
}
