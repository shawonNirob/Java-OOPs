package codingInterview;

public class maxSubArray {
    public int[] maxSubArray(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        int sum = max;

        int[] index = new int[2];
        int startIndex = 0;
        int endIndex = 0;
        for(int i=1; i<n; i++){
            sum += nums[i];
            if(nums[i] > sum){
                sum = nums[i];
                startIndex = i;
                endIndex = i;
            }else{
                endIndex = i;
            }
            if(sum > max){
                max = sum;
                index[0] = startIndex;
                index[1] = endIndex;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums  = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray max  = new maxSubArray();
        int[] ans = max.maxSubArray(nums);

        for(int i=0; i<2; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
