package hashMap;

import java.util.HashMap;
import java.util.Map;

public class MapEntry {
    public void checkMap(HashMap<Integer, Integer> map){
        for(Map.Entry m : map.entrySet()) {
            System.out.print(m.getKey()+"-"+m.getValue()+" ");
        }
        System.out.println();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int value = entry.getValue();
            System.out.print(num+"->"+value+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {100,100,100,200,200,300,200,300,200,500,600};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        MapEntry obj = new MapEntry();
        obj.checkMap(map);
    }
}