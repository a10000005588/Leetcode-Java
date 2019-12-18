// O(n^2)
class Solution {
  public int maxProfit(int[] prices) {
      int maxSoFar = 0;
      
      for(int i=0; i<prices.length; i++) {
          for(int j=i+1;j<prices.length; j++) {
              int profit = (prices[j] - prices[i]);
              if( maxSoFar < profit) {
                  maxSoFar = profit;
              }
          }
      }
      
      return maxSoFar;
  }
}