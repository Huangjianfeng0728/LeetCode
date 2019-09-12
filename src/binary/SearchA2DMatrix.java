package binary;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int x1=0,y1=0;
        int x2=m-1,y2=n-1;
        while (x1+1<x2){
            int mid=x1+(x2-x1)/2;
            if (matrix[mid][y1]==target){
                return true;
            }else if (matrix[mid][y1]>target){
                x2=mid;
            }else if (matrix[mid][y1]<target){
                x1=mid;
            }
        }
        int x=(matrix[x2][y1])>target?x1:x2;
        while (y1+1<y2){
            int mid=y1+(y2-y1)/2;
            if (matrix[x][mid]==target){
                return true;
            }else if (matrix[x][mid]<target){
                y1=mid;
            }else{
                y2=mid;
            }
        }
        if (matrix[x][y1]==target){
            return true;
        }
        if (matrix[x][y2]==target){
            return true;
        }
        return false;
    }
}
