package binary;
//若允许与重复元素，则只能通过遍历。
public class MaximumNumberInMountainSequence {
    public int mountainSequence(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        int s=0;
        int e=nums.length-1;
        while(s+1<e){
            int mid=s+(e-s)/2;
            if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return nums[mid];
            }else if (nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]){
                s=mid;
            }else if (nums[mid]<nums[mid-1] && nums[mid]>nums[mid+1]){
                e=mid;
            }
        }
        return Math.max(nums[s],nums[e]);
    }
}
