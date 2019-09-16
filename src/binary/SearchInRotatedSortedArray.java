package binary;

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A.length==0){
            return -1;
        }
        int s=0;
        int e=A.length-1;
        while(s+1<e){
            int mid=s+(e-s)/2;
            if (A[mid]>A[e]){
                if (A[mid]>target && target>=A[s]) {
                    e=mid;
                }else if (A[mid]==target){
                    return mid;
                }else {
                    s=mid;
                }
            }else{
                if (A[mid]<target && target<=A[e]){
                    s=mid;
                }else if (A[mid]==target){
                    return mid;
                }else {
                    e=mid;
                }
            }
        }
        if (A[s]==target){
            return s;
        }
        if (A[e]==target){
            return e;
        }
        return -1;
    }
}
