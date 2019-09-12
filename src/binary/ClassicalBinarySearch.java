package binary;

public class ClassicalBinarySearch {
    public int findPosition(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        int s=0;
        int e=nums.length-1;
        while(s+1<e){
            int mid=s+(e-s)/2;
            if (target==nums[mid]){
                return mid;
            }else if (target>nums[mid]){
                s=mid;
            }else if (target<nums[mid]){
                e=mid;
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
