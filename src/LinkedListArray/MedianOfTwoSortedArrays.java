package LinkedListArray;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length + B.length;
        if (n % 2 ==0){
            return (findKLarge(A,0,B,0,n/2) + findKLarge(A,0,B,0,n/2 + 1))/2.0;
        }
        return findKLarge(A,0,B,0,n/2 + 1);
    }

    public int findKLarge(int[] A , int startIndexA , int[] B , int startIndexB , int k){
        if (startIndexA >= A.length){
            return B[startIndexB + k -1];
        }
        if (startIndexB >= B.length){
            return A[startIndexA + k -1];
        }
        if (k == 1){
            return Math.min(A[startIndexA] , B[startIndexB]);
        }
        int halfOfA = startIndexA + k/2 - 1 < A.length ? A[startIndexA + k/2 - 1] : Integer.MAX_VALUE;
        int halfOfB = startIndexB + k/2 - 1 < B.length ? B[startIndexB + k/2 - 1] : Integer.MAX_VALUE;

        if (halfOfA > halfOfB){
            return findKLarge(A , startIndexA , B ,startIndexB + k/2 , k - k/2);
        }else{
            return findKLarge(A , startIndexA + k/2 , B ,startIndexB , k - k/2);
        }
    }

}
