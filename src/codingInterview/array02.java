package codingInterview;

public class array02 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int stock = Integer.MAX_VALUE;
        for(int i=0;  i<prices.length; i++){
            if(stock > prices[i]){
                stock = prices[i];
            }else if(prices[i]-stock > profit){
                profit = prices[i]-stock;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        array02 stock = new array02();
        System.out.println(stock.maxProfit(arr));
    }
}
