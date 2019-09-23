package LinkedListArray;

public class MergeTwoSortedArrays {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null && B == null){
            return null;
        }
        if (A == null){
            return B;
        }
        if (B == null){
            return A;
        }
        int target = A[0];
        int[] ret = new int[A.length + B.length];
        int i=0;
        int j=0;
        while(true){

            while (i < B.length && B[i] <= target){
                ret[i + j] = B[i];
                i++;
            }
            if (i < B.length){
                target = B[i];
            }

            while (j < A.length && A[j] <= target){
                ret[i + j] = A[j];
                j++;
            }
            if (j < A.length){
                target = A[j];
            }
            if (i == B.length && j == A.length){
                break;
            }
        }
        return ret;
    }
}
