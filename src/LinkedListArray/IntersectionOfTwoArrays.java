package LinkedListArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : nums1){
            set.add(i);

        }
        for (int j : nums2){
            if (set.contains(j)){
                list.add(j);
                set.remove(j);
            }
        }
        int[] ret = new int[list.size()];
        int index = 0;
        for(int i : list){
            ret[index++] = i;
        }
        return  ret;
    }
}
