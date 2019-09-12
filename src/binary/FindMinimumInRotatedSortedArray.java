package binary;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length==0){
            throw new IllegalArgumentException("array is empty");
        }
        int s=0;
        int e=nums.length-1;
        while(s+1<e){
            int mid=s+(e-s)/2;
            if (nums[mid]>nums[e]){
                s=mid;
            }else{
                e=mid;
            }
        }
        if (nums[e]<nums[s]){
            return nums[e];
        }
        return nums[s];
    }
}
