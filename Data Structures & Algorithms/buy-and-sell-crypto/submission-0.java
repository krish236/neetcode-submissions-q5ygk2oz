class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        int stock = prices[0];

        for(int i = 1; i<n; i++){

            maxProfit = Math.max(maxProfit, prices[i]-stock);
            if(prices[i]<stock){
                stock = prices[i];
            }
        }
        return maxProfit;
    }
}
