package binary;

public class FindPeakElement {
    public int findPeak(int[] A) {
        int s=0;
        int e=A.length-1;
        while(s+1<e){
            int mid=s+(e-s)/2;
            if (A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                return mid;
            }else if (A[mid]>A[mid-1] && A[mid]<A[mid+1]){
                s=mid;
            }else {
                e=mid;
            }
        }
        if (A[s]>A[e]){
            return s;
        }
        return e;
    }
}
