package binary;

public class SearchForARange {
    private int searchMinAndMax(int[] nums,int targe,int s,int e,int orderNum){
        if (nums.length==0){
            return -1;
        }
        while (s+1<e){
            int mid=s+(e-s)/2;
            if (nums[mid]==targe){
                if (orderNum==1){
                    s=mid;
                }else{
                    e=mid;
                }
            }else if (nums[mid]<targe){
                s=mid;
            }else {
                e=mid;
            }
        }
        if (orderNum==1){
            if (nums[e]==targe){
                return e;
            }
            if (nums[s]==targe){
                return s;
            }
        }else {
            if (nums[s]==targe){
                return s;
            }
            if (nums[e]==targe){
                return e;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] A, int target) {
        int s=0;
        int e=A.length-1;
        int left=searchMinAndMax(A,target,s,e,-1);
        int right=searchMinAndMax(A,target,s,e,1);
        int[] ret=new int[]{left,right};
        return ret;
    }
}
