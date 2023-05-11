package generics;

public class BoundedTypes<T extends Number>{
    T[] nums;
    public BoundedTypes(T[] nums){
        this.nums = nums;
    }
    public double average(){
        double sum = 0.0;
        for(T num : nums){
            sum += num.doubleValue();

            //System.out.println(num);
            //System.out.println(num.doubleValue());
        }
        return sum/ nums.length;
    }
    public static void main(String[] args){
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        BoundedTypes<Integer> extend = new BoundedTypes<>(arr);
        System.out.println(extend.average());
    }
}
