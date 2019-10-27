// #121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// my solution..without DP..
class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int buy, profit = 0;
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                profit =  (prices[j]-prices[i]);
                if(max < profit) {
                    max = profit;
                }
            }
        }
        
        if(max < 0) {
            return 0;
        }
        return max;
    }
}

// With one for-loop, time = 1ms...
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int buyPrice = prices[0];
        int profit = 0;
        int MaxProfit = 0;
     
        for(int i=1; i<prices.length; i++) {
            // 若當天的price有大於我當初買進的價格才考慮
            if(prices[i] > buyPrice) {
                // 計算利潤
                profit = prices[i] - buyPrice;
                // 若較大，那就賣出
                if(MaxProfit < profit) {
                    MaxProfit = profit;
                }
            } else { // 沒有的話 買進該天的價格
                buyPrice = prices[i];
            }
                
        }
        
        return MaxProfit;
    }
}
   