package AI;

import hashMap.MapEntry;

import java.util.HashMap;
import java.util.Map;

public class MapEntryAI {
    public void checkMap(HashMap<Integer, Integer> map){
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int value = entry.getValue();
            System.out.print(num+"->"+value+" ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,2,3,2,5,6};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        MapEntryAI obj = new MapEntryAI();
        obj.checkMap(map);
    }
}
