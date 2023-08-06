package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class LiveTest2 {

    //Time -> O(n);
    //Space -> O(n);
    public int[] findtarget(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for(int i=0; i<n; i++){
            int m = target - nums[i];
            if(map.containsKey(m)){
                return new int[] {map.get(m), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,6,9};
        LiveTest2 test = new LiveTest2();
        int[] ans = test.findtarget(arr, 8);

        for (int res : ans){
            System.out.print(res + " ");
        }
    }
}
