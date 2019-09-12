package binary;

public class FirstPositionOfTarget {
    public int binarySearch(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        int s=0;
        int e=nums.length-1;
        while(s+1<e){
            int mid=s+(e-s)/2;
            if (nums[mid]==target && nums[mid-1]!=target){
                return mid;
            }else if (nums[mid]==target && nums[mid-1]==target){
                e=mid;
            }else if (nums[mid]>target){
                e=mid;
            }else{
                s=mid;
            }
        }
        if (nums[s]==target){
            return s;
        }
        if (nums[e]==target){
            return e;
        }
        return -1;
    }
}
