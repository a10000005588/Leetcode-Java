// 參考後

class Solution {
  public int maxSubArray(int[] nums) {
      int max = Integer.MIN_VALUE;
      int MaxEndingHere = nums[0];
      int MaxSoFar = nums[0];
      
      for(int i=1; i<nums.length; i++) {
          MaxEndingHere = max(MaxEndingHere+nums[i], nums[i]);
          MaxSoFar = max(MaxEndingHere, MaxSoFar);
      }
      
      return MaxSoFar;
  }
  
  public int max(int a, int b) {
      if(a>b) return a;
      return b;
  }
}